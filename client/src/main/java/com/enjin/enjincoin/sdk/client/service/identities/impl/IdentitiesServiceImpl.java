package com.enjin.enjincoin.sdk.client.service.identities.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.vo.*;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IdentitiesServiceImpl implements IdentitiesService {

    private GraphQLRetrofitService service;

    public IdentitiesServiceImpl(GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void getAllIdentitiesAsync(Callback<JsonElement> callback) {
        Call<JsonElement> call = getAllIdentities();
        call.enqueue(callback);
    }

    @Override
    public void getIdentitiesAsync(Integer id, String ethereumAddress, Callback<JsonElement> callback) {
        Call<JsonElement> call = getIdentities(id, ethereumAddress);
        call.enqueue(callback);
    }

    @Override
    public void createIdentityAsync(Integer id, String ethereumAddress, List<IdentityField> fields, Callback<JsonElement> callback) {
        Call<JsonElement> call = createIdentity(id, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public void updateIdentityAsync(Integer id, Integer appId, Integer userId,
                                    String ethereumAddress,
                                    List<IdentityField> fields, Callback<JsonElement> callback) {
        Call<JsonElement> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public Response<JsonElement> getAllIdentitiesSync() throws IOException {
        Call<JsonElement> call = getAllIdentities();
        return call.execute();
    }

    @Override
    public Response<JsonElement> getIdentitiesSync(Integer id, String ethereumAddress) throws IOException {
        Call<JsonElement> call = getIdentities(id, ethereumAddress);
        return call.execute();
    }

    @Override
    public Response<JsonElement> createIdentitySync(Integer id, String ethereumAddress, List<IdentityField> fields) throws IOException {
        Call<JsonElement> call = createIdentity(id, ethereumAddress, fields);
        return call.execute();
    }

    @Override
    public Response<JsonElement> updateIdentitySync(Integer id, Integer appId, Integer userId,
                                                    String ethereumAddress,
                                                    List<IdentityField> fields) throws IOException {
        Call<JsonElement> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        return call.execute();
    }

    private Call<JsonElement> getAllIdentities() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/getAllIdentities.query")
                .build().call();
    }

    private Call<JsonElement> getIdentities(Integer id, String ethereumAddress) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/getIdentities.query")
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress)
                .build().call();
    }

    private Call<JsonElement> createIdentity(Integer id, String ethereumAddress, List<IdentityField> fields) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/createIdentity.mutation")
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress)
                .withParameter("fields", fields)
                .build().call();
    }

    private Call<JsonElement> updateIdentity(Integer id, Integer appId, Integer userId,
                                             String ethereumAddress,
                                             List<IdentityField> fields) {
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
