package com.enjin.enjincoin.sdk.client.service.identities.impl;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class IdentitiesServiceImpl implements IdentitiesService {

    private IdentitiesRetrofitService service;

    public IdentitiesServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(IdentitiesRetrofitService.class);
    }

    @Override
    public void getAllIdentitiesAsync(final Callback<GraphQLResponse<IdentitiesData>> callback) {
        final Call<GraphQLResponse<IdentitiesData>> call = getAllIdentities();
        call.enqueue(callback);
    }

    @Override
    public void getIdentitiesAsync(final Integer id, final String ethereumAddress, final Callback<GraphQLResponse<IdentitiesData>> callback) {
        final Call<GraphQLResponse<IdentitiesData>> call = getIdentities(id, ethereumAddress);
        call.enqueue(callback);
    }

    @Override
    public void createIdentityAsync(final Integer userId, final String ethereumAddress, final List<IdentityField> fields, final Callback<GraphQLResponse<CreateIdentityData>> callback) {
        final Call<GraphQLResponse<CreateIdentityData>> call = createIdentity(userId, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public void updateIdentityAsync(final Integer id, final Integer appId, final Integer userId,
                                    final String ethereumAddress,
                                    final List<IdentityField> fields, final Callback<GraphQLResponse<UpdateIdentityData>> callback) {
        final Call<GraphQLResponse<UpdateIdentityData>> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse<IdentitiesData>> getAllIdentitiesSync() throws IOException {
        final Call<GraphQLResponse<IdentitiesData>> call = getAllIdentities();
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<IdentitiesData>> getIdentitiesSync(final Integer id, final String ethereumAddress) throws IOException {
        final Call<GraphQLResponse<IdentitiesData>> call = getIdentities(id, ethereumAddress);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<CreateIdentityData>> createIdentitySync(final Integer userId, final String ethereumAddress, final List<IdentityField> fields) throws IOException {
        final Call<GraphQLResponse<CreateIdentityData>> call = createIdentity(userId, ethereumAddress, fields);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<UpdateIdentityData>> updateIdentitySync(final Integer id, final Integer appId, final Integer userId,
                                                                            final String ethereumAddress,
                                                                            final List<IdentityField> fields) throws IOException {
        final Call<GraphQLResponse<UpdateIdentityData>> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        return call.execute();
    }

    private Call<GraphQLResponse<IdentitiesData>> getAllIdentities() {
        return this.service.getAllIdentities(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<IdentitiesData>> getIdentities(final Integer id, final String ethereumAddress) {
        return this.service.getIdentities(GraphQLRequest.builder()
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress));
    }

    private Call<GraphQLResponse<CreateIdentityData>> createIdentity(final Integer userId, final String ethereumAddress, final List<IdentityField> fields) {
        return this.service.createIdentity(GraphQLRequest.builder()
                .withParameter("user_id", userId)
                .withParameter("ethereum_address", ethereumAddress)
                .withParameter("fields", fields));
    }

    private Call<GraphQLResponse<UpdateIdentityData>> updateIdentity(final Integer id, final Integer appId, final Integer userId,
                                                                     final String ethereumAddress,
                                                                     final List<IdentityField> fields) {
        return this.service.updateIdentity(GraphQLRequest.builder()
                .withParameter("id", id)
                .withParameter("app_id", appId)
                .withParameter("user_id", userId)
                .withParameter("ethereum_address", ethereumAddress)
                .withParameter("fields", fields));
    }

}
