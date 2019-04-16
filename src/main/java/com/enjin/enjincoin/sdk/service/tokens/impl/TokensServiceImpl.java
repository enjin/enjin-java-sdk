package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.GetTokens;
import com.enjin.enjincoin.sdk.model.query.ImportToken;
import com.enjin.enjincoin.sdk.model.query.UpdateToken;
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
    public void getTokensAsync(GetTokens query,
                               Callback<GraphQLResponse<TokensData>> callback) {
        enqueue(getTokensCall(query), callback);
    }

    @Override
    public void importTokenAsync(ImportToken query,
                                 Callback<GraphQLResponse<CreateTokenData>> callback) {
        enqueue(getImportTokenCall(query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 Callback<GraphQLResponse<UpdateTokenData>> callback) {
        enqueue(getUpdateTokenCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getAllTokensSync() throws IOException {
        return execute(getAllTokensCall());
    }

    @Override
    public Response<GraphQLResponse<TokensData>> getTokensSync(GetTokens query) throws IOException {
        return execute(getTokensCall(query));
    }

    @Override
    public Response<GraphQLResponse<CreateTokenData>> importTokenSync(ImportToken query) throws IOException {
        return execute(getImportTokenCall(query));
    }

    @Override
    public Response<GraphQLResponse<UpdateTokenData>> updateTokenSync(UpdateToken query) throws IOException {
        return execute(getUpdateTokenCall(query));
    }

    private Call<GraphQLResponse<TokensData>> getAllTokensCall() {
        return this.service.getAllTokens(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<TokensData>> getTokensCall(GetTokens query) {
        return this.service.getTokens(query);
    }

    private Call<GraphQLResponse<CreateTokenData>> getImportTokenCall(ImportToken query) {
        return this.service.importToken(query);
    }

    private Call<GraphQLResponse<UpdateTokenData>> getUpdateTokenCall(UpdateToken query) {
        return this.service.updateToken(query);
    }

}
