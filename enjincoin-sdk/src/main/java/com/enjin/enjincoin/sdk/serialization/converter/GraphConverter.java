package com.enjin.enjincoin.sdk.serialization.converter;

import com.enjin.enjincoin.sdk.graphql.GraphQLError;
import com.enjin.enjincoin.sdk.graphql.GraphQLProcessor;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLTemplate;
import com.enjin.enjincoin.sdk.model.service.PaginationCursor;
import com.enjin.enjincoin.sdk.serialization.BigIntegerDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.extern.java.Log;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Body for GraphQL requests and responses, closed for modification
 * but open for extension.
 */
@Log
public class GraphConverter extends Converter.Factory {

    protected GraphQLProcessor graphProcessor;

    protected final JsonParser parser = new JsonParser();
    protected final Gson       gson   = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setLenient()
            .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer())
            .create();

    /**
     * Protected constructor because we want to make use of the
     * Factory Pattern to create our converter
     * <br>
     */
    protected GraphConverter() {
        this.graphProcessor = GraphQLProcessor.getInstance();
    }

    /**
     * HttpResponse body converter delegates logic processing to a child class that handles
     * wrapping and deserialization of the json response results.
     *
     * @param annotations All the annotation applied to the requesting Call method
     * @param retrofit    The retrofit object representing the response
     * @param type        The generic type declared on the Call method
     *
     * @see GraphResponseConverter
     * <br>
     * @see retrofit2.Call
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type              rawType           = parameterizedType.getRawType();
            if (rawType == GraphQLResponse.class) {
                return new GraphResponseConverter<>(parameterizedType);
            }
        }

        return null;
    }

    /**
     * HttpResponse body converter delegates logic processing to a child class that handles
     * wrapping and deserialization of the json response results.
     *
     * @param parameterAnnotations All the annotation applied to request parameters
     * @param methodAnnotations    All the annotation applied to the requesting method
     * @param retrofit             The retrofit object representing the response
     * @param type                 The type of the parameter of the request
     *
     * @see GraphRequestConverter
     * <br>
     */
    @Override
    public Converter<GraphQLRequest<?>, RequestBody> requestBodyConverter(Type type,
                                                                       Annotation[] parameterAnnotations,
                                                                       Annotation[] methodAnnotations,
                                                                       Retrofit retrofit) {
        if (GraphQLRequest.class.isAssignableFrom((Class<?>) type)) {
            return new GraphRequestConverter(methodAnnotations);
        }

        return null;
    }

    public static GraphConverter create() {
        return new GraphConverter();
    }

    /**
     * GraphQL response body converter to unwrap nested object results,
     * resulting in a smaller generic tree for requests
     */
    protected class GraphResponseConverter<T> implements Converter<ResponseBody, GraphQLResponse<T>> {
        protected ParameterizedType graphResponseType;
        protected Type              resultType;

        protected GraphResponseConverter(ParameterizedType graphResponseType) {
            this.graphResponseType = graphResponseType;
            this.resultType = graphResponseType.getActualTypeArguments()[0];
        }

        /**
         * Converter contains logic on how to handle responses, since GraphQL responses follow
         * the JsonAPI spec it makes sense to wrap our base query response results and errors response
         * in here, the logic remains open to the implementation
         * <br>
         *
         * @param responseBody The retrofit response body received from the network
         *
         * @return The type declared in the Call of the request
         */
        @Override
        public GraphQLResponse<T> convert(ResponseBody responseBody) {
            String             raw    = null;
            T                  result = null;
            List<GraphQLError> errors = null;
            PaginationCursor   cursor = null;

            try {
                raw = responseBody.string();

                JsonElement elem = parser.parse(raw);
                if (elem.isJsonObject()) {
                    JsonObject root = elem.getAsJsonObject();
                    result = getResult(root);
                    errors = getErrors(root);
                    cursor = getCursor(root);
                }
            } catch (IOException e) {
                GraphConverter.log.log(Level.SEVERE,"An exception occurred:", e);
            }

            GraphQLResponse<T> response = new GraphQLResponse<>(raw, result, errors, cursor);

            return response;
        }

        private T getResult(JsonObject root) {
            T res = null;

            if (root.has("data")) {
                JsonElement elem = root.get("data");
                if (elem.isJsonObject()) {
                    JsonObject data = elem.getAsJsonObject();
                    if (data.has("result")) {
                        elem = data.get("result");
                        if (elem.isJsonObject()) {
                            JsonObject result = elem.getAsJsonObject();
                            if (result.has("items") && result.has("cursor")) {
                                res = gson.fromJson(result.get("items"), resultType);
                            } else {
                                res = gson.fromJson(result, resultType);
                            }
                        } else if (elem.isJsonArray()) {
                            res = gson.fromJson(elem, resultType);
                        }
                    }
                }
            }

            return res;
        }

        private List<GraphQLError> getErrors(JsonObject root) {
            List<GraphQLError> errors = null;

            if (root.has("errors")) {
                errors = gson.fromJson(root.get("errors"),
                                       TypeToken.getParameterized(ArrayList.class, GraphQLError.class).getType());
            }

            return errors;
        }

        private PaginationCursor getCursor(JsonObject root) {
            PaginationCursor cursor = null;

            if (root.has("data")) {
                JsonElement elem = root.get("data");
                if (elem.isJsonObject()) {
                    JsonObject data = elem.getAsJsonObject();
                    if (data.has("result")) {
                        elem = data.get("result");
                        if (elem.isJsonObject()) {
                            JsonObject result = elem.getAsJsonObject();
                            if (result.has("cursor")) {
                                cursor = gson.fromJson(result.get("cursor"), PaginationCursor.class);
                            }
                        }
                    }
                }
            }

            return cursor;
        }
    }

    /**
     * GraphQL request body converter and injector, uses method annotation for a given retrofit call
     */
    protected class GraphRequestConverter implements Converter<GraphQLRequest<?>, RequestBody> {
        protected Annotation[] methodAnnotations;

        protected GraphRequestConverter(Annotation[] methodAnnotations) {
            this.methodAnnotations = methodAnnotations;
        }

        /**
         * Converter for the request body, gets the GraphQL query from the method annotation
         * and constructs a GraphQL request body to send over the network.
         * <br>
         *
         * @param request The constructed builder method of your query with variables
         *
         * @return Request body
         */
        @Override
        public RequestBody convert(GraphQLRequest<?> request) {
            GraphQLTemplate template = graphProcessor.getTemplate(methodAnnotations);

            JsonObject body = new JsonObject();
            body.addProperty("query", template.serialize(request.parameters()));
            String queryJson = gson.toJson(body);
            return RequestBody.create(MediaType.parse("application/graphql"), queryJson);
        }
    }
}
