package com.enjin.enjincoin.sdk.service.requests;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.requests.vo.RebroadcastType;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionState;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.UpdateRequestData;
import com.google.gson.JsonObject;

public interface AsynchronousRequestsService {

    /**
     * @param callback
     */
    void getAllRequestsAsync(Callback<GraphQLResponse<RequestsData>> callback);

    /**
     * @param id
     * @param transactionId
     * @param identityId
     * @param type
     * @param recipientId
     * @param recipientAddress
     * @param senderOrRecipientId
     * @param tokenId
     * @param value
     * @param state
     * @param stateIn
     * @param accepted
     * @param callback
     */
    void getRequestsAsync(final Integer id,
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
                          Callback<GraphQLResponse<RequestsData>> callback);

    /**
     * @param identityId
     * @param type
     * @param test
     * @param dummy
     * @param createTokenData
     * @param createTradeData
     * @param completeTradeData
     * @param mintTokenData
     * @param meltTokenData
     * @param sendTokenData
     * @param advancedSendTokenData
     * @param updateItemNameData
     * @param setItemUriData
     * @param setWhitelistedData
     * @param approveEnjData
     * @param approveItemData
     * @param setTransferableData
     * @param setMeltFeeData
     * @param decreaseMaxMeltFeeData
     * @param setTransferFeeData
     * @param decreaseMaxTransferFeeData
     * @param addLogData
     * @param batchApproveData
     * @param setApprovalData
     * @param setApprovalForAllData
     * @param messageData
     * @param callback
     */
    void createRequestAsync(Integer identityId,
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
                            Callback<GraphQLResponse<CreateRequestData>> callback);

    /**
     * @param id
     * @param type
     * @param rebroadcast
     * @param createTokenData
     * @param createTradeData
     * @param completeTradeData
     * @param mintTokenData
     * @param meltTokenData
     * @param sendTokenData
     * @param advancedSendTokenData
     * @param updateItemNameData
     * @param setItemUriData
     * @param setWhitelistedData
     * @param approveEnjData
     * @param approveItemData
     * @param setTransferableData
     * @param setMeltFeeData
     * @param decreaseMaxMeltFeeData
     * @param setTransferFeeData
     * @param decreaseMaxTransferFeeData
     * @param addLogData
     * @param batchApproveData
     * @param setApprovalData
     * @param setApprovalForAllData
     * @param messageData
     * @param callback
     */
    void updateRequestAsync(Integer id,
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
                            Callback<GraphQLResponse<UpdateRequestData>> callback);

}
