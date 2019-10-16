package com.enjin.sdk.service.apps.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SchemaProvider;
import com.enjin.sdk.model.service.apps.App;
import com.enjin.sdk.model.service.apps.CreateApp;
import com.enjin.sdk.model.service.apps.DeleteApp;
import com.enjin.sdk.model.service.apps.GetApps;
import com.enjin.sdk.model.service.apps.UpdateApp;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.apps.AppsService;

import retrofit2.Retrofit;

public class AppsServiceImpl extends GraphQLServiceBase implements AppsService {

    private final AppsRetrofitService service;
    private final SchemaProvider schemaProvider;

    public AppsServiceImpl(Retrofit retrofit, SchemaProvider schemaProvider) {
        this.service = retrofit.create(AppsRetrofitService.class);
        this.schemaProvider = schemaProvider;
    }

    @Override
    public void getAppsAsync(GetApps query, HttpCallback<GraphQLResponse<List<App>>> callback) {
        enqueueGraphQLCall(this.service.getApps(schemaProvider.get(), query), callback);
    }

    @Override
    public void createAppAsync(CreateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.createApps(schemaProvider.get(), query), callback);
    }

    @Override
    public void deleteAppAsync(DeleteApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.deleteApps(schemaProvider.get(), query), callback);
    }

    @Override
    public void updateAppAsync(UpdateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.updateApps(schemaProvider.get(), query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query) throws IOException {
        return executeGraphQLCall(this.service.getApps(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query) throws IOException {
        return executeGraphQLCall(this.service.createApps(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query) throws IOException {
        return executeGraphQLCall(this.service.deleteApps(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query) throws IOException {
        return executeGraphQLCall(this.service.updateApps(schemaProvider.get(), query));
    }
}
