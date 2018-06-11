package com.enjin.enjincoin.sdk.client.service.requests;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.google.gson.JsonObject;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousRequestsService {

    Response<GraphQLResponse> getAllRequestsSync() throws IOException;

    Response<GraphQLResponse> getRequestsSync(Integer id,
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

    Response<GraphQLResponse> createRequestSync(Integer identityId,
                            Integer appId,
                            String type,
                            String title,
                            String icon,
                            Float value,
                            JsonObject createTokenData,
                            JsonObject mintTokenData,
                            JsonObject meltTokenData,
                            JsonObject sendTokenData) throws IOException;

    Response<GraphQLResponse> updateRequestSync(Integer id,
                            Integer appId,
                            Integer recipientId,
                            String type,
                            String title,
                            String icon,
                            Float value) throws IOException;

}
