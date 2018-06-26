package com.enjin.enjincoin.sdk.client.service.tokens;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousTokensService {

    /**
     *
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException;

    /**
     *
     * @param tokenId
     * @param creator
     * @param name
     * @param firstBlock
     * @param blockHeight
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<TokensData>> getTokensSync(Integer tokenId,
                                                        String creator,
                                                        String name,
                                                        Integer firstBlock,
                                                        Integer blockHeight) throws IOException;

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
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<CreateTokenData>> createTokenSync(Integer tokenId,
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
                                                               Boolean fromBlockchain) throws IOException;

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
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(Integer tokenId,
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
                                                               Boolean fromBlockchain) throws IOException;

}
