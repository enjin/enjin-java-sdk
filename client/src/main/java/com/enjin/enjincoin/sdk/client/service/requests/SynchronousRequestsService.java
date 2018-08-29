package com.enjin.enjincoin.sdk.client.service.requests;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.UpdateRequestData;
import com.google.gson.JsonObject;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousRequestsService {

    /**
     *
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<RequestsData>> getAllRequestsSync() throws IOException;

    /**
     *
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
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<RequestsData>> getRequestsSync(Integer requestId,
                                                            String transactionId,
                                                            Integer identityId,
                                                            TransactionType type,
                                                            Integer recipientId,
                                                            String recipientAddress,
                                                            Integer tokenId,
                                                            Integer value,
                                                            String encodedData,
                                                            String state,
                                                            Integer accepted) throws IOException;

    /**
     *
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
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<CreateRequestData>> createRequestSync(Integer identityId,
                                                                   Integer appId,
                                                                   TransactionType type,
                                                                   String title,
                                                                   String icon,
                                                                   Float value,
                                                                   JsonObject createTokenData,
                                                                   JsonObject createTradeData,
                                                                   JsonObject mintTokenData,
                                                                   JsonObject meltTokenData,
                                                                   JsonObject sendTokenData) throws IOException;

    /**
     * 
     * @param requestId
     * @param appId
     * @param recipientId
     * @param type
     * @param title
     * @param icon
     * @param value
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateRequestData>> updateRequestSync(Integer requestId,
                                                                   Integer appId,
                                                                   Integer recipientId,
                                                                   TransactionType type,
                                                                   String title,
                                                                   String icon,
                                                                   Float value) throws IOException;

}
