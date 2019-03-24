package com.enjin.enjincoin.sdk.client.service.platform.impl;

import com.enjin.enjincoin.sdk.client.Callback;
import com.enjin.enjincoin.sdk.client.Response;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.ServiceBase;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.client.service.platform.vo.data.PlatformData;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class PlatformServiceImpl extends ServiceBase implements PlatformService {

    private PlatformRetrofitService service;

    public PlatformServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(PlatformRetrofitService.class);
    }

    @Override
    public void getPlatformAsync(final Callback<GraphQLResponse<PlatformData>> callback) {
        enqueue(getPlatform(), callback);
    }

    @Override
    public Response<GraphQLResponse<PlatformData>> getPlatformSync() throws IOException {
        return execute(getPlatform());
    }

    private Call<GraphQLResponse<PlatformData>> getPlatform() {
        return this.service.getPlatform(GraphQLRequest.builder());
    }
}
