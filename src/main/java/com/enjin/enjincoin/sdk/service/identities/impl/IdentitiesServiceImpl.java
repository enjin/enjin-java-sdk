package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.http.Result;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.http.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class IdentitiesServiceImpl extends GraphQLServiceBase implements IdentitiesService {

    private IdentitiesRetrofitService service;

    public IdentitiesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getAllIdentitiesAsync(Callback<GraphQLResponse<GetIdentitiesResult>> callback) {
        enqueueGraphQLCall(getAllIdentitiesCall(), callback);
    }

    @Override
    public void getIdentitiesAsync(GetIdentities query,
                                   Callback<GraphQLResponse<GetIdentitiesResult>> callback) {
        enqueueGraphQLCall(getIdentitiesCall(query), callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentity query,
                                    Callback<GraphQLResponse<CreateIdentityResult>> callback) {
        enqueueGraphQLCall(getCreateIdentityCall(query), callback);
    }

    @Override
    public void deleteIdentityAsync(DeleteIdentity query,
                                    Callback<GraphQLResponse<DeleteIdentityResult>> callback) {
        enqueueGraphQLCall(getDeleteIdentityCall(query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateIdentity query,
                                    Callback<GraphQLResponse<UpdateIdentityResult>> callback) {
        enqueueGraphQLCall(getUpdateIdentityCall(query), callback);
    }

    @Override
    public Result<GraphQLResponse<GetIdentitiesResult>> getAllIdentitiesSync() throws IOException {
        return executeGraphQLCall(getAllIdentitiesCall());
    }

    @Override
    public Result<GraphQLResponse<GetIdentitiesResult>> getIdentitiesSync(GetIdentities query) throws IOException {
        return executeGraphQLCall(getIdentitiesCall(query));
    }

    @Override
    public Result<GraphQLResponse<CreateIdentityResult>> createIdentitySync(CreateIdentity query) throws IOException {
        return executeGraphQLCall(getCreateIdentityCall(query));
    }

    @Override
    public Result<GraphQLResponse<DeleteIdentityResult>> deleteIdentitySync(DeleteIdentity query) throws IOException {
        return executeGraphQLCall(getDeleteIdentityCall(query));
    }

    @Override
    public Result<GraphQLResponse<UpdateIdentityResult>> updateIdentitySync(UpdateIdentity query) throws IOException {
        return executeGraphQLCall(getUpdateIdentityCall(query));
    }

    private Call<GraphQLResponse<GetIdentitiesResult>> getAllIdentitiesCall() {
        return this.service.getAllIdentities(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<GetIdentitiesResult>> getIdentitiesCall(GetIdentities query) {
        return this.service.getIdentities(query);
    }

    private Call<GraphQLResponse<CreateIdentityResult>> getCreateIdentityCall(CreateIdentity query) {
        return this.service.createIdentity(query);
    }

    private Call<GraphQLResponse<DeleteIdentityResult>> getDeleteIdentityCall(DeleteIdentity query) {
        return this.service.deleteIdentity(query);
    }

    private Call<GraphQLResponse<UpdateIdentityResult>> getUpdateIdentityCall(UpdateIdentity query) {
        return this.service.updateIdentity(query);
    }

}
