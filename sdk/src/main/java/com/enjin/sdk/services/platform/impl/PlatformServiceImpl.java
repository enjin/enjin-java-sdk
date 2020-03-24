package com.enjin.sdk.services.platform.impl;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.platform.PlatformDetails;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.platform.PlatformService;

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
    public HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync() {
        return executeGraphQLCall(getPlatform());
    }

    private Call<GraphQLResponse<PlatformDetails>> getPlatform() {
        return this.service.getPlatform(new GraphQLRequest());
    }
}
