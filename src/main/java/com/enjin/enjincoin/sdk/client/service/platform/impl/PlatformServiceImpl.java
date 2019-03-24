package com.enjin.enjincoin.sdk.client.service.platform.impl;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.client.service.platform.vo.data.PlatformData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class PlatformServiceImpl implements PlatformService {

    private PlatformRetrofitService service;

    public PlatformServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(PlatformRetrofitService.class);
    }

    @Override
    public void getPlatformAsync(final Callback<GraphQLResponse<PlatformData>> callback) {
        final Call<GraphQLResponse<PlatformData>> call = getPlatform();
        call.enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse<PlatformData>> getPlatformSync() throws IOException {
        final Call<GraphQLResponse<PlatformData>> call = getPlatform();
        return call.execute();
    }

    private Call<GraphQLResponse<PlatformData>> getPlatform() {
        return this.service.getPlatform(GraphQLRequest.builder());
    }
}
