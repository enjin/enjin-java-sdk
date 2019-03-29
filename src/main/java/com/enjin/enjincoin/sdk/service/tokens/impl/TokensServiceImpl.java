package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenSupplyModel;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.service.tokens.vo.TokenTransferable;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class TokensServiceImpl extends ServiceBase implements TokensService {

    private final TokensRetrofitService service;

    public TokensServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(TokensRetrofitService.class);
    }

    @Override
    public void getAllTokensAsync(final Callback<GraphQLResponse<TokensData>> callback) {
        enqueue(getAllTokensCall(), callback);
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
        enqueue(getTokensCall(tokenId,
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
                              markedForDelete),
                callback);
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
        enqueue(getCreateTokenCall(tokenId,
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
                                   fromBlockchain),
                callback);
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
        enqueue(getUpdateTokenCall(tokenId,
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
                                   fromBlockchain),
                callback);
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException {
        return execute(getAllTokensCall());
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
        return execute(getTokensCall(tokenId,
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
                                     markedForDelete));
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
        return execute(getCreateTokenCall(tokenId,
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
                                          fromBlockchain));
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
        return execute(getUpdateTokenCall(tokenId,
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
                                          fromBlockchain));
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
