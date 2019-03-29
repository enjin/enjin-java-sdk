package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenSupplyModel;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferable;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.UpdateTokenData;

public interface AsynchronousTokensService {

    /**
     * @param callback
     */
    void getAllTokensAsync(Callback<GraphQLResponse<TokensData>> callback);

    /**
     * @param tokenId
     * @param creator
     * @param name
     * @param totalSupply
     * @param initialSupply
     * @param supplyModel
     * @param meltValue
     * @param meltFeePercentage
     * @param transferable
     * @param transferFeeSettings
     * @param allowsCustomAdapters
     * @param nonFungible
     * @param firstBlock
     * @param blockHeight
     * @param tokenIdAsInt
     * @param markedForDelete
     * @param callback
     */
    void getTokensAsync(String tokenId,
                        String creator,
                        String name,
                        String totalSupply,
                        String initialSupply,
                        TokenSupplyModel supplyModel,
                        String meltValue,
                        String meltFeePercentage,
                        TokenTransferable transferable,
                        TokenTransferFeeSettings transferFeeSettings,
                        Boolean allowsCustomAdapters,
                        Boolean nonFungible,
                        Integer firstBlock,
                        Integer blockHeight,
                        Boolean tokenIdAsInt,
                        Boolean markedForDelete,
                        Callback<GraphQLResponse<TokensData>> callback);

    /**
     * @param tokenId
     * @param creator
     * @param name
     * @param totalSupply
     * @param initialSupply
     * @param supplyModel
     * @param meltValue
     * @param meltFeePercentage
     * @param transferable
     * @param transferFeeSettings
     * @param nonFungible
     * @param fromBlockchain
     * @param callback
     */
    void createTokenAsync(String tokenId,
                          String creator,
                          String name,
                          String totalSupply,
                          String initialSupply,
                          TokenSupplyModel supplyModel,
                          String meltValue,
                          String meltFeePercentage,
                          TokenTransferable transferable,
                          TokenTransferFeeSettings transferFeeSettings,
                          Boolean nonFungible,
                          Boolean fromBlockchain,
                          Callback<GraphQLResponse<CreateTokenData>> callback);

    /**
     * @param tokenId
     * @param creator
     * @param name
     * @param totalSupply
     * @param initialSupply
     * @param supplyModel
     * @param meltValue
     * @param meltFeePercentage
     * @param transferable
     * @param transferFeeSettings
     * @param nonFungible
     * @param fromBlockchain
     * @param callback
     */
    void updateTokenAsync(String tokenId,
                          String creator,
                          String name,
                          String totalSupply,
                          String initialSupply,
                          TokenSupplyModel supplyModel,
                          String meltValue,
                          String meltFeePercentage,
                          TokenTransferable transferable,
                          TokenTransferFeeSettings transferFeeSettings,
                          Boolean nonFungible,
                          Boolean fromBlockchain,
                          Callback<GraphQLResponse<UpdateTokenData>> callback);

}
