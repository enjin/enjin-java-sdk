package com.enjin.enjincoin.sdk.client.service.requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousRequestsService {

    Response<JsonElement> getAllRequestsSync() throws IOException;

    Response<JsonElement> getRequestsSync(Integer id,
                          String transactionId,
                          Integer identityId,
                          String type,
                          Integer recipientId,
                          String recipientAddress,
                          Integer tokenId,
                          Integer value,
                          String encodedData,
                          String state,
                          Integer accepted) throws IOException;

    Response<JsonElement> createRequestSync(Integer identityId,
                            Integer appId,
                            String type,
                            String title,
                            String icon,
                            Float value,
                            JsonObject createTokenData,
                            JsonObject mintTokenData,
                            JsonObject meltTokenData,
                            JsonObject sendTokenData) throws IOException;

    Response<JsonElement> updateRequestSync(Integer id,
                            Integer appId,
                            Integer recipientId,
                            String type,
                            String title,
                            String icon,
                            Float value) throws IOException;

}
