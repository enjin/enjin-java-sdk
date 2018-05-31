package com.enjin.enjincoin.sdk.client.service.identities.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class IdentitiesServiceImpl implements IdentitiesService {

    private GraphQLRetrofitService service;

    public IdentitiesServiceImpl(final GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void getAllIdentitiesAsync(final Callback<JsonElement> callback) {
        final Call<JsonElement> call = getAllIdentities();
        call.enqueue(callback);
    }

    @Override
    public void getIdentitiesAsync(final Integer id, final String ethereumAddress, final Callback<JsonElement> callback) {
        final Call<JsonElement> call = getIdentities(id, ethereumAddress);
        call.enqueue(callback);
    }

    @Override
    public void createIdentityAsync(final Integer id, final String ethereumAddress, final List<IdentityField> fields, final Callback<JsonElement> callback) {
        final Call<JsonElement> call = createIdentity(id, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public void updateIdentityAsync(final Integer id, final Integer appId, final Integer userId,
                                    final String ethereumAddress,
                                    final List<IdentityField> fields, final Callback<JsonElement> callback) {
        final Call<JsonElement> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public Response<JsonElement> getAllIdentitiesSync() throws IOException {
        final Call<JsonElement> call = getAllIdentities();
        return call.execute();
    }

    @Override
    public Response<JsonElement> getIdentitiesSync(final Integer id, final String ethereumAddress) throws IOException {
        final Call<JsonElement> call = getIdentities(id, ethereumAddress);
        return call.execute();
    }

    @Override
    public Response<JsonElement> createIdentitySync(final Integer id, final String ethereumAddress, final List<IdentityField> fields) throws IOException {
        final Call<JsonElement> call = createIdentity(id, ethereumAddress, fields);
        return call.execute();
    }

    @Override
    public Response<JsonElement> updateIdentitySync(final Integer id, final Integer appId, final Integer userId,
                                                    final String ethereumAddress,
                                                    final List<IdentityField> fields) throws IOException {
        final Call<JsonElement> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        return call.execute();
    }

    private Call<JsonElement> getAllIdentities() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/getAllIdentities.query")
                .build().call();
    }

    private Call<JsonElement> getIdentities(final Integer id, final String ethereumAddress) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/getIdentities.query")
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress)
                .build().call();
    }

    private Call<JsonElement> createIdentity(final Integer id, final String ethereumAddress, final List<IdentityField> fields) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/createIdentity.mutation")
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress)
                .withParameter("fields", fields)
                .build().call();
    }

    private Call<JsonElement> updateIdentity(final Integer id, final Integer appId, final Integer userId,
                                             final String ethereumAddress,
                                             final List<IdentityField> fields) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/createIdentity.mutation")
                .withParameter("id", id)
                .withParameter("app_id", appId)
                .withParameter("user_id", userId)
                .withParameter("ethereum_address", ethereumAddress)
                .withParameter("fields", fields)
                .build().call();
    }

}
