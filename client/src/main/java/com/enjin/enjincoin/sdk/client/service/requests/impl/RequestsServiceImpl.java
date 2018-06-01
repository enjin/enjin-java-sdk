package com.enjin.enjincoin.sdk.client.service.requests.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.requests.RequestsService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class RequestsServiceImpl implements RequestsService {

    private GraphQLRetrofitService service;

    public RequestsServiceImpl(final GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void getAllRequestsAsync(final Callback<JsonElement> callback) {
        final Call<JsonElement> call = getGetAllRequestsCall();
        call.enqueue(callback);
    }

    @Override
    public void getRequestsAsync(final Integer id,
                                 final String transactionId,
                                 final Integer identityId,
                                 final String type,
                                 final Integer recipientId,
                                 final String recipientAddress,
                                 final Integer tokenId,
                                 final Integer value,
                                 final String encodedData,
                                 final String state,
                                 final Integer accepted,
                                 final Callback<JsonElement> callback) {
        final Call<JsonElement> call = getGetRequestsCall(id,
                transactionId,
                identityId,
                type,
                recipientId,
                recipientAddress,
                tokenId,
                value,
                encodedData,
                state,
                accepted);
        call.enqueue(callback);
    }

    @Override
    public void createRequestAsync(final Integer identityId,
                                   final Integer appId,
                                   final String type,
                                   final String title,
                                   final String icon,
                                   final Float value,
                                   final JsonObject createTokenData,
                                   final JsonObject mintTokenData,
                                   final JsonObject meltTokenData,
                                   final JsonObject sendTokenData,
                                   final Callback<JsonElement> callback) {
        final Call<JsonElement> call = getCreateRequestCall(identityId,
                appId,
                type,
                title,
                icon,
                value,
                createTokenData,
                mintTokenData,
                meltTokenData,
                sendTokenData);
        call.enqueue(callback);
    }

    @Override
    public void updateRequestAsync(final Integer id,
                                   final Integer appId,
                                   final Integer recipientId,
                                   final String type,
                                   final String title,
                                   final String icon,
                                   final Float value,
                                   final Callback<JsonElement> callback) {
        final Call<JsonElement> call = getUpdateRequestCall(id,
                appId,
                recipientId,
                type,
                title,
                icon,
                value);
        call.enqueue(callback);
    }

    @Override
    public Response<JsonElement> getAllRequestsSync() throws IOException {
        final Call<JsonElement> call = getGetAllRequestsCall();
        return call.execute();
    }

    @Override
    public Response<JsonElement> getRequestsSync(final Integer id,
                                                 final String transactionId,
                                                 final Integer identityId,
                                                 final String type,
                                                 final Integer recipientId,
                                                 final String recipientAddress,
                                                 final Integer tokenId,
                                                 final Integer value,
                                                 final String encodedData,
                                                 final String state,
                                                 final Integer accepted) throws IOException {
        final Call<JsonElement> call = getGetRequestsCall(id,
                transactionId,
                identityId,
                type,
                recipientId,
                recipientAddress,
                tokenId,
                value,
                encodedData,
                state,
                accepted);
        return call.execute();
    }

    @Override
    public Response<JsonElement> createRequestSync(final Integer identityId,
                                                   final Integer appId,
                                                   final String type,
                                                   final String title,
                                                   final String icon,
                                                   final Float value,
                                                   final JsonObject createTokenData,
                                                   final JsonObject mintTokenData,
                                                   final JsonObject meltTokenData,
                                                   final JsonObject sendTokenData) throws IOException {
        final Call<JsonElement> call = getCreateRequestCall(identityId,
                appId,
                type,
                title,
                icon,
                value,
                createTokenData,
                mintTokenData,
                meltTokenData,
                sendTokenData);
        return call.execute();
    }

    @Override
    public Response<JsonElement> updateRequestSync(final Integer id,
                                                   final Integer appId,
                                                   final Integer recipientId,
                                                   final String type,
                                                   final String title,
                                                   final String icon,
                                                   final Float value) throws IOException {
        final Call<JsonElement> call = getUpdateRequestCall(id,
                appId,
                recipientId,
                type,
                title,
                icon,
                value);
        return call.execute();
    }

    private Call<JsonElement> getGetAllRequestsCall() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/requests/getAllRequests.query")
                .build().call();
    }

    private Call<JsonElement> getGetRequestsCall(final Integer id,
                                                 final String transactionId,
                                                 final Integer identityId,
                                                 final String type,
                                                 final Integer recipientId,
                                                 final String recipientAddress,
                                                 final Integer tokenId,
                                                 final Integer value,
                                                 final String encodedData,
                                                 final String state,
                                                 final Integer accepted) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/requests/getRequests.query")
                .withParameter("id", id)
                .withParameter("transaction_id", transactionId)
                .withParameter("identity_id", identityId)
                .withParameter("type", type)
                .withParameter("recipient_id", recipientId)
                .withParameter("recipient_address", recipientAddress)
                .withParameter("token_id", tokenId)
                .withParameter("value", value)
                .withParameter("encoded_data", encodedData)
                .withParameter("state", state)
                .withParameter("accepted", accepted)
                .build().call();
    }

    private Call<JsonElement> getCreateRequestCall(final Integer identityId,
                                                   final Integer appId,
                                                   final String type,
                                                   final String title,
                                                   final String icon,
                                                   final Float value,
                                                   final JsonObject createTokenData,
                                                   final JsonObject mintTokenData,
                                                   final JsonObject meltTokenData,
                                                   final JsonObject sendTokenData) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/requests/createRequest.mutation")
                .withParameter("identity_id", identityId)
                .withParameter("app_id", appId)
                .withParameter("type", type)
                .withParameter("title", title)
                .withParameter("icon", icon)
                .withParameter("value", value)
                .withParameter("create_token_data", createTokenData)
                .withParameter("mint_token_data", mintTokenData)
                .withParameter("melt_token_data", meltTokenData)
                .withParameter("send_token_data", sendTokenData)
                .build().call();
    }

    private Call<JsonElement> getUpdateRequestCall(final Integer id,
                                                   final Integer appId,
                                                   final Integer recipientId,
                                                   final String type,
                                                   final String title,
                                                   final String icon,
                                                   final Float value) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/requests/updateRequest.mutation")
                .withParameter("id", id)
                .withParameter("app_id", appId)
                .withParameter("recipient_id", recipientId)
                .withParameter("type", type)
                .withParameter("title", title)
                .withParameter("icon", icon)
                .withParameter("value", value)
                .build().call();
    }

}
