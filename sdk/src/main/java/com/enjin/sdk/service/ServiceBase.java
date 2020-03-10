package com.enjin.sdk.service;

import java.io.IOException;
import java.util.logging.Level;

import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;

import lombok.extern.java.Log;
import retrofit2.Call;

@Log
public class ServiceBase {

    protected <T> HttpResponse<T> execute(Call<T> call) throws IOException {
        retrofit2.Response<T> response = call.execute();
        return new HttpResponse<>(response.code(), response.body());
    }

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
