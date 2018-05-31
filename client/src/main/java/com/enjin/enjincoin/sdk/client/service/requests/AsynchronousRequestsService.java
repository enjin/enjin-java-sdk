package com.enjin.enjincoin.sdk.client.service.requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import retrofit2.Callback;

public interface AsynchronousRequestsService {

    void getAllRequestsAsync(Callback<JsonElement> callback);

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
                          Callback<JsonElement> callback);

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
                            Callback<JsonElement> callback);

    void updateRequestAsync(Integer id,
                            Integer appId,
                            Integer recipientId,
                            String type,
                            String title,
                            String icon,
                            Float value,
                            Callback<JsonElement> callback);

}
