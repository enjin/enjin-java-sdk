package com.enjin.enjincoin.sdk.client.service.requests;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.UpdateRequestData;
import com.google.gson.JsonObject;
import retrofit2.Callback;

public interface AsynchronousRequestsService {

    /**
     * @param callback
     */
    void getAllRequestsAsync(Callback<GraphQLResponse<RequestsData>> callback);

    /**
     * @param requestId
     * @param transactionId
     * @param identityId
     * @param type
     * @param recipientId
     * @param recipientAddress
     * @param tokenId
     * @param value
     * @param encodedData
     * @param state
     * @param accepted
     * @param callback
     */
    void getRequestsAsync(Integer requestId,
                          String transactionId,
                          Integer identityId,
                          TransactionType type,
                          Integer recipientId,
                          String recipientAddress,
                          Integer tokenId,
                          Integer value,
                          String encodedData,
                          String state,
                          Integer accepted,
                          Callback<GraphQLResponse<RequestsData>> callback);

    /**
     * @param identityId
     * @param appId
     * @param type
     * @param title
     * @param icon
     * @param value
     * @param createTokenData
     * @param mintTokenData
     * @param meltTokenData
     * @param sendTokenData
     * @param callback
     */
    void createRequestAsync(Integer identityId,
                            Integer appId,
                            TransactionType type,
                            String title,
                            String icon,
                            Float value,
                            JsonObject createTokenData,
                            JsonObject createTradeData,
                            JsonObject completeTradeData,
                            JsonObject mintTokenData,
                            JsonObject meltTokenData,
                            JsonObject sendTokenData,
                            Callback<GraphQLResponse<CreateRequestData>> callback);

    /**
     * @param requestId
     * @param appId
     * @param recipientId
     * @param type
     * @param title
     * @param icon
     * @param value
     * @param callback
     */
    void updateRequestAsync(Integer requestId,
                            Integer appId,
                            Integer recipientId,
                            TransactionType type,
                            String title,
                            String icon,
                            Float value,
                            Callback<GraphQLResponse<UpdateRequestData>> callback);

}
