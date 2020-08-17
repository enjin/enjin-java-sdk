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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
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
 * TODO
 */
@Log
public class BaseSchema {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer())
            .serializeSpecialFloatingPointValues()
            .enableComplexMapKeySerialization()
            .setLenient()
            .create();
    private static final MediaType JSON = MediaType.parse("application/json");

    private final Retrofit retrofit;
    protected final TrustedPlatformMiddleware middleware;
    protected final String schema;

    /**
     * TODO
     * @param middleware
     */
    public BaseSchema(TrustedPlatformMiddleware middleware, String schema) {
        this.schema = schema;
        this.middleware = middleware;

        Converter.Factory gsonFactory = GsonConverterFactory.create(GSON);
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.middleware.getBaseUrl())
                .client(this.middleware.getHttpClient())
                .addConverterFactory(GraphConverter.create())
                .addConverterFactory(JsonStringConverter.create(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    /**
     * TODO
     * @param request
     * @param <T>
     * @return
     */
    protected <T extends GraphQLRequest<T>> JsonObject createRequestBody(GraphQLRequest<T> request) {
        JsonObject requestBody = new JsonObject();

        JsonObject variables = new JsonObject();
        request.getVariables().forEach((key, value) -> variables.add(key, GSON.toJsonTree(value)));

        requestBody.addProperty("query", middleware.getQueryRegistry().get(request.getNamespace()));
        requestBody.add("variables", variables);

        return requestBody;
    }

    /**
     * TODO
     * @param service
     * @param <T>
     * @return
     */
    protected <T> Object createService(@NotNull Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * TODO
     * @param call
     * @param <T>
     * @return
     * @throws IOException
     */
    @NotNull
    @SneakyThrows
    protected <T> GraphQLResponse<T> sendRequest(Call<GraphQLResponse<T>> call) {
        Response<GraphQLResponse<T>> response = call.execute();
        return createResult(response).body();
    }

    /**
     * TODO
     * @param call the request call
     * @param callback the callback
     * @param <T> the type of the request and response
     */
    protected <T> void sendRequest(Call<GraphQLResponse<T>> call, final HttpCallback<GraphQLResponse<T>> callback) {
        call.enqueue(new Callback<GraphQLResponse<T>>() {
            @Override
            public void onResponse(@NotNull Call<GraphQLResponse<T>> call,
                                   @NotNull Response<GraphQLResponse<T>> response) {
                try {
                    callback.onComplete(createResult(response));
                } catch (Exception e) {
                    log.log(Level.SEVERE, "An exception occurred:", e);
                }
            }

            @Override
            public void onFailure(@NotNull Call<GraphQLResponse<T>> call,
                                  @NotNull Throwable throwable) {
                Exception exception = new Exception("Request Failed: " + call.request().toString(), throwable);
                log.log(Level.SEVERE, "An exception occurred:", exception);
            }
        });
    }

    /**
     * Wraps an http response.
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
