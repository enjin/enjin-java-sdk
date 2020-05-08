package com.enjin.sdk.services.identity.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.identity.CreateIdentity;
import com.enjin.sdk.models.identity.DeleteIdentity;
import com.enjin.sdk.models.identity.GetIdentities;
import com.enjin.sdk.models.identity.GetIdentity;
import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.models.identity.UnlinkIdentity;
import com.enjin.sdk.models.identity.UpdateIdentity;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.identity.IdentitiesService;

import retrofit2.Retrofit;

/**
 * Implementation class of {@link IdentitiesService}.
 *
 * @see IdentitiesService
 */
public class IdentitiesServiceImpl extends GraphQLServiceBase implements IdentitiesService {

    private final IdentitiesRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit the retrofit adapter
     */
    public IdentitiesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getIdentitiesAsync(GetIdentities query,
                                   HttpCallback<GraphQLResponse<List<Identity>>> callback) {
        enqueueGraphQLCall(this.service.getIdentities(query), callback);
    }

    @Override
    public void getIdentityAsync(GetIdentity query, HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.getIdentity(query), callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.createIdentity(query), callback);
    }

    @Override
    public void deleteIdentityAsync(DeleteIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.deleteIdentity(query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.updateIdentity(query), callback);
    }

    @Override
    public void unlinkIdentityAsync(UnlinkIdentity query, HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.unlinkIdentity(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Identity>>> getIdentitiesSync(GetIdentities query) {
        return executeGraphQLCall(this.service.getIdentities(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> getIdentitySync(GetIdentity query) {
        return executeGraphQLCall(this.service.getIdentity(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> createIdentitySync(CreateIdentity query) {
        return executeGraphQLCall(this.service.createIdentity(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> deleteIdentitySync(DeleteIdentity query) {
        return executeGraphQLCall(this.service.deleteIdentity(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> updateIdentitySync(UpdateIdentity query) {
        return executeGraphQLCall(this.service.updateIdentity(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> unlinkIdentitySync(UnlinkIdentity query) {
        return executeGraphQLCall(this.service.unlinkIdentity(query));
    }

}
