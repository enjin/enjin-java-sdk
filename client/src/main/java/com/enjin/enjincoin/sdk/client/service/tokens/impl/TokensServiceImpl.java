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
    public void getTokensAsync(Integer id, String creator, String name, Integer firstBlock, Integer blockHeight, Callback<JsonElement> callback) {
        Call<JsonElement> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
        call.enqueue(callback);
    }

    @Override
    public Response<JsonElement> getAllTokensSync() throws IOException {
        Call<JsonElement> call = getAllTokensCall();
        return call.execute();
    }

    @Override
    public Response<JsonElement> getTokensSync(Integer id, String creator, String name, Integer firstBlock, Integer blockHeight) throws IOException {
        Call<JsonElement> call = getTokensCall(id, creator, name, firstBlock, blockHeight);
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

}
