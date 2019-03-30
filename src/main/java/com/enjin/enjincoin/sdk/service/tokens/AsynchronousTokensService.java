package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionType;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenSupplyModel;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferable;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.UpdateTokenData;
import com.google.gson.JsonObject;

public interface AsynchronousTokensService {

    /**
     * @param callback
     */
    void getAllTokensAsync(Callback<GraphQLResponse<TokensData>> callback);

    /**
     * @param tokenId
     * @param tokenIndex
     * @param name
     * @param creator
     * @param totalSupply
     * @param reserve
     * @param supplyModel
     * @param meltValue
     * @param meltFeeRatio
     * @param transferable
     * @param transferFeeSettings
     * @param nonFungible
     * @param firstBlock
     * @param blockHeight
     * @param tokenIdAsInt
     * @param tokenIndexAsInt
     * @param markedForDelete
     * @param callback
     */
    void getTokensAsync(String tokenId,
                        String tokenIndex,
                        String name,
                        String creator,
                        String totalSupply,
                        String reserve,
                        TokenSupplyModel supplyModel,
                        String meltValue,
                        String meltFeeRatio,
                        TokenTransferable transferable,
                        TokenTransferFeeSettings transferFeeSettings,
                        Boolean nonFungible,
                        Integer firstBlock,
                        Integer blockHeight,
                        Boolean tokenIdAsInt,
                        Boolean tokenIndexAsInt,
                        Boolean markedForDelete,
                        Callback<GraphQLResponse<TokensData>> callback);

    /**
     * @param tokenId
     * @param callback
     */
    void importTokenAsync(String tokenId,
                          Callback<GraphQLResponse<CreateTokenData>> callback);

    /**
     * @param tokenId
     * @param appId
     * @param fromBlockchain
     * @param updateIcon
     * @param callback
     */
    void updateTokenAsync(String tokenId,
                          Integer appId,
                          Boolean fromBlockchain,
                          String updateIcon,
                          Callback<GraphQLResponse<UpdateTokenData>> callback);

}
