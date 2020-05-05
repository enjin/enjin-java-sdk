package com.enjin.sdk.services.app.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.app.App;
import com.enjin.sdk.models.app.CreateApp;
import com.enjin.sdk.models.app.DeleteApp;
import com.enjin.sdk.models.app.GetApp;
import com.enjin.sdk.models.app.GetApps;
import com.enjin.sdk.models.app.UnlinkApp;
import com.enjin.sdk.models.app.UpdateApp;
import com.enjin.sdk.models.app.AuthApp;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.app.AppsService;

import retrofit2.Retrofit;

/**
 * Implementation class of {@link AppsService}.
 *
 * @see AppsService
 */
public class AppsServiceImpl extends GraphQLServiceBase implements AppsService {

    private AppsRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit the retrofit adapter
     */
    public AppsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(AppsRetrofitService.class);
    }

    @Override
    public void getAppsAsync(GetApps query, HttpCallback<GraphQLResponse<List<App>>> callback) {
        enqueueGraphQLCall(this.service.getApps(query), callback);
    }

    @Override
    public void getAppAsync(GetApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.getApp(query), callback);
    }

    @Override
    public void createAppAsync(CreateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.createApp(query), callback);
    }

    @Override
    public void deleteAppAsync(DeleteApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.deleteApp(query), callback);
    }

    @Override
    public void updateAppAsync(UpdateApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.updateApp(query), callback);
    }

    @Override
    public void authAppAsync(AuthApp query, HttpCallback<GraphQLResponse<AccessToken>> callback) {
        enqueueGraphQLCall(this.service.authApp(query), callback);
    }

    @Override
    public void unlinkAppAsync(UnlinkApp query, HttpCallback<GraphQLResponse<App>> callback) {
        enqueueGraphQLCall(this.service.unlinkApp(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<App>>> getAppsSync(GetApps query) {
        return executeGraphQLCall(this.service.getApps(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> getAppSync(GetApp query) {
        return executeGraphQLCall(this.service.getApp(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> createAppSync(CreateApp query) {
        return executeGraphQLCall(this.service.createApp(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> deleteAppSync(DeleteApp query) {
        return executeGraphQLCall(this.service.deleteApp(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> updateAppSync(UpdateApp query) {
        return executeGraphQLCall(this.service.updateApp(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<AccessToken>> authAppSync(AuthApp query) {
        return executeGraphQLCall(this.service.authApp(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<App>> unlinkAppSync(UnlinkApp query) {
        return executeGraphQLCall(this.service.unlinkApp(query));
    }
}
