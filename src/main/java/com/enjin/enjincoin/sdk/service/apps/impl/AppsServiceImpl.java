package com.enjin.enjincoin.sdk.service.apps.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.apps.App;
import com.enjin.enjincoin.sdk.model.service.apps.CreateApp;
import com.enjin.enjincoin.sdk.model.service.apps.DeleteApp;
import com.enjin.enjincoin.sdk.model.service.apps.GetApps;
import com.enjin.enjincoin.sdk.model.service.apps.UpdateApp;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.apps.AppsService;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class AppsServiceImpl extends GraphQLServiceBase implements AppsService {

    private AppsRetrofitService service;

    public AppsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(AppsRetrofitService.class);
    }

    @Override
    public void getIdentitiesAsync(GetApps query, HttpCallback<GraphQLResponse<List<App>>> callback) {
        enqueueGraphQLCall(this.service.getApps(query), callback);
    }

    @Override
    public void createIdentityAsync(CreateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.createApps(query), callback);
    }

    @Override
    public void deleteIdentityAsync(DeleteApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.deleteApps(query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.updateApps(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<App>>> getIdentitiesSync(GetApps query) throws IOException {
        return executeGraphQLCall(this.service.getApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> createIdentitySync(CreateApp query) throws IOException {
        return executeGraphQLCall(this.service.createApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> deleteIdentitySync(DeleteApp query) throws IOException {
        return executeGraphQLCall(this.service.deleteApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> updateIdentitySync(UpdateApp query) throws IOException {
        return executeGraphQLCall(this.service.updateApps(query));
    }
}
