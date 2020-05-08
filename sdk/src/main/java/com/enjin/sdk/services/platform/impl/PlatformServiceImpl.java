package com.enjin.sdk.services.platform.impl;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.platform.GetPlatform;
import com.enjin.sdk.models.platform.PlatformDetails;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.platform.PlatformService;

import retrofit2.Retrofit;

/**
 * Implementation class of {@link PlatformService}.
 *
 * @see PlatformService
 */
public class PlatformServiceImpl extends GraphQLServiceBase implements PlatformService {

    private PlatformRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit a retrofit adapter.
     */
    public PlatformServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(PlatformRetrofitService.class);
    }

    @Override
    public void getPlatformAsync(GetPlatform query, HttpCallback<GraphQLResponse<PlatformDetails>> callback) {
        enqueueGraphQLCall(this.service.getPlatform(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<PlatformDetails>> getPlatformSync(GetPlatform query) {
        return executeGraphQLCall(this.service.getPlatform(query));
    }

}
