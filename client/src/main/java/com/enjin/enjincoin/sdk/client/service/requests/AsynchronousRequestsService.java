package com.enjin.enjincoin.sdk.client.service.requests;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.google.gson.JsonObject;
import retrofit2.Callback;

public interface AsynchronousRequestsService {

    void getAllRequestsAsync(Callback<GraphQLResponse> callback);

    void getRequestsAsync(Integer id,
                          String transactionId,
                          Integer identityId,
                          String type,
                          Integer recipientId,
                          String recipientAddress,
                          Integer tokenId,
                          Integer value,
                          String encodedData,
                          String state,
                          Integer accepted,
                          Callback<GraphQLResponse> callback);

    void createRequestAsync(Integer identityId,
                            Integer appId,
                            String type,
                            String title,
                            String icon,
                            Float value,
                            JsonObject createTokenData,
                            JsonObject mintTokenData,
                            JsonObject meltTokenData,
                            JsonObject sendTokenData,
                            Callback<GraphQLResponse> callback);

    void updateRequestAsync(Integer id,
                            Integer appId,
                            Integer recipientId,
                            String type,
                            String title,
                            String icon,
                            Float value,
                            Callback<GraphQLResponse> callback);

}
