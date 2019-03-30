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
                               String tokenIndex,
                               String name,
                               String creator,
                               String totalSupply,
                               String reserve,
                               TokenSupplyModel supplyModel,
                               String meltValue,
                               String meltFeeRatio,
                               TokenTransferable transferable,
                               TokenTransferFeeSettings transferFeeSettings,
                               Boolean nonFungible,
                               Integer firstBlock,
                               Integer blockHeight,
                               Boolean tokenIdAsInt,
                               Boolean tokenIndexAsInt,
                               Boolean markedForDelete,
                               Callback<GraphQLResponse<TokensData>> callback) {
        enqueue(getTokensCall(tokenId,
                              tokenIndex,
                              name,
                              creator,
                              totalSupply,
                              reserve,
                              supplyModel,
                              meltValue,
                              meltFeeRatio,
                              transferable,
                              transferFeeSettings,
                              nonFungible,
                              firstBlock,
                              blockHeight,
                              tokenIdAsInt,
                              tokenIndexAsInt,
                              markedForDelete),
                callback);
    }

    @Override
    public void importTokenAsync(String tokenId, Callback<GraphQLResponse<CreateTokenData>> callback) {
        enqueue(getImportTokenCall(tokenId), callback);
    }

    @Override
    public void updateTokenAsync(String tokenId,
                                 Integer appId,
                                 Boolean fromBlockchain,
                                 String updateIcon,
                                 Callback<GraphQLResponse<UpdateTokenData>> callback) {
        enqueue(getUpdateTokenCall(tokenId,
                                   appId,
                                   fromBlockchain,
                                   updateIcon),
                callback);
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException {
        return execute(getAllTokensCall());
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getTokensSync(String tokenId,
                                                               String tokenIndex,
                                                               String name,
                                                               String creator,
                                                               String totalSupply,
                                                               String reserve,
                                                               TokenSupplyModel supplyModel,
                                                               String meltValue,
                                                               String meltFeeRatio,
                                                               TokenTransferable transferable,
                                                               TokenTransferFeeSettings transferFeeSettings,
                                                               Boolean nonFungible,
                                                               Integer firstBlock,
                                                               Integer blockHeight,
                                                               Boolean tokenIdAsInt,
                                                               Boolean tokenIndexAsInt,
                                                               Boolean markedForDelete) throws IOException {
        return execute(getTokensCall(tokenId,
                                     tokenIndex,
                                     name,
                                     creator,
                                     totalSupply,
                                     reserve,
                                     supplyModel,
                                     meltValue,
                                     meltFeeRatio,
                                     transferable,
                                     transferFeeSettings,
                                     nonFungible,
                                     firstBlock,
                                     blockHeight,
                                     tokenIdAsInt,
                                     tokenIndexAsInt,
                                     markedForDelete));
    }

    @Override
    public Response<GraphQLResponse<CreateTokenData>> importTokenSync(String tokenId) throws IOException {
        return execute(getImportTokenCall(tokenId));
    }

    @Override
    public Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(String tokenId,
                                                                      Integer appId,
                                                                      Boolean fromBlockchain,
                                                                      String updateIcon) throws IOException {
        return execute(getUpdateTokenCall(tokenId,
                                          appId,
                                          fromBlockchain,
                                          updateIcon));
    }

    private Call<GraphQLResponse<TokensData>> getAllTokensCall() {
        return this.service.getAllTokens(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<TokensData>> getTokensCall(String tokenId,
                                                            String tokenIndex,
                                                            String name,
                                                            String creator,
                                                            String totalSupply,
                                                            String reserve,
                                                            TokenSupplyModel supplyModel,
                                                            String meltValue,
                                                            String meltFeeRatio,
                                                            TokenTransferable transferable,
                                                            TokenTransferFeeSettings transferFeeSettings,
                                                            Boolean nonFungible,
                                                            Integer firstBlock,
                                                            Integer blockHeight,
                                                            Boolean tokenIdAsInt,
                                                            Boolean tokenIndexAsInt,
                                                            Boolean markedForDelete) {
        return this.service.getTokens(GraphQLRequest.builder()
                                                    .withParameter("token_id", tokenId)
                                                    .withParameter("token_index", tokenIndex)
                                                    .withParameter("creator", creator)
                                                    .withParameter("name", name)
                                                    .withParameter("totalSupply", totalSupply)
                                                    .withParameter("reserve", reserve)
                                                    .withParameter("supplyModel", supplyModel)
                                                    .withParameter("meltValue", meltValue)
                                                    .withParameter("meltFeeRatio", meltFeeRatio)
                                                    .withParameter("transferable", transferable)
                                                    .withParameter("transferFeeSettings", transferFeeSettings)
                                                    .withParameter("nonFungible", nonFungible)
                                                    .withParameter("firstBlock", firstBlock)
                                                    .withParameter("blockHeight", blockHeight)
                                                    .withParameter("token_id_as_int", tokenIdAsInt)
                                                    .withParameter("token_index_as_int", tokenIndexAsInt)
                                                    .withParameter("markedForDelete", markedForDelete));
    }

    private Call<GraphQLResponse<CreateTokenData>> getImportTokenCall(String tokenId) {
        return this.service.importToken(GraphQLRequest.builder()
                                                      .withParameter("token_id", tokenId));
    }

    private Call<GraphQLResponse<UpdateTokenData>> getUpdateTokenCall(String tokenId,
                                                                      Integer appId,
                                                                      Boolean fromBlockchain,
                                                                      String updateIcon) {
        return this.service.updateToken(GraphQLRequest.builder()
                                                      .withParameter("token_id", tokenId)
                                                      .withParameter("app_id", appId)
                                                      .withParameter("fromBlockchain", fromBlockchain)
                                                      .withParameter("update_icon", updateIcon));
    }

}
