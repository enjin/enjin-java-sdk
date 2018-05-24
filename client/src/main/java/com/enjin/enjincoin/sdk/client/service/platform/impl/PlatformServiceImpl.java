package com.enjin.enjincoin.sdk.client.service.platform.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class PlatformServiceImpl implements PlatformService {

    private GraphQLRetrofitService service;

    public PlatformServiceImpl(GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void getPlatformAsync(Callback<JsonElement> callback) {
        Call<JsonElement> call = getPlatform();
        call.enqueue(callback);
    }

    @Override
    public Response<JsonElement> getPlatformSync() throws IOException {
        Call<JsonElement> call = getPlatform();
        return call.execute();
    }

    private Call<JsonElement> getPlatform() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/platform/getPlatform.query")
                .build().call();
    }
}
