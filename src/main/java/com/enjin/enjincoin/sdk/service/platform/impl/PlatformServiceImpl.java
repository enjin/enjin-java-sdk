package com.enjin.enjincoin.sdk.service.platform.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.platform.GetPlatformResult;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class PlatformServiceImpl extends GraphQLServiceBase implements PlatformService {

    private PlatformRetrofitService service;

    public PlatformServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(PlatformRetrofitService.class);
    }

    @Override
    public void getPlatformAsync(final HttpCallback<GraphQLResponse<GetPlatformResult>> callback) {
        enqueueGraphQLCall(getPlatform(), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<GetPlatformResult>> getPlatformSync() throws IOException {
        return executeGraphQLCall(getPlatform());
    }

    private Call<GraphQLResponse<GetPlatformResult>> getPlatform() {
        return this.service.getPlatform(GraphQLRequest.builder());
    }
}
