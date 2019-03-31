package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.service.requests.vo.RebroadcastType;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionState;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.UpdateRequestData;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class RequestsServiceImpl extends ServiceBase implements RequestsService {

    private RequestsRetrofitService service;

    public RequestsServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(RequestsRetrofitService.class);
    }

    @Override
    public void getAllRequestsAsync(final Callback<GraphQLResponse<RequestsData>> callback) {
        enqueue(getGetAllRequestsCall(), callback);
    }

    @Override
    public void getRequestsAsync(final Integer id,
                                 final String transactionId,
                                 final Integer identityId,
                                 final TransactionType type,
                                 final Integer recipientId,
                                 final String recipientAddress,
                                 final Integer senderOrRecipientId,
                                 final Integer tokenId,
                                 final Integer value,
                                 final TransactionState state,
                                 final TransactionState[] stateIn,
                                 final Integer accepted,
                                 final Callback<GraphQLResponse<RequestsData>> callback) {
        enqueue(getGetRequestsCall(id,
                                   transactionId,
                                   identityId,
                                   type,
                                   recipientId,
                                   recipientAddress,
                                   senderOrRecipientId,
                                   tokenId,
                                   value,
                                   state,
                                   stateIn,
                                   accepted),
                callback);
    }

    @Override
    public void createRequestAsync(Integer identityId,
                                   TransactionType type,
                                   Boolean test,
                                   Boolean dummy,
                                   JsonObject createTokenData,
                                   JsonObject createTradeData,
                                   JsonObject completeTradeData,
                                   JsonObject mintTokenData,
                                   JsonObject meltTokenData,
                                   JsonObject sendTokenData,
                                   JsonObject advancedSendTokenData,
                                   JsonObject updateItemNameData,
                                   JsonObject setItemUriData,
                                   JsonObject setWhitelistedData,
                                   JsonObject approveEnjData,
                                   JsonObject approveItemData,
                                   JsonObject setTransferableData,
                                   JsonObject setMeltFeeData,
                                   JsonObject decreaseMaxMeltFeeData,
                                   JsonObject setTransferFeeData,
                                   JsonObject decreaseMaxTransferFeeData,
                                   JsonObject addLogData,
                                   JsonObject batchApproveData,
                                   JsonObject setApprovalData,
                                   JsonObject setApprovalForAllData,
                                   JsonObject messageData,
                                   final Callback<GraphQLResponse<CreateRequestData>> callback) {
        enqueue(getCreateRequestCall(identityId,
                                     type,
                                     test,
                                     dummy,
                                     createTokenData,
                                     createTradeData,
                                     completeTradeData,
                                     mintTokenData,
                                     meltTokenData,
                                     sendTokenData,
                                     advancedSendTokenData,
                                     updateItemNameData,
                                     setItemUriData,
                                     setWhitelistedData,
                                     approveEnjData,
                                     approveItemData,
                                     setTransferableData,
                                     setMeltFeeData,
                                     decreaseMaxMeltFeeData,
                                     setTransferFeeData,
                                     decreaseMaxTransferFeeData,
                                     addLogData,
                                     batchApproveData,
                                     setApprovalData,
                                     setApprovalForAllData,
                                     messageData),
                callback);
    }

    @Override
    public void updateRequestAsync(Integer id,
                                   TransactionType type,
                                   RebroadcastType rebroadcast,
                                   JsonObject createTokenData,
                                   JsonObject createTradeData,
                                   JsonObject completeTradeData,
                                   JsonObject mintTokenData,
                                   JsonObject meltTokenData,
                                   JsonObject sendTokenData,
                                   JsonObject advancedSendTokenData,
                                   JsonObject updateItemNameData,
                                   JsonObject setItemUriData,
                                   JsonObject setWhitelistedData,
                                   JsonObject approveEnjData,
                                   JsonObject approveItemData,
                                   JsonObject setTransferableData,
                                   JsonObject setMeltFeeData,
                                   JsonObject decreaseMaxMeltFeeData,
                                   JsonObject setTransferFeeData,
                                   JsonObject decreaseMaxTransferFeeData,
                                   JsonObject addLogData,
                                   JsonObject batchApproveData,
                                   JsonObject setApprovalData,
                                   JsonObject setApprovalForAllData,
                                   JsonObject messageData,
                                   final Callback<GraphQLResponse<UpdateRequestData>> callback) {
        enqueue(getUpdateRequestCall(id,
                                     type,
                                     rebroadcast,
                                     createTokenData,
                                     createTradeData,
                                     completeTradeData,
                                     mintTokenData,
                                     meltTokenData,
                                     sendTokenData,
                                     advancedSendTokenData,
                                     updateItemNameData,
                                     setItemUriData,
                                     setWhitelistedData,
                                     approveEnjData,
                                     approveItemData,
                                     setTransferableData,
                                     setMeltFeeData,
                                     decreaseMaxMeltFeeData,
                                     setTransferFeeData,
                                     decreaseMaxTransferFeeData,
                                     addLogData,
                                     batchApproveData,
                                     setApprovalData,
                                     setApprovalForAllData,
                                     messageData),
                callback);
    }

    @Override
    public Response<GraphQLResponse<RequestsData>> getAllRequestsSync() throws IOException {
        return execute(getGetAllRequestsCall());
    }

    @Override
    public Response<GraphQLResponse<RequestsData>> getRequestsSync(final Integer id,
                                                                   final String transactionId,
                                                                   final Integer identityId,
                                                                   final TransactionType type,
                                                                   final Integer recipientId,
                                                                   final String recipientAddress,
                                                                   final Integer senderOrRecipientId,
                                                                   final Integer tokenId,
                                                                   final Integer value,
                                                                   final TransactionState state,
                                                                   final TransactionState[] stateIn,
                                                                   final Integer accepted) throws IOException {
        return execute(getGetRequestsCall(id,
                                          transactionId,
                                          identityId,
                                          type,
                                          recipientId,
                                          recipientAddress,
                                          senderOrRecipientId,
                                          tokenId,
                                          value,
                                          state,
                                          stateIn,
                                          accepted));
    }

    @Override
    public Response<GraphQLResponse<CreateRequestData>> createRequestSync(Integer identityId,
                                                                          TransactionType type,
                                                                          Boolean test,
                                                                          Boolean dummy,
                                                                          JsonObject createTokenData,
                                                                          JsonObject createTradeData,
                                                                          JsonObject completeTradeData,
                                                                          JsonObject mintTokenData,
                                                                          JsonObject meltTokenData,
                                                                          JsonObject sendTokenData,
                                                                          JsonObject advancedSendTokenData,
                                                                          JsonObject updateItemNameData,
                                                                          JsonObject setItemUriData,
                                                                          JsonObject setWhitelistedData,
                                                                          JsonObject approveEnjData,
                                                                          JsonObject approveItemData,
                                                                          JsonObject setTransferableData,
                                                                          JsonObject setMeltFeeData,
                                                                          JsonObject decreaseMaxMeltFeeData,
                                                                          JsonObject setTransferFeeData,
                                                                          JsonObject decreaseMaxTransferFeeData,
                                                                          JsonObject addLogData,
                                                                          JsonObject batchApproveData,
                                                                          JsonObject setApprovalData,
                                                                          JsonObject setApprovalForAllData,
                                                                          JsonObject messageData) throws IOException {
        return execute(getCreateRequestCall(identityId,
                                            type,
                                            test,
                                            dummy,
                                            createTokenData,
                                            createTradeData,
                                            completeTradeData,
                                            mintTokenData,
                                            meltTokenData,
                                            sendTokenData,
                                            advancedSendTokenData,
                                            updateItemNameData,
                                            setItemUriData,
                                            setWhitelistedData,
                                            approveEnjData,
                                            approveItemData,
                                            setTransferableData,
                                            setMeltFeeData,
                                            decreaseMaxMeltFeeData,
                                            setTransferFeeData,
                                            decreaseMaxTransferFeeData,
                                            addLogData,
                                            batchApproveData,
                                            setApprovalData,
                                            setApprovalForAllData,
                                            messageData));
    }

    @Override
    public Response<GraphQLResponse<UpdateRequestData>> updateRequestSync(Integer id,
                                                                          TransactionType type,
                                                                          RebroadcastType rebroadcast,
                                                                          JsonObject createTokenData,
                                                                          JsonObject createTradeData,
                                                                          JsonObject completeTradeData,
                                                                          JsonObject mintTokenData,
                                                                          JsonObject meltTokenData,
                                                                          JsonObject sendTokenData,
                                                                          JsonObject advancedSendTokenData,
                                                                          JsonObject updateItemNameData,
                                                                          JsonObject setItemUriData,
                                                                          JsonObject setWhitelistedData,
                                                                          JsonObject approveEnjData,
                                                                          JsonObject approveItemData,
                                                                          JsonObject setTransferableData,
                                                                          JsonObject setMeltFeeData,
                                                                          JsonObject decreaseMaxMeltFeeData,
                                                                          JsonObject setTransferFeeData,
                                                                          JsonObject decreaseMaxTransferFeeData,
                                                                          JsonObject addLogData,
                                                                          JsonObject batchApproveData,
                                                                          JsonObject setApprovalData,
                                                                          JsonObject setApprovalForAllData,
                                                                          JsonObject messageData) throws IOException {
        return execute(getUpdateRequestCall(id,
                                            type,
                                            rebroadcast,
                                            createTokenData,
                                            createTradeData,
                                            completeTradeData,
                                            mintTokenData,
                                            meltTokenData,
                                            sendTokenData,
                                            advancedSendTokenData,
                                            updateItemNameData,
                                            setItemUriData,
                                            setWhitelistedData,
                                            approveEnjData,
                                            approveItemData,
                                            setTransferableData,
                                            setMeltFeeData,
                                            decreaseMaxMeltFeeData,
                                            setTransferFeeData,
                                            decreaseMaxTransferFeeData,
                                            addLogData,
                                            batchApproveData,
                                            setApprovalData,
                                            setApprovalForAllData,
                                            messageData));
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
                                                                   final Integer senderOrRecipientId,
                                                                   final Integer tokenId,
                                                                   final Integer value,
                                                                   final TransactionState state,
                                                                   final TransactionState[] stateIn,
                                                                   final Integer accepted) {
        return this.service.getRequests(GraphQLRequest.builder()
                                                      .withParameter("id", id)
                                                      .withParameter("transaction_id", transactionId)
                                                      .withParameter("identity_id", identityId)
                                                      .withParameter("type", type)
                                                      .withParameter("recipient_id", recipientId)
                                                      .withParameter("recipient_address", recipientAddress)
                                                      .withParameter("sender_or_recipient_id", senderOrRecipientId)
                                                      .withParameter("token_id", tokenId)
                                                      .withParameter("value", value)
                                                      .withParameter("state", state)
                                                      .withParameter("state_in", stateIn)
                                                      .withParameter("accepted", accepted));
    }

    private Call<GraphQLResponse<CreateRequestData>> getCreateRequestCall(Integer identityId,
                                                                          TransactionType type,
                                                                          Boolean test,
                                                                          Boolean dummy,
                                                                          JsonObject createTokenData,
                                                                          JsonObject createTradeData,
                                                                          JsonObject completeTradeData,
                                                                          JsonObject mintTokenData,
                                                                          JsonObject meltTokenData,
                                                                          JsonObject sendTokenData,
                                                                          JsonObject advancedSendTokenData,
                                                                          JsonObject updateItemNameData,
                                                                          JsonObject setItemUriData,
                                                                          JsonObject setWhitelistedData,
                                                                          JsonObject approveEnjData,
                                                                          JsonObject approveItemData,
                                                                          JsonObject setTransferableData,
                                                                          JsonObject setMeltFeeData,
                                                                          JsonObject decreaseMaxMeltFeeData,
                                                                          JsonObject setTransferFeeData,
                                                                          JsonObject decreaseMaxTransferFeeData,
                                                                          JsonObject addLogData,
                                                                          JsonObject batchApproveData,
                                                                          JsonObject setApprovalData,
                                                                          JsonObject setApprovalForAllData,
                                                                          JsonObject messageData) {
        return this.service.createRequest(
                GraphQLRequest.builder()
                              .withParameter("identity_id", identityId)
                              .withParameter("type", type)
                              .withParameter("test", test)
                              .withParameter("dummy", dummy)
                              .withParameter("create_token_data", createTokenData)
                              .withParameter("create_trade_data", createTradeData)
                              .withParameter("complete_trade_data", completeTradeData)
                              .withParameter("mint_token_data", mintTokenData)
                              .withParameter("melt_token_data", meltTokenData)
                              .withParameter("send_token_data", sendTokenData)
                              .withParameter("advanced_send_token_data", advancedSendTokenData)
                              .withParameter("update_item_name_data", updateItemNameData)
                              .withParameter("set_item_uri_data", setItemUriData)
                              .withParameter("set_whitelisted_data", setWhitelistedData)
                              .withParameter("approve_enj_data", approveEnjData)
                              .withParameter("approve_item_data", approveItemData)
                              .withParameter("set_transferable", setTransferableData)
                              .withParameter("set_melt_fee_data", setMeltFeeData)
                              .withParameter("decrease_max_melt_fee_data", decreaseMaxMeltFeeData)
                              .withParameter("set_transfer_fee_data", setTransferFeeData)
                              .withParameter("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData)
                              .withParameter("add_log_data", addLogData)
                              .withParameter("batch_approve_data", batchApproveData)
                              .withParameter("set_approval_data", setApprovalData)
                              .withParameter("set_approval_for_all_data", setApprovalForAllData)
                              .withParameter("message_data", messageData)
        );
    }

    private Call<GraphQLResponse<UpdateRequestData>> getUpdateRequestCall(Integer id,
                                                                          TransactionType type,
                                                                          RebroadcastType rebroadcast,
                                                                          JsonObject createTokenData,
                                                                          JsonObject createTradeData,
                                                                          JsonObject completeTradeData,
                                                                          JsonObject mintTokenData,
                                                                          JsonObject meltTokenData,
                                                                          JsonObject sendTokenData,
                                                                          JsonObject advancedSendTokenData,
                                                                          JsonObject updateItemNameData,
                                                                          JsonObject setItemUriData,
                                                                          JsonObject setWhitelistedData,
                                                                          JsonObject approveEnjData,
                                                                          JsonObject approveItemData,
                                                                          JsonObject setTransferableData,
                                                                          JsonObject setMeltFeeData,
                                                                          JsonObject decreaseMaxMeltFeeData,
                                                                          JsonObject setTransferFeeData,
                                                                          JsonObject decreaseMaxTransferFeeData,
                                                                          JsonObject addLogData,
                                                                          JsonObject batchApproveData,
                                                                          JsonObject setApprovalData,
                                                                          JsonObject setApprovalForAllData,
                                                                          JsonObject messageData) {
        return this.service.updateRequest(
                GraphQLRequest.builder()
                              .withParameter("id", id)
                              .withParameter("type", type)
                              .withParameter("rebroadcast", rebroadcast)
                              .withParameter("create_token_data", createTokenData)
                              .withParameter("create_trade_data", createTradeData)
                              .withParameter("complete_trade_data", completeTradeData)
                              .withParameter("mint_token_data", mintTokenData)
                              .withParameter("melt_token_data", meltTokenData)
                              .withParameter("send_token_data", sendTokenData)
                              .withParameter("advanced_send_token_data", advancedSendTokenData)
                              .withParameter("update_item_name_data", updateItemNameData)
                              .withParameter("set_item_uri_data", setItemUriData)
                              .withParameter("set_whitelisted_data", setWhitelistedData)
                              .withParameter("approve_enj_data", approveEnjData)
                              .withParameter("approve_item_data", approveItemData)
                              .withParameter("set_transferable", setTransferableData)
                              .withParameter("set_melt_fee_data", setMeltFeeData)
                              .withParameter("decrease_max_melt_fee_data", decreaseMaxMeltFeeData)
                              .withParameter("set_transfer_fee_data", setTransferFeeData)
                              .withParameter("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData)
                              .withParameter("add_log_data", addLogData)
                              .withParameter("batch_approve_data", batchApproveData)
                              .withParameter("set_approval_data", setApprovalData)
                              .withParameter("set_approval_for_all_data", setApprovalForAllData)
                              .withParameter("message_data", messageData)
        );
    }

}
