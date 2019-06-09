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
import retrofit2.Call;
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
        enqueueGraphQLCall(getIdentitiesCall(query), callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(getCreateIdentityCall(query), callback);
    }

    @Override
    public void deleteIdentityAsync(DeleteIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(getDeleteIdentityCall(query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateIdentity query,
                                    HttpCallback<GraphQLResponse<Identity>> callback) {
        enqueueGraphQLCall(getUpdateIdentityCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Identity>>> getIdentitiesSync(GetIdentities query) throws IOException {
        return executeGraphQLCall(getIdentitiesCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> createIdentitySync(CreateIdentity query) throws IOException {
        return executeGraphQLCall(getCreateIdentityCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> deleteIdentitySync(DeleteIdentity query) throws IOException {
        return executeGraphQLCall(getDeleteIdentityCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Identity>> updateIdentitySync(UpdateIdentity query) throws IOException {
        return executeGraphQLCall(getUpdateIdentityCall(query));
    }

    private Call<GraphQLResponse<List<Identity>>> getIdentitiesCall(GetIdentities query) {
        return this.service.getIdentities(query);
    }

    private Call<GraphQLResponse<Identity>> getCreateIdentityCall(CreateIdentity query) {
        return this.service.createIdentity(query);
    }

    private Call<GraphQLResponse<Identity>> getDeleteIdentityCall(DeleteIdentity query) {
        return this.service.deleteIdentity(query);
    }

    private Call<GraphQLResponse<Identity>> getUpdateIdentityCall(UpdateIdentity query) {
        return this.service.updateIdentity(query);
    }

}
