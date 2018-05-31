package com.enjin.enjincoin.sdk.client.service.tokens;

import com.google.gson.JsonElement;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousTokensService {

    Response<JsonElement> getAllTokensSync() throws IOException;

    Response<JsonElement> getTokensSync(Integer id,
                                        String creator,
                                        String name,
                                        Integer firstBlock,
                                        Integer blockHeight) throws IOException;

    Response<JsonElement> createTokenSync(Integer tokenId,
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

    Response<JsonElement> updateTokenSync(Integer tokenId,
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
