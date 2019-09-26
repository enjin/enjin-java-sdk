package com.enjin.enjincoin.sdk.service.platform.impl;

import java.io.IOException;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;

import retrofit2.Call;
import retrofit2.Retrofit;

public class PlatformServiceImpl extends GraphQLServiceBase implements PlatformService {

    private PlatformRetrofitService service;

    public PlatformServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(PlatformRetrofitService.class);
    }

    @Override
    public void getPlatformAsync(HttpCallback<GraphQLResponse<PlatformDetails>> callback) {
        enqueueGraphQLCall(getPlatform(), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync() throws IOException {
        return executeGraphQLCall(getPlatform());
    }

    private Call<GraphQLResponse<PlatformDetails>> getPlatform() {
        return this.service.getPlatform(new GraphQLRequest());
    }
}
