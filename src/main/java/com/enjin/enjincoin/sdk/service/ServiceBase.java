package com.enjin.enjincoin.sdk.service;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.attribute.GraphError;
import com.enjin.enjincoin.sdk.util.GraphErrorUtil;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

public class ServiceBase {

    protected <T> Response<T> execute(Call<T> call) throws IOException {
        retrofit2.Response<T> response = call.execute();
        return new Response<>(response.code(), response.body());
    }

    protected <T> void enqueue(Call<T> call, Callback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                if (response.errorBody() != null) {
                    ResponseBody errorBody = response.errorBody();
                    if (errorBody.contentType().subtype() != null
                            && errorBody.contentType().subtype().equalsIgnoreCase("json")) {
                        List<GraphError> errors = null;

                        try {
                            errors = GraphErrorUtil.getGraphQLError(errorBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        callback.onComplete(new Response<>(response.code(), errors));
                    }
                } else {
                    callback.onComplete(new Response<>(response.code(), response.body()));
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Exception exception = new Exception("There was an error while processing a request or a response.");
                exception.printStackTrace();
            }
        });
    }
}
