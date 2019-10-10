package com.enjin.sdk.service.apps.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.apps.App;
import com.enjin.sdk.model.service.apps.CreateApp;
import com.enjin.sdk.model.service.apps.DeleteApp;
import com.enjin.sdk.model.service.apps.GetApps;
import com.enjin.sdk.model.service.apps.UpdateApp;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.apps.AppsService;

import retrofit2.Retrofit;

public class AppsServiceImpl extends GraphQLServiceBase implements AppsService {

    private AppsRetrofitService service;

    public AppsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(AppsRetrofitService.class);
    }

    @Override
    public void getAppsAsync(GetApps query, HttpCallback<GraphQLResponse<List<App>>> callback) {
        enqueueGraphQLCall(this.service.getApps(query), callback);
    }

    @Override
    public void createAppAsync(CreateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.createApps(query), callback);
    }

    @Override
    public void deleteAppAsync(DeleteApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.deleteApps(query), callback);
    }

    @Override
    public void updateAppAsync(UpdateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.updateApps(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query) throws IOException {
        return executeGraphQLCall(this.service.getApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query) throws IOException {
        return executeGraphQLCall(this.service.createApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query) throws IOException {
        return executeGraphQLCall(this.service.deleteApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query) throws IOException {
        return executeGraphQLCall(this.service.updateApps(query));
    }
}
