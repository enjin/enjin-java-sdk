package com.enjin.enjincoin.sdk.client.service.identities.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityField;
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
    public void getAllIdentitiesAsync(final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = getAllIdentities();
        call.enqueue(callback);
    }

    @Override
    public void getIdentitiesAsync(final Integer id, final String ethereumAddress, final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = getIdentities(id, ethereumAddress);
        call.enqueue(callback);
    }

    @Override
    public void createIdentityAsync(final Integer id, final String ethereumAddress, final List<IdentityField> fields, final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = createIdentity(id, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public void updateIdentityAsync(final Integer id, final Integer appId, final Integer userId,
                                    final String ethereumAddress,
                                    final List<IdentityField> fields, final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        call.enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse> getAllIdentitiesSync() throws IOException {
        final Call<GraphQLResponse> call = getAllIdentities();
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse> getIdentitiesSync(final Integer id, final String ethereumAddress) throws IOException {
        final Call<GraphQLResponse> call = getIdentities(id, ethereumAddress);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse> createIdentitySync(final Integer id, final String ethereumAddress, final List<IdentityField> fields) throws IOException {
        final Call<GraphQLResponse> call = createIdentity(id, ethereumAddress, fields);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse> updateIdentitySync(final Integer id, final Integer appId, final Integer userId,
                                                    final String ethereumAddress,
                                                    final List<IdentityField> fields) throws IOException {
        final Call<GraphQLResponse> call = updateIdentity(id, appId, userId, ethereumAddress, fields);
        return call.execute();
    }

    private Call<GraphQLResponse> getAllIdentities() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/getAllIdentities.query")
                .build().call();
    }

    private Call<GraphQLResponse> getIdentities(final Integer id, final String ethereumAddress) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/getIdentities.query")
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress)
                .build().call();
    }

    private Call<GraphQLResponse> createIdentity(final Integer id, final String ethereumAddress, final List<IdentityField> fields) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/identities/createIdentity.mutation")
                .withParameter("id", id)
                .withParameter("ethereum_address", ethereumAddress)
                .withParameter("fields", fields)
                .build().call();
    }

    private Call<GraphQLResponse> updateIdentity(final Integer id, final Integer appId, final Integer userId,
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
