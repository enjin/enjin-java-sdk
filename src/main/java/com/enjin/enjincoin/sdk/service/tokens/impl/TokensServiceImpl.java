package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateTokenResult;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokensResult;
import com.enjin.enjincoin.sdk.model.service.tokens.ImportToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateTokenResult;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.util.concurrent.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class TokensServiceImpl extends ServiceBase implements TokensService {

    private final TokensRetrofitService service;

    public TokensServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(TokensRetrofitService.class);
    }

    @Override
    public void getAllTokensAsync(Callback<GraphQLResponse<GetTokensResult>> callback) {
        enqueue(getAllTokensCall(), callback);
    }

    @Override
    public void getTokensAsync(GetTokens query,
                               Callback<GraphQLResponse<GetTokensResult>> callback) {
        enqueue(getTokensCall(query), callback);
    }

    @Override
    public void importTokenAsync(ImportToken query,
                                 Callback<GraphQLResponse<CreateTokenResult>> callback) {
        enqueue(getImportTokenCall(query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 Callback<GraphQLResponse<UpdateTokenResult>> callback) {
        enqueue(getUpdateTokenCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<GetTokensResult>> getAllTokensSync() throws IOException {
        return execute(getAllTokensCall());
    }

    @Override
    public Response<GraphQLResponse<GetTokensResult>> getTokensSync(GetTokens query) throws IOException {
        return execute(getTokensCall(query));
    }

    @Override
    public Response<GraphQLResponse<CreateTokenResult>> importTokenSync(ImportToken query) throws IOException {
        return execute(getImportTokenCall(query));
    }

    @Override
    public Response<GraphQLResponse<UpdateTokenResult>> updateTokenSync(UpdateToken query) throws IOException {
        return execute(getUpdateTokenCall(query));
    }

    private Call<GraphQLResponse<GetTokensResult>> getAllTokensCall() {
        return this.service.getAllTokens(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<GetTokensResult>> getTokensCall(GetTokens query) {
        return this.service.getTokens(query);
    }

    private Call<GraphQLResponse<CreateTokenResult>> getImportTokenCall(ImportToken query) {
        return this.service.importToken(query);
    }

    private Call<GraphQLResponse<UpdateTokenResult>> getUpdateTokenCall(UpdateToken query) {
        return this.service.updateToken(query);
    }

}
