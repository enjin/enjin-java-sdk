package com.enjin.enjincoin.sdk.service.platform.impl;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.platform.GetPlatformResult;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.util.concurrent.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class PlatformServiceImpl extends ServiceBase implements PlatformService {

    private PlatformRetrofitService service;

    public PlatformServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(PlatformRetrofitService.class);
    }

    @Override
    public void getPlatformAsync(final Callback<GraphQLResponse<GetPlatformResult>> callback) {
        enqueue(getPlatform(), callback);
    }

    @Override
    public Response<GraphQLResponse<GetPlatformResult>> getPlatformSync() throws IOException {
        return execute(getPlatform());
    }

    private Call<GraphQLResponse<GetPlatformResult>> getPlatform() {
        return this.service.getPlatform(GraphQLRequest.builder());
    }
}
