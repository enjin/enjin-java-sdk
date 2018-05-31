package com.enjin.enjincoin.sdk.client.service.tokens.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class TokensServiceImpl implements TokensService {

    private GraphQLRetrofitService service;

    public TokensServiceImpl(GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void getAllTokensAsync(Callback<JsonElement> callback) {
        Call<JsonElement> call = getAllTokensCall();
        call.enqueue(callback);
    }

    @Override
    public void getTokensAsync(Integer id,
                               String creator,
                               String name,
                               Integer firstBlock,
                               Integer blockHeight,
                               Callback<JsonElement> callback) {
        Call<JsonElement> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
        call.enqueue(callback);
    }

    @Override
    public void createTokenAsync(Integer tokenId,
                                 Integer app_id,
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
                                 Boolean fromBlockchain, Callback<JsonElement> callback) {
        Call<JsonElement> call = getCreateTokenCall(tokenId,
                app_id,
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
    public void updateTokenAsync(Integer tokenId,
                                 Integer app_id,
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
                                 Boolean fromBlockchain, Callback<JsonElement> callback) {
        Call<JsonElement> call = getUpdateTokenCall(tokenId,
                app_id,
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
    public Response<JsonElement> getAllTokensSync() throws IOException {
        Call<JsonElement> call = getAllTokensCall();
        return call.execute();
    }

    @Override
    public Response<JsonElement> getTokensSync(Integer id,
                                               String creator,
                                               String name,
                                               Integer firstBlock,
                                               Integer blockHeight) throws IOException {
        Call<JsonElement> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
        return call.execute();
    }

    @Override
    public Response<JsonElement> createTokenSync(Integer tokenId,
                                                 Integer app_id,
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
                                                 Boolean fromBlockchain) throws IOException {
        Call<JsonElement> call = getCreateTokenCall(tokenId,
                app_id,
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
    public Response<JsonElement> updateTokenSync(Integer tokenId,
                                                 Integer app_id,
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
                                                 Boolean fromBlockchain) throws IOException {
        Call<JsonElement> call = getUpdateTokenCall(tokenId,
                app_id,
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

    private Call<JsonElement> getAllTokensCall() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/getAllTokens.query")
                .build().call();
    }

    private Call<JsonElement> getTokensCall(Integer id,
                                            String creator,
                                            String name,
                                            Integer firstBlock,
                                            Integer blockHeight) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/getAllTokens.query")
                .withParameter("id", id)
                .withParameter("creator", creator)
                .withParameter("name", name)
                .withParameter("firstBlock", firstBlock)
                .withParameter("blockHeight", blockHeight)
                .build().call();
    }

    private Call<JsonElement> getCreateTokenCall(Integer tokenId,
                                                 Integer app_id,
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
                                                 Boolean fromBlockchain) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/createToken.mutation")
                .withParameter("token_id", tokenId)
                .withParameter("app_id", app_id)
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

    private Call<JsonElement> getUpdateTokenCall(Integer tokenId,
                                                 Integer app_id,
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
                                                 Boolean fromBlockchain) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/tokens/updateToken.mutation")
                .withParameter("token_id", tokenId)
                .withParameter("app_id", app_id)
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
