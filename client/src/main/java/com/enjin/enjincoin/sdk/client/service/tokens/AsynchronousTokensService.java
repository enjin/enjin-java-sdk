package com.enjin.enjincoin.sdk.client.service.tokens;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import retrofit2.Callback;

public interface AsynchronousTokensService {

    void getAllTokensAsync(Callback<GraphQLResponse> callback);

    void getTokensAsync(Integer id,
                        String creator,
                        String name,
                        Integer firstBlock,
                        Integer blockHeight,
                        Callback<GraphQLResponse> callback);

    void createTokenAsync(Integer tokenId,
                          Integer appId,
                          String creator,
                          String adapter,
                          String name,
                          String icon,
                          String totalSupply,
                          String exchangeRate,
                          Integer decimals,
                          String maxMeltFee,
                          String meltFee,
                          Integer transferable,
                          Integer firstBlock,
                          Integer blockHeight,
                          Boolean fromBlockchain,
                          Callback<GraphQLResponse> callback);

    void updateTokenAsync(Integer tokenId,
                          Integer appId,
                          String creator,
                          String adapter,
                          String name,
                          String icon,
                          String totalSupply,
                          String exchangeRate,
                          Integer decimals,
                          String maxMeltFee,
                          String meltFee,
                          Integer transferable,
                          Integer firstBlock,
                          Integer blockHeight,
                          Boolean fromBlockchain,
                          Callback<GraphQLResponse> callback);

}
