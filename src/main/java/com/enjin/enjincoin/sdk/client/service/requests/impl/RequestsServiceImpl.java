package com.enjin.enjincoin.sdk.client.service.requests.impl;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.client.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.UpdateRequestData;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class RequestsServiceImpl implements RequestsService {

    private RequestsRetrofitService service;

    public RequestsServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getAllRequestsAsync(final Callback<GraphQLResponse<RequestsData>> callback) {
        final Call<GraphQLResponse<RequestsData>> call = getGetAllRequestsCall();
        call.enqueue(callback);
    }

    @Override
    public void getRequestsAsync(final Integer requestId,
                                 final String transactionId,
                                 final Integer identityId,
                                 final TransactionType type,
                                 final Integer recipientId,
                                 final String recipientAddress,
                                 final Integer tokenId,
                                 final Integer value,
                                 final String encodedData,
                                 final String state,
                                 final Integer accepted,
                                 final Callback<GraphQLResponse<RequestsData>> callback) {
        final Call<GraphQLResponse<RequestsData>> call = getGetRequestsCall(requestId,
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
                                   final TransactionType type,
                                   final String title,
                                   final String icon,
                                   final Float value,
                                   final JsonObject createTokenData,
                                   final JsonObject createTradeData,
                                   final JsonObject completeTradeData,
                                   final JsonObject mintTokenData,
                                   final JsonObject meltTokenData,
                                   final JsonObject sendTokenData,
                                   final Callback<GraphQLResponse<CreateRequestData>> callback) {
        final Call<GraphQLResponse<CreateRequestData>> call = getCreateRequestCall(identityId,
                                                                                   appId,
                                                                                   type,
                                                                                   title,
                                                                                   icon,
                                                                                   value,
                                                                                   createTokenData,
                                                                                   createTradeData,
                                                                                   completeTradeData,
                                                                                   mintTokenData,
                                                                                   meltTokenData,
                                                                                   sendTokenData);
        call.enqueue(callback);
    }

    @Override
    public void updateRequestAsync(final Integer requestId,
                                   final Integer appId,
                                   final Integer recipientId,
                                   final TransactionType type,
                                   final String title,
                                   final String icon,
                                   final Float value,
                                   final Callback<GraphQLResponse<UpdateRequestData>> callback) {
        final Call<GraphQLResponse<UpdateRequestData>> call = getUpdateRequestCall(requestId,
                                                                                   appId,
                                                                                   recipientId,
                                                                                   type,
                                                                                   title,
                                                                                   icon,
                                                                                   value);
        call.enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse<RequestsData>> getAllRequestsSync() throws IOException {
        final Call<GraphQLResponse<RequestsData>> call = getGetAllRequestsCall();
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<RequestsData>> getRequestsSync(final Integer requestId,
                                                                   final String transactionId,
                                                                   final Integer identityId,
                                                                   final TransactionType type,
                                                                   final Integer recipientId,
                                                                   final String recipientAddress,
                                                                   final Integer tokenId,
                                                                   final Integer value,
                                                                   final String encodedData,
                                                                   final String state,
                                                                   final Integer accepted) throws IOException {
        final Call<GraphQLResponse<RequestsData>> call = getGetRequestsCall(requestId,
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
    public Response<GraphQLResponse<CreateRequestData>> createRequestSync(final Integer identityId,
                                                                          final Integer appId,
                                                                          final TransactionType type,
                                                                          final String title,
                                                                          final String icon,
                                                                          final Float value,
                                                                          final JsonObject createTokenData,
                                                                          final JsonObject createTradeData,
                                                                          final JsonObject completeTradeData,
                                                                          final JsonObject mintTokenData,
                                                                          final JsonObject meltTokenData,
                                                                          final JsonObject sendTokenData) throws IOException {
        final Call<GraphQLResponse<CreateRequestData>> call = getCreateRequestCall(
                identityId,
                appId,
                type,
                title,
                icon,
                value,
                createTokenData,
                createTradeData,
                completeTradeData,
                mintTokenData,
                meltTokenData,
                sendTokenData);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<UpdateRequestData>> updateRequestSync(final Integer requestId,
                                                                          final Integer appId,
                                                                          final Integer recipientId,
                                                                          final TransactionType type,
                                                                          final String title,
                                                                          final String icon,
                                                                          final Float value) throws IOException {
        final Call<GraphQLResponse<UpdateRequestData>> call = getUpdateRequestCall(requestId,
                                                                                   appId,
                                                                                   recipientId,
                                                                                   type,
                                                                                   title,
                                                                                   icon,
                                                                                   value);
        return call.execute();
    }

    private Call<GraphQLResponse<RequestsData>> getGetAllRequestsCall() {
        return this.service.getAllRequests(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<RequestsData>> getGetRequestsCall(final Integer id,
                                                                   final String transactionId,
                                                                   final Integer identityId,
                                                                   final TransactionType type,
                                                                   final Integer recipientId,
                                                                   final String recipientAddress,
                                                                   final Integer tokenId,
                                                                   final Integer value,
                                                                   final String encodedData,
                                                                   final String state,
                                                                   final Integer accepted) {
        return this.service.getRequests(GraphQLRequest.builder()
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
                                                      .withParameter("accepted", accepted));
    }

    private Call<GraphQLResponse<CreateRequestData>> getCreateRequestCall(final Integer identityId,
                                                                          final Integer appId,
                                                                          final TransactionType type,
                                                                          final String title,
                                                                          final String icon,
                                                                          final Float value,
                                                                          final JsonObject createTokenData,
                                                                          final JsonObject createTradeData,
                                                                          final JsonObject completeTradeData,
                                                                          final JsonObject mintTokenData,
                                                                          final JsonObject meltTokenData,
                                                                          final JsonObject sendTokenData) {
        return this.service.createRequest(GraphQLRequest.builder()
                                                        .withParameter("identity_id", identityId)
                                                        .withParameter("app_id", appId)
                                                        .withParameter("type", type)
                                                        .withParameter("title", title)
                                                        .withParameter("icon", icon)
                                                        .withParameter("value", value)
                                                        .withParameter("create_token_data", createTokenData)
                                                        .withParameter("create_trade_data", createTradeData)
                                                        .withParameter("complete_trade_data", completeTradeData)
                                                        .withParameter("mint_token_data", mintTokenData)
                                                        .withParameter("melt_token_data", meltTokenData)
                                                        .withParameter("send_token_data", sendTokenData));
    }

    private Call<GraphQLResponse<UpdateRequestData>> getUpdateRequestCall(final Integer id,
                                                                          final Integer appId,
                                                                          final Integer recipientId,
                                                                          final TransactionType type,
                                                                          final String title,
                                                                          final String icon,
                                                                          final Float value) {
        return this.service.updateRequest(GraphQLRequest.builder()
                                                        .withParameter("id", id)
                                                        .withParameter("app_id", appId)
                                                        .withParameter("recipient_id", recipientId)
                                                        .withParameter("type", type)
                                                        .withParameter("title", title)
                                                        .withParameter("icon", icon)
                                                        .withParameter("value", value));
    }

}
