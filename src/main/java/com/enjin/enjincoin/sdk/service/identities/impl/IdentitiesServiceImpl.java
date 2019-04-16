package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateIdentity;
import com.enjin.enjincoin.sdk.model.query.GetIdentities;
import com.enjin.enjincoin.sdk.model.query.UnlinkIdentity;
import com.enjin.enjincoin.sdk.model.query.UpdateIdentity;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class IdentitiesServiceImpl extends ServiceBase implements IdentitiesService {

    private IdentitiesRetrofitService service;

    public IdentitiesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getAllIdentitiesAsync(Callback<GraphQLResponse<IdentitiesData>> callback) {
        enqueue(getAllIdentitiesCall(), callback);
    }

    @Override
    public void getIdentitiesAsync(GetIdentities query,
                                   Callback<GraphQLResponse<IdentitiesData>> callback) {
        enqueue(getIdentitiesCall(query), callback);
    }

    @Override
    public void createIdentityAsync(CreateIdentity query,
                                    Callback<GraphQLResponse<CreateIdentityData>> callback) {
        enqueue(getCreateIdentityCall(query), callback);
    }

    @Override
    public void unlinkIdentityAsync(UnlinkIdentity query,
                                    Callback<GraphQLResponse<Identity>> callback) {
        enqueue(getUnlinkIdentityCall(query), callback);
    }

    @Override
    public void updateIdentityAsync(UpdateIdentity query,
                                    Callback<GraphQLResponse<UpdateIdentityData>> callback) {
        enqueue(getUpdateIdentityCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException {
        return execute(getAllIdentitiesCall());
    }

    @Override
    public Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(GetIdentities query) throws IOException {
            return execute(getIdentitiesCall(query));
    }

    @Override
    public Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(CreateIdentity query) throws IOException {
        return execute(getCreateIdentityCall(query));
    }

    @Override
    public Response<GraphQLResponse<Identity>> unlinkIdentitySync(UnlinkIdentity query) throws IOException {
        return execute(getUnlinkIdentityCall(query));
    }

    @Override
    public Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(UpdateIdentity query) throws IOException {
        return execute(getUpdateIdentityCall(query));
    }

    private Call<GraphQLResponse<IdentitiesData>> getAllIdentitiesCall() {
        return this.service.getAllIdentities(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<IdentitiesData>> getIdentitiesCall(GetIdentities query) {
        return this.service.getIdentities(query);
    }

    private Call<GraphQLResponse<CreateIdentityData>> getCreateIdentityCall(CreateIdentity query) {
        return this.service.createIdentity(query);
    }

    private Call<GraphQLResponse<Identity>> getUnlinkIdentityCall(UnlinkIdentity query) {
        return this.service.unlinkIdentity(query);
    }

    private Call<GraphQLResponse<UpdateIdentityData>> getUpdateIdentityCall(UpdateIdentity query) {
        return this.service.updateIdentity(query);
    }

}
