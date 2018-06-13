package com.enjin.enjincoin.sdk.client.service.tokens;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Callback;

public interface AsynchronousTokensService {

    void getAllTokensAsync(Callback<GraphQLResponse<TokensData>> callback);

    void getTokensAsync(Integer id,
                        String creator,
                        String name,
                        Integer firstBlock,
                        Integer blockHeight,
                        Callback<GraphQLResponse<TokensData>> callback);

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
                          Callback<GraphQLResponse<CreateTokenData>> callback);

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
                          Callback<GraphQLResponse<UpdateTokenData>> callback);

}
