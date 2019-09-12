package com.enjin.sdk.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;

import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import lombok.extern.java.Log;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;

@Log
public class GraphQLServiceBase extends ServiceBase {

    private static final Gson GSON = new GsonBuilder().create();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    protected <T> HttpResponse<T> executeGraphQLCall(Call<T> call) throws IOException {
        retrofit2.Response<T> response = call.execute();
        return createResult(response);
    }

    protected <T> void enqueueGraphQLCall(Call<T> call, final HttpCallback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                try {
                    callback.onComplete(createResult(response));
                } catch (IOException e) {
                    GraphQLServiceBase.log.log(Level.SEVERE, "An exception occurred:", e);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Exception exception = new Exception("Request Failed: " + call.request().toString(), t);
                GraphQLServiceBase.log.log(Level.SEVERE, "An exception occurred:", exception);
            }
        });
    }

    protected <T> HttpResponse<T> createResult(retrofit2.Response<T> response) throws IOException {
        int code = response.code();
        T body = null;

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
