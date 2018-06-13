package com.enjin.enjincoin.sdk.client.converter;

import com.enjin.enjincoin.sdk.client.annotation.processor.GraphProcessor;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Body for GraphQL requests and responses, closed for modification
 * but open for extension.
 */

public class GraphConverter extends Converter.Factory {

    protected GraphProcessor graphProcessor;

    protected final Gson gson = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setLenient()
            .create();

    /**
     * Protected constructor because we want to make use of the
     * Factory Pattern to create our converter
     * <br/>
     */
    protected GraphConverter() {
        this.graphProcessor = GraphProcessor.getInstance();
    }

    /**
     * Response body converter delegates logic processing to a child class that handles
     * wrapping and deserialization of the json response data.
     * @see GraphResponseConverter
     * <br/>
     *
     * @param annotations All the annotation applied to the requesting Call method
     *                    @see retrofit2.Call
     * @param retrofit The retrofit object representing the response
     * @param type The generic type declared on the Call method
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type instanceof GraphQLResponse) {
             return new GraphResponseConverter<>(type);
        }

        return null;
    }

    /**
     * Response body converter delegates logic processing to a child class that handles
     * wrapping and deserialization of the json response data.
     * @see GraphRequestConverter
     * <br/>
     *
     * @param parameterAnnotations All the annotation applied to request parameters
     * @param methodAnnotations All the annotation applied to the requesting method
     * @param retrofit The retrofit object representing the response
     * @param type The type of the parameter of the request
     */
    @Override
    public Converter<GraphQLRequest.Builder, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        if (type instanceof GraphQLRequest.Builder) {
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
    protected class GraphResponseConverter<T> implements Converter<ResponseBody, T> {
        protected Type type;

        protected GraphResponseConverter(Type type) {
            this.type = type;
        }

        /**
         * Converter contains logic on how to handle responses, since GraphQL responses follow
         * the JsonAPI spec it makes sense to wrap our base query response data and errors response
         * in here, the logic remains open to the implementation
         * <br/>
         *
         * @param responseBody The retrofit response body received from the network
         * @return The type declared in the Call of the request
         */
        @Override
        public T convert(ResponseBody responseBody) {
            T response = null;
            try {
                String responseString = responseBody.string();
                response = gson.fromJson(responseString, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }
    }

    /**
     * GraphQL request body converter and injector, uses method annotation for a given retrofit call
     */
    protected class GraphRequestConverter implements Converter<GraphQLRequest.Builder, RequestBody> {
        protected Annotation[] methodAnnotations;

        protected GraphRequestConverter(Annotation[] methodAnnotations) {
            this.methodAnnotations = methodAnnotations;
        }

        /**
         * Converter for the request body, gets the GraphQL query from the method annotation
         * and constructs a GraphQL request body to send over the network.
         * <br/>
         *
         * @param containerBuilder The constructed builder method of your query with variables
         * @return Request body
         */
        @Override
        public RequestBody convert(GraphQLRequest.Builder containerBuilder) {
            GraphQLRequest queryContainer = containerBuilder
                    .withQuery(graphProcessor.getQuery(methodAnnotations))
                    .build();
            JsonObject body = new JsonObject();
            body.addProperty("query", queryContainer.getFormattedQuery());
            String queryJson = gson.toJson(body);
            return RequestBody.create(MediaType.parse("application/graphql"), queryJson);
        }
    }
}
