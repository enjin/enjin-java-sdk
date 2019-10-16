package com.enjin.sdk.service.identities.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SchemaProvider;
import com.enjin.sdk.model.service.identities.CreateIdentity;
import com.enjin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.sdk.model.service.identities.GetIdentities;
import com.enjin.sdk.model.service.identities.Identity;
import com.enjin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.identities.IdentitiesService;

import retrofit2.Retrofit;

public class IdentitiesServiceImpl extends GraphQLServiceBase implements IdentitiesService {

    private final IdentitiesRetrofitService service;
    private final SchemaProvider schemaProvider;

    public IdentitiesServiceImpl(Retrofit retrofit, SchemaProvider schemaProvider) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
        this.schemaProvider = schemaProvider;
    }

    @Override
    public void getIdentitiesAsync(GetIdentities query,
                                   HttpCallback<GraphQLResponse<List<Identity>>> callback) {
        enqueueGraphQLCall(this.service.getIdentities(schemaProvider.get(), query), callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.createIdentity(schemaProvider.get(), query), callback);
    }

    @Override
    public void deleteIdentityAsync(DeleteIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.deleteIdentity(schemaProvider.get(), query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(this.service.updateIdentity(schemaProvider.get(), query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Identity>>> getIdentitiesSync(GetIdentities query) throws IOException {
        return executeGraphQLCall(this.service.getIdentities(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> createIdentitySync(CreateIdentity query) throws IOException {
        return executeGraphQLCall(this.service.createIdentity(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> deleteIdentitySync(DeleteIdentity query) throws IOException {
        return executeGraphQLCall(this.service.deleteIdentity(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> updateIdentitySync(UpdateIdentity query) throws IOException {
        return executeGraphQLCall(this.service.updateIdentity(schemaProvider.get(), query));
    }

}
