package com.enjin.enjincoin.sdk.client.service.tokens.impl;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class TokensServiceImpl implements TokensService {

    private final TokensRetrofitService service;

    public TokensServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(TokensRetrofitService.class);
    }

    @Override
    public void getAllTokensAsync(final Callback<GraphQLResponse<TokensData>> callback) {
        final Call<GraphQLResponse<TokensData>> call = getAllTokensCall();
        call.enqueue(callback);
    }

    @Override
    public void getTokensAsync(final Integer id,
                               final String creator,
                               final String name,
                               final Integer firstBlock,
                               final Integer blockHeight,
                               final Callback<GraphQLResponse<TokensData>> callback) {
        final Call<GraphQLResponse<TokensData>> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
        call.enqueue(callback);
    }

    @Override
    public void createTokenAsync(final Integer tokenId,
                                 final Integer appId,
                                 final String creator,
                                 final String adapter,
                                 final String name,
                                 final String icon,
                                 final String totalSupply,
                                 final String exchangeRate,
                                 final Integer decimals,
                                 final String maxMeltFee,
                                 final String meltFee,
                                 final Integer transferable,
                                 final Integer firstBlock,
                                 final Integer blockHeight,
                                 final Boolean fromBlockchain, final Callback<GraphQLResponse<CreateTokenData>> callback) {
        final Call<GraphQLResponse<CreateTokenData>> call = getCreateTokenCall(tokenId,
                appId,
                creator,
                adapter,
                name,
                icon,
                totalSupply,
                exchangeRate,
                decimals,
                maxMeltFee,
                meltFee,
                transferable,
                firstBlock,
                blockHeight,
                fromBlockchain);
        call.enqueue(callback);
    }

    @Override
    public void updateTokenAsync(final Integer tokenId,
                                 final Integer appId,
                                 final String creator,
                                 final String adapter,
                                 final String name,
                                 final String icon,
                                 final String totalSupply,
                                 final String exchangeRate,
                                 final Integer decimals,
                                 final String maxMeltFee,
                                 final String meltFee,
                                 final Integer transferable,
                                 final Integer firstBlock,
                                 final Integer blockHeight,
                                 final Boolean fromBlockchain, final Callback<GraphQLResponse<UpdateTokenData>> callback) {
        final Call<GraphQLResponse<UpdateTokenData>> call = getUpdateTokenCall(tokenId,
                appId,
                creator,
                adapter,
                name,
                icon,
                totalSupply,
                exchangeRate,
                decimals,
                maxMeltFee,
                meltFee,
                transferable,
                firstBlock,
                blockHeight,
                fromBlockchain);
        call.enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException {
        final Call<GraphQLResponse<TokensData>> call = getAllTokensCall();
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getTokensSync(final Integer id,
                                                               final String creator,
                                                               final String name,
                                                               final Integer firstBlock,
                                                               final Integer blockHeight) throws IOException {
        final Call<GraphQLResponse<TokensData>> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<CreateTokenData>> createTokenSync(final Integer tokenId,
                                                                      final Integer appId,
                                                                      final String creator,
                                                                      final String adapter,
                                                                      final String name,
                                                                      final String icon,
                                                                      final String totalSupply,
                                                                      final String exchangeRate,
                                                                      final Integer decimals,
                                                                      final String maxMeltFee,
                                                                      final String meltFee,
                                                                      final Integer transferable,
                                                                      final Integer firstBlock,
                                                                      final Integer blockHeight,
                                                                      final Boolean fromBlockchain) throws IOException {
        final Call<GraphQLResponse<CreateTokenData>> call = getCreateTokenCall(tokenId,
                appId,
                creator,
                adapter,
                name,
                icon,
                totalSupply,
                exchangeRate,
                decimals,
                maxMeltFee,
                meltFee,
                transferable,
                firstBlock,
                blockHeight,
                fromBlockchain);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(final Integer tokenId,
                                                                      final Integer appId,
                                                                      final String creator,
                                                                      final String adapter,
                                                                      final String name,
                                                                      final String icon,
                                                                      final String totalSupply,
                                                                      final String exchangeRate,
                                                                      final Integer decimals,
                                                                      final String maxMeltFee,
                                                                      final String meltFee,
                                                                      final Integer transferable,
                                                                      final Integer firstBlock,
                                                                      final Integer blockHeight,
                                                                      final Boolean fromBlockchain) throws IOException {
        final Call<GraphQLResponse<UpdateTokenData>> call = getUpdateTokenCall(tokenId,
                appId,
                creator,
                adapter,
                name,
                icon,
                totalSupply,
                exchangeRate,
                decimals,
                maxMeltFee,
                meltFee,
                transferable,
                firstBlock,
                blockHeight,
                fromBlockchain);
        return call.execute();
    }

    private Call<GraphQLResponse<TokensData>> getAllTokensCall() {
        return this.service.getAllTokens(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<TokensData>> getTokensCall(final Integer id,
                                                            final String creator,
                                                            final String name,
                                                            final Integer firstBlock,
                                                            final Integer blockHeight) {
        return this.service.getTokens(GraphQLRequest.builder()
                .withParameter("id", id)
                .withParameter("creator", creator)
                .withParameter("name", name)
                .withParameter("firstBlock", firstBlock)
                .withParameter("blockHeight", blockHeight));
    }

    private Call<GraphQLResponse<CreateTokenData>> getCreateTokenCall(final Integer tokenId,
                                                                      final Integer appId,
                                                                      final String creator,
                                                                      final String adapter,
                                                                      final String name,
                                                                      final String icon,
                                                                      final String totalSupply,
                                                                      final String exchangeRate,
                                                                      final Integer decimals,
                                                                      final String maxMeltFee,
                                                                      final String meltFee,
                                                                      final Integer transferable,
                                                                      final Integer firstBlock,
                                                                      final Integer blockHeight,
                                                                      final Boolean fromBlockchain) {
        return this.service.createToken(GraphQLRequest.builder()
                .withParameter("token_id", tokenId)
                .withParameter("app_id", appId)
                .withParameter("creator", creator)
                .withParameter("adapter", adapter)
                .withParameter("name", name)
                .withParameter("icon", icon)
                .withParameter("totalSupply", totalSupply)
                .withParameter("exchangeRate", exchangeRate)
                .withParameter("decimals", decimals)
                .withParameter("maxMeltFee", maxMeltFee)
                .withParameter("meltFee", meltFee)
                .withParameter("transferable", transferable)
                .withParameter("firstBlock", firstBlock)
                .withParameter("blockHeight", blockHeight)
                .withParameter("fromBlockchain", fromBlockchain));
    }

    private Call<GraphQLResponse<UpdateTokenData>> getUpdateTokenCall(final Integer tokenId,
                                                                      final Integer appId,
                                                                      final String creator,
                                                                      final String adapter,
                                                                      final String name,
                                                                      final String icon,
                                                                      final String totalSupply,
                                                                      final String exchangeRate,
                                                                      final Integer decimals,
                                                                      final String maxMeltFee,
                                                                      final String meltFee,
                                                                      final Integer transferable,
                                                                      final Integer firstBlock,
                                                                      final Integer blockHeight,
                                                                      final Boolean fromBlockchain) {
        return this.service.updateToken(GraphQLRequest.builder()
                .withParameter("token_id", tokenId)
                .withParameter("app_id", appId)
                .withParameter("creator", creator)
                .withParameter("adapter", adapter)
                .withParameter("name", name)
                .withParameter("icon", icon)
                .withParameter("totalSupply", totalSupply)
                .withParameter("exchangeRate", exchangeRate)
                .withParameter("decimals", decimals)
                .withParameter("maxMeltFee", maxMeltFee)
                .withParameter("meltFee", meltFee)
                .withParameter("transferable", transferable)
                .withParameter("firstBlock", firstBlock)
                .withParameter("blockHeight", blockHeight)
                .withParameter("fromBlockchain", fromBlockchain));
    }

}
