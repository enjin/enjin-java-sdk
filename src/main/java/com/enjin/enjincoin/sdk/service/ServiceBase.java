package com.enjin.enjincoin.sdk.service;

import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import retrofit2.Call;

import java.io.IOException;

public class ServiceBase {

    private static final Gson GSON = new GsonBuilder().create();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    protected <T> HttpResponse<T> execute(Call<T> call) throws IOException {
        retrofit2.Response<T> response = call.execute();
        return new HttpResponse<>(response.code(), response.body());
    }

    protected <T> void enqueue(Call<T> call, HttpCallback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                callback.onComplete(new HttpResponse<>(response.code(), response.body()));
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Exception exception = new Exception("There was an error while processing a request or a response.", t);
                exception.printStackTrace();
            }
        });
    }
}
