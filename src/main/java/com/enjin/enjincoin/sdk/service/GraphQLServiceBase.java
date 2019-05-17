package com.enjin.enjincoin.sdk.service;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.lang.reflect.Type;

public class GraphQLServiceBase extends ServiceBase {

    private static final Gson      GSON = new GsonBuilder().create();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    protected <T> HttpResponse<T> executeGraphQLCall(Call<T> call) throws IOException {
        retrofit2.Response<T> response = call.execute();
        return createResult(response);
    }

    protected <T> void enqueueGraphQLCall(Call<T> call, HttpCallback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                try {
                    callback.onComplete(createResult(response));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Exception exception = new Exception("Request Failed: " + call.request().toString(), t);
                exception.printStackTrace();
            }
        });
    }

    protected <T> HttpResponse<T> createResult(retrofit2.Response<T> response) throws IOException {
        int code = response.code();
        T   body = null;

        if (response.isSuccessful() || response.body() != null) {
            body = response.body();
        } else if (response.errorBody() != null) {
            ResponseBody errorBody = response.errorBody();
            if (errorBody.contentType().equals(JSON)) {
                Type type = new TypeToken<T>() {}.getType();
                body = GSON.fromJson(errorBody.string(), type);
            }
        }

        return new HttpResponse<>(code, body);
    }
}
