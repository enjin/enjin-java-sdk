package com.enjin.enjincoin.sdk.client.service.tokens;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Callback;

public interface AsynchronousTokensService {

    /**
     *
     * @param callback
     */
    void getAllTokensAsync(Callback<GraphQLResponse<TokensData>> callback);

    /**
     *
     * @param tokenId
     * @param creator
     * @param name
     * @param firstBlock
     * @param blockHeight
     * @param callback
     */
    void getTokensAsync(Integer tokenId,
                        String creator,
                        String name,
                        Integer firstBlock,
                        Integer blockHeight,
                        Callback<GraphQLResponse<TokensData>> callback);

    /**
     *
     * @param tokenId
     * @param appId
     * @param creator
     * @param adapter
     * @param name
     * @param icon
     * @param totalSupply
     * @param exchangeRate
     * @param decimals
     * @param maxMeltFee
     * @param meltFee
     * @param transferable
     * @param firstBlock
     * @param blockHeight
     * @param fromBlockchain
     * @param callback
     */
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

    /**
     *
     * @param tokenId
     * @param appId
     * @param creator
     * @param adapter
     * @param name
     * @param icon
     * @param totalSupply
     * @param exchangeRate
     * @param decimals
     * @param maxMeltFee
     * @param meltFee
     * @param transferable
     * @param firstBlock
     * @param blockHeight
     * @param fromBlockchain
     * @param callback
     */
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
