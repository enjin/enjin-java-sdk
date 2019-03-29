package com.enjin.enjincoin.sdk.service;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import retrofit2.Call;

import java.io.IOException;

public class ServiceBase {

    protected <T> Response<T> execute(Call<T> call) throws IOException {
        retrofit2.Response<T> response = call.execute();
        return new Response<>(response.code(), response.body());
    }

    protected <T> void enqueue(Call<T> call, Callback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                callback.onComplete(new Response<>(response.code(), response.body()));
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                // Should we be doing something here?
            }
        });
    }
}
