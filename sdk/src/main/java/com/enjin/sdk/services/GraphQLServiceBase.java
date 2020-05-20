package com.enjin.sdk.services;

import java.util.logging.Level;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Base class for GraphQL services.
 *
 * @see ServiceBase
 */
@Log
public class GraphQLServiceBase extends ServiceBase {

    private static final Gson GSON = new GsonBuilder().create();
    private static final MediaType JSON = MediaType.parse("application/json");

    /**
     * Executes a GraphQL request.
     *
     * @param call the request call
     * @param <T>  the type of the request and response
     * @return     the response
     */
    @SneakyThrows
    protected <T> HttpResponse<GraphQLResponse<T>> executeGraphQLCall(Call<GraphQLResponse<T>> call) {
        retrofit2.Response<GraphQLResponse<T>> response = call.execute();
        return createResult(response);
    }

    /**
     * Queues a GraphQL request.
     *
     * @param call     the request call
     * @param callback the callback
     * @param <T>      the type of the request and response
     */
    protected <T> void enqueueGraphQLCall(Call<GraphQLResponse<T>> call, final HttpCallback<GraphQLResponse<T>> callback) {
        call.enqueue(new retrofit2.Callback<GraphQLResponse<T>>() {
            @Override
            public void onResponse(Call<GraphQLResponse<T>> call, retrofit2.Response<GraphQLResponse<T>> response) {
                try {
                    HttpResponse<GraphQLResponse<T>> res = createResult(response);
                    callback.onComplete(res);
                } catch (Exception e) {
                    GraphQLServiceBase.log.log(Level.SEVERE, "An exception occurred:", e);
                }
            }

            @Override
            public void onFailure(Call<GraphQLResponse<T>> call, Throwable t) {
                Exception exception = new Exception("Request Failed: " + call.request().toString(), t);
                GraphQLServiceBase.log.log(Level.SEVERE, "An exception occurred:", exception);
            }
        });
    }

    /**
     * Wraps an http response.
     *
     * @param response the response
     * @param <T>      the type of the response
     * @return         the response wrapper
     */
    @SneakyThrows
    protected <T> HttpResponse<GraphQLResponse<T>> createResult(retrofit2.Response<GraphQLResponse<T>> response) {
        int code = response.code();
        GraphQLResponse<T> body = null;

        if (response.isSuccessful() || response.body() != null) {
            body = response.body();
        } else if (response.errorBody() != null) {
            ResponseBody errorBody = response.errorBody();
            if (errorBody.contentType().equals(JSON)) {
                TypeToken token = new TypeToken<GraphQLResponse<T>>(){};
                String rawBody = errorBody.string();
                body = (GraphQLResponse<T>) GSON.fromJson(rawBody, token.getRawType());
            }
        }

        return new HttpResponse<>(code, body);
    }
}
