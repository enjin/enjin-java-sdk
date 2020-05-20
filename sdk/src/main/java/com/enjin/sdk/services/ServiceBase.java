package com.enjin.sdk.services;

import java.util.logging.Level;

import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import retrofit2.Call;

/**
 * Base class for services.
 */
@Log
public class ServiceBase {

    /**
     * Executes a http request.
     *
     * @param call the request call
     * @param <T>  the type of the request and response
     * @return     the response
     */
    @SneakyThrows
    protected <T> HttpResponse<T> execute(Call<T> call) {
        retrofit2.Response<T> response = call.execute();
        return new HttpResponse<>(response.code(), response.body());
    }

    /**
     * Queues a http request.
     *
     * @param call     the request call
     * @param callback the callback
     * @param <T>      the type of the request and response
     */
    protected <T> void enqueue(Call<T> call, final HttpCallback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                callback.onComplete(new HttpResponse<>(response.code(), response.body()));
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                ServiceBase.log.log(Level.WARNING, "There was an error while processing a request or a response.", t);
            }
        });
    }
}
