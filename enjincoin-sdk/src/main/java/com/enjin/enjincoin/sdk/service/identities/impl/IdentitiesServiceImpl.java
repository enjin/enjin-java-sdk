package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class IdentitiesServiceImpl extends GraphQLServiceBase implements IdentitiesService {

    private final IdentitiesRetrofitService service;

    public IdentitiesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getIdentitiesAsync(GetIdentities query,
                                   HttpCallback<GraphQLResponse<List<Identity>>> callback) {
        enqueueGraphQLCall(this.service.getIdentities(query), callback);
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
    public HttpResponse<GraphQLResponse<List<Identity>>> getIdentitiesSync(GetIdentities query) throws IOException {
        return executeGraphQLCall(this.service.getIdentities(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> createIdentitySync(CreateIdentity query) throws IOException {
        return executeGraphQLCall(this.service.createIdentity(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> deleteIdentitySync(DeleteIdentity query) throws IOException {
        return executeGraphQLCall(this.service.deleteIdentity(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> updateIdentitySync(UpdateIdentity query) throws IOException {
        return executeGraphQLCall(this.service.updateIdentity(query));
    }

}
