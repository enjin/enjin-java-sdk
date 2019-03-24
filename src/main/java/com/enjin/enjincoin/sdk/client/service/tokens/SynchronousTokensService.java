package com.enjin.enjincoin.sdk.client.service.tokens;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.TokenSupplyModel;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.TokenTransferable;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousTokensService {

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException;


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
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<TokensData>> getTokensSync(String tokenId,
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
                                                        Boolean markedForDelete) throws IOException;

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
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<CreateTokenData>> createTokenSync(String tokenId,
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
                                                               Boolean fromBlockchain) throws IOException;


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
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(String tokenId,
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
                                                               Boolean fromBlockchain) throws IOException;

}
