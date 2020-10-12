package com.enjin.sdk.schemas;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;
import java.util.logging.Level;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;

import com.enjin.sdk.serialization.BigIntegerDeserializer;
import com.enjin.sdk.serialization.converter.GraphConverter;
import com.enjin.sdk.serialization.converter.JsonStringConverter;
import com.enjin.sdk.utils.LoggerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Base class for schema with functionality to send GraphQL requests to the platform and process the responses.
 */
public class BaseSchema {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer())
            .enableComplexMapKeySerialization()
            .setLenient()
            .create();
    private static final MediaType JSON = MediaType.parse("application/json");

    /**
     * -- Getter --
     * @return the logger provider
     */
    @Getter
    private final LoggerProvider loggerProvider;

    private final Retrofit retrofit;
    protected final TrustedPlatformMiddleware middleware;
    protected final String schema;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware the middleware
     * @param schema the schema
     * @param loggerProvider the logger provider
     */
    public BaseSchema(TrustedPlatformMiddleware middleware, String schema, LoggerProvider loggerProvider) {
        this.schema = schema;
        this.middleware = middleware;
        this.loggerProvider = loggerProvider;

        Gson gson = new GsonBuilder()
                .serializeSpecialFloatingPointValues()
                .create();
        Converter.Factory gsonFactory = GsonConverterFactory.create(gson);
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.middleware.getBaseUrl())
                .client(this.middleware.getHttpClient())
                .addConverterFactory(GraphConverter.create())
                .addConverterFactory(JsonStringConverter.create(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    /**
     * Creates the serialized request body to be sent to the platform.
     *
     * @param request the request
     * @param <T> the type of the request
     * @return the serialized request
     */
    protected <T extends GraphQLRequest<T>> JsonObject createRequestBody(GraphQLRequest<T> request) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("query", middleware.getQueryRegistry().get(request.getNamespace()));
        requestBody.add("variables", GSON.toJsonTree(request.getVariables()));
        return requestBody;
    }

    /**
     * Creates a retrofit service.
     *
     * @param service the service class
     * @param <T> the type of the service
     * @return the created service
     */
    protected <T> Object createService(@NotNull Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * Sends a request synchronously.
     *
     * @param call the call
     * @param <T> the type of the response
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    @NotNull
    @SneakyThrows
    protected <T> GraphQLResponse<T> sendRequest(Call<GraphQLResponse<T>> call) {
        Response<GraphQLResponse<T>> response = call.execute();
        return createResult(response).body();
    }

    /**
     * Sends a request asynchronously with a callback to be used once a response is received.
     *
     * @param call the call
     * @param callback the callback
     * @param <T> the type of the response
     */
    protected <T> void sendRequest(Call<GraphQLResponse<T>> call, final HttpCallback<GraphQLResponse<T>> callback) {
        call.enqueue(new Callback<GraphQLResponse<T>>() {
            @Override
            public void onResponse(@NotNull Call<GraphQLResponse<T>> call,
                                   @NotNull Response<GraphQLResponse<T>> response) {
                try {
                    callback.onComplete(createResult(response));
                } catch (Exception e) {
                    loggerProvider.log(Level.SEVERE, "An exception occurred:", e);
                }
            }

            @Override
            public void onFailure(@NotNull Call<GraphQLResponse<T>> call,
                                  @NotNull Throwable throwable) {
                Exception exception = new Exception("Request Failed: " + call.request().toString(), throwable);
                loggerProvider.log(Level.SEVERE, "An exception occurred:", exception);
            }
        });
    }

    /**
     * Wraps an HTTP response.
     *
     * @param response the response
     * @param <T> the type of the response
     * @return the response wrapper
     */
    @SneakyThrows
    protected <T> HttpResponse<GraphQLResponse<T>> createResult(Response<GraphQLResponse<T>> response) {
        int code = response.code();
        GraphQLResponse<T> body = null;

        if (response.isSuccessful() || response.body() != null) {
            body = response.body();
        } else if (response.errorBody() != null) {
            ResponseBody errorBody = response.errorBody();
            if (Objects.equals(errorBody.contentType(), JSON)) {
                TypeToken<GraphQLResponse<T>> token = new TypeToken<GraphQLResponse<T>>(){};
                String rawBody = errorBody.string();
                body = (GraphQLResponse<T>) GSON.fromJson(rawBody, token.getRawType());
            }
        }

        return new HttpResponse<>(code, body);
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public static String version() {
        return "@version@";
    }

}
