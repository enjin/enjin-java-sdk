package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentities;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.enjin.enjincoin.sdk.model.service.identities.UnlinkIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.util.concurrent.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class IdentitiesServiceImpl extends ServiceBase implements IdentitiesService {

    private IdentitiesRetrofitService service;

    public IdentitiesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getAllIdentitiesAsync(Callback<GraphQLResponse<GetIdentitiesResult>> callback) {
        enqueue(getAllIdentitiesCall(), callback);
    }

    @Override
    public void getIdentitiesAsync(GetIdentities query,
                                   Callback<GraphQLResponse<GetIdentitiesResult>> callback) {
        enqueue(getIdentitiesCall(query), callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentity query,
                                    Callback<GraphQLResponse<CreateIdentityResult>> callback) {
        enqueue(getCreateIdentityCall(query), callback);
    }

    @Override
    public void unlinkIdentityAsync(UnlinkIdentity query,
                                    Callback<GraphQLResponse<Identity>> callback) {
        enqueue(getUnlinkIdentityCall(query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateIdentity query,
                                    Callback<GraphQLResponse<UpdateIdentityResult>> callback) {
        enqueue(getUpdateIdentityCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<GetIdentitiesResult>> getAllIdentitiesSync() throws IOException {
        return execute(getAllIdentitiesCall());
    }

    @Override
    public Response<GraphQLResponse<GetIdentitiesResult>> getIdentitiesSync(GetIdentities query) throws IOException {
        return execute(getIdentitiesCall(query));
    }

    @Override
    public Response<GraphQLResponse<CreateIdentityResult>> createIdentitySync(CreateIdentity query) throws IOException {
        return execute(getCreateIdentityCall(query));
    }

    @Override
    public Response<GraphQLResponse<Identity>> unlinkIdentitySync(UnlinkIdentity query) throws IOException {
        return execute(getUnlinkIdentityCall(query));
    }

    @Override
    public Response<GraphQLResponse<UpdateIdentityResult>> updateIdentitySync(UpdateIdentity query) throws IOException {
        return execute(getUpdateIdentityCall(query));
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

    private Call<GraphQLResponse<Identity>> getUnlinkIdentityCall(UnlinkIdentity query) {
        return this.service.unlinkIdentity(query);
    }

    private Call<GraphQLResponse<UpdateIdentityResult>> getUpdateIdentityCall(UpdateIdentity query) {
        return this.service.updateIdentity(query);
    }

}
