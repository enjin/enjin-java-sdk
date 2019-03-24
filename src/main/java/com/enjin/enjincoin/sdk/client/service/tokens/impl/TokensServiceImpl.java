package com.enjin.enjincoin.sdk.client.service.tokens.impl;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.TokenSupplyModel;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.TokenTransferable;
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
    public void getTokensAsync(String tokenId,
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
                               Callback<GraphQLResponse<TokensData>> callback) {
        final Call<GraphQLResponse<TokensData>> call = getTokensCall(tokenId,
                creator,
                name,
                totalSupply,
                initialSupply,
                supplyModel,
                meltValue,
                meltFeePercentage,
                transferable,
                transferFeeSettings,
                allowsCustomAdapters,
                nonFungible,
                firstBlock,
                blockHeight,
                tokenIdAsInt,
                markedForDelete);
        call.enqueue(callback);
    }

    @Override
    public void createTokenAsync(String tokenId,
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
                                 Callback<GraphQLResponse<CreateTokenData>> callback) {
        final Call<GraphQLResponse<CreateTokenData>> call = getCreateTokenCall(tokenId,
                creator,
                name,
                totalSupply,
                initialSupply,
                supplyModel,
                meltValue,
                meltFeePercentage,
                transferable,
                transferFeeSettings,
                nonFungible,
                fromBlockchain);
        call.enqueue(callback);
    }

    @Override
    public void updateTokenAsync(String tokenId,
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
                                 Callback<GraphQLResponse<UpdateTokenData>> callback) {
        final Call<GraphQLResponse<UpdateTokenData>> call = getUpdateTokenCall(tokenId,
                creator,
                name,
                totalSupply,
                initialSupply,
                supplyModel,
                meltValue,
                meltFeePercentage,
                transferable,
                transferFeeSettings,
                nonFungible,
                fromBlockchain);
        call.enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException {
        final Call<GraphQLResponse<TokensData>> call = getAllTokensCall();
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getTokensSync(String tokenId,
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
                                                               Boolean markedForDelete) throws IOException {
        final Call<GraphQLResponse<TokensData>> call = getTokensCall(tokenId,
                creator,
                name,
                totalSupply,
                initialSupply,
                supplyModel,
                meltValue,
                meltFeePercentage,
                transferable,
                transferFeeSettings,
                allowsCustomAdapters,
                nonFungible,
                firstBlock,
                blockHeight,
                tokenIdAsInt,
                markedForDelete);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<CreateTokenData>> createTokenSync(String tokenId,
                                                                      String creator,
                                                                      String name,
                                                                      String totalSupply, String initialSupply,
                                                                      TokenSupplyModel supplyModel,
                                                                      String meltValue,
                                                                      String meltFeePercentage,
                                                                      TokenTransferable transferable,
                                                                      TokenTransferFeeSettings transferFeeSettings,
                                                                      Boolean nonFungible,
                                                                      Boolean fromBlockchain) throws IOException {
        final Call<GraphQLResponse<CreateTokenData>> call = getCreateTokenCall(tokenId,
                creator,
                name,
                totalSupply,
                initialSupply,
                supplyModel,
                meltValue,
                meltFeePercentage,
                transferable,
                transferFeeSettings,
                nonFungible,
                fromBlockchain);
        return call.execute();
    }

    @Override
    public Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(String tokenId,
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
                                                                      Boolean fromBlockchain) throws IOException {
        final Call<GraphQLResponse<UpdateTokenData>> call = getUpdateTokenCall(tokenId,
                creator,
                name,
                totalSupply,
                initialSupply,
                supplyModel,
                meltValue,
                meltFeePercentage,
                transferable,
                transferFeeSettings,
                nonFungible,
                fromBlockchain);
        return call.execute();
    }

    private Call<GraphQLResponse<TokensData>> getAllTokensCall() {
        return this.service.getAllTokens(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<TokensData>> getTokensCall(String tokenId,
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
                                                            Boolean markedForDelete) {
        return this.service.getTokens(GraphQLRequest.builder()
                .withParameter("token_id", tokenId)
                .withParameter("creator", creator)
                .withParameter("name", name)
                .withParameter("totalSupply", totalSupply)
                .withParameter("initialSupply", initialSupply)
                .withParameter("supplyModel", supplyModel)
                .withParameter("meltValue", meltValue)
                .withParameter("meltFeePercentage", meltFeePercentage)
                .withParameter("transferable", transferable)
                .withParameter("transferFeeSettings", transferFeeSettings)
                .withParameter("allowsCustomAdapters", allowsCustomAdapters)
                .withParameter("nonFungible", nonFungible)
                .withParameter("firstBlock", firstBlock)
                .withParameter("blockHeight", blockHeight)
                .withParameter("token_id_as_int", tokenIdAsInt)
                .withParameter("markedForDelete", markedForDelete));
    }

    private Call<GraphQLResponse<CreateTokenData>> getCreateTokenCall(String tokenId,
                                                                      String creator,
                                                                      String name,
                                                                      String totalSupply, String initialSupply,
                                                                      TokenSupplyModel supplyModel,
                                                                      String meltValue,
                                                                      String meltFeePercentage,
                                                                      TokenTransferable transferable,
                                                                      TokenTransferFeeSettings transferFeeSettings,
                                                                      Boolean nonFungible,
                                                                      Boolean fromBlockchain) {
        return this.service.createToken(GraphQLRequest.builder()
                .withParameter("token_id", tokenId)
                .withParameter("creator", creator)
                .withParameter("name", name)
                .withParameter("totalSupply", totalSupply)
                .withParameter("initialSupply", initialSupply)
                .withParameter("supplyModel", supplyModel)
                .withParameter("meltValue", meltValue)
                .withParameter("meltFeePercentage", meltFeePercentage)
                .withParameter("transferable", transferable)
                .withParameter("transferFeeSettings", transferFeeSettings)
                .withParameter("nonFungible", nonFungible)
                .withParameter("fromBlockchain", fromBlockchain));
    }

    private Call<GraphQLResponse<UpdateTokenData>> getUpdateTokenCall(String tokenId,
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
                                                                      Boolean fromBlockchain) {
        return this.service.updateToken(GraphQLRequest.builder()
                .withParameter("token_id", tokenId)
                .withParameter("creator", creator)
                .withParameter("name", name)
                .withParameter("totalSupply", totalSupply)
                .withParameter("initialSupply", initialSupply)
                .withParameter("supplyModel", supplyModel)
                .withParameter("meltValue", meltValue)
                .withParameter("meltFeePercentage", meltFeePercentage)
                .withParameter("transferable", transferable)
                .withParameter("transferFeeSettings", transferFeeSettings)
                .withParameter("nonFungible", nonFungible)
                .withParameter("fromBlockchain", fromBlockchain));
    }

}
