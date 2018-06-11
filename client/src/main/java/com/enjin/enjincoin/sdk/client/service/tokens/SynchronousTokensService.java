package com.enjin.enjincoin.sdk.client.service.tokens;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousTokensService {

    Response<GraphQLResponse> getAllTokensSync() throws IOException;

    Response<GraphQLResponse> getTokensSync(Integer id,
                                        String creator,
                                        String name,
                                        Integer firstBlock,
                                        Integer blockHeight) throws IOException;

    Response<GraphQLResponse> createTokenSync(Integer tokenId,
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

    Response<GraphQLResponse> updateTokenSync(Integer tokenId,
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
