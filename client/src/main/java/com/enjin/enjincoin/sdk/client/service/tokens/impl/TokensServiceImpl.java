package com.enjin.enjincoin.sdk.client.service.tokens.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class TokensServiceImpl implements TokensService {

    private final GraphQLRetrofitService service;

    public TokensServiceImpl(final GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void getAllTokensAsync(final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = getAllTokensCall();
        call.enqueue(callback);
    }

    @Override
    public void getTokensAsync(final Integer id,
                               final String creator,
                               final String name,
                               final Integer firstBlock,
                               final Integer blockHeight,
                               final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
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
                                 final Boolean fromBlockchain, final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = getCreateTokenCall(tokenId,
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
                                 final Boolean fromBlockchain, final Callback<GraphQLResponse> callback) {
        final Call<GraphQLResponse> call = getUpdateTokenCall(tokenId,
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
    public Response<GraphQLResponse> getAllTokensSync() throws IOException {
        final Call<GraphQLResponse> call = getAllTokensCall();
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse> getTokensSync(final Integer id,
                                               final String creator,
                                               final String name,
                                               final Integer firstBlock,
                                               final Integer blockHeight) throws IOException {
        final Call<GraphQLResponse> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse> createTokenSync(final Integer tokenId,
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
        final Call<GraphQLResponse> call = getCreateTokenCall(tokenId,
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
    public Response<GraphQLResponse> updateTokenSync(final Integer tokenId,
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
        final Call<GraphQLResponse> call = getUpdateTokenCall(tokenId,
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

    private Call<GraphQLResponse> getAllTokensCall() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/getAllTokens.query")
                .build().call();
    }

    private Call<GraphQLResponse> getTokensCall(final Integer id,
                                            final String creator,
                                            final String name,
                                            final Integer firstBlock,
                                            final Integer blockHeight) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/getAllTokens.query")
                .withParameter("id", id)
                .withParameter("creator", creator)
                .withParameter("name", name)
                .withParameter("firstBlock", firstBlock)
                .withParameter("blockHeight", blockHeight)
                .build().call();
    }

    private Call<GraphQLResponse> getCreateTokenCall(final Integer tokenId,
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
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/createToken.mutation")
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
                .withParameter("fromBlockchain", fromBlockchain)
                .build().call();
    }

    private Call<GraphQLResponse> getUpdateTokenCall(final Integer tokenId,
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
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/updateToken.mutation")
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
                .withParameter("fromBlockchain", fromBlockchain)
                .build().call();
    }

}
