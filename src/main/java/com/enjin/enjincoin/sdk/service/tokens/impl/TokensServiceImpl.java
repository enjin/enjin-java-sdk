package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.Token;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class TokensServiceImpl extends GraphQLServiceBase implements TokensService {

    private final TokensRetrofitService service;

    public TokensServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(TokensRetrofitService.class);
    }

    @Override
    public void getTokensAsync(GetTokens query,
                               HttpCallback<GraphQLResponse<List<Token>>> callback) {
        enqueueGraphQLCall(getTokensCall(query), callback);
    }

    @Override
    public void importTokenAsync(CreateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(getImportTokenCall(query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(getUpdateTokenCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query) throws IOException {
        return executeGraphQLCall(getTokensCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> importTokenSync(CreateToken query) throws IOException {
        return executeGraphQLCall(getImportTokenCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> updateTokenSync(UpdateToken query) throws IOException {
        return executeGraphQLCall(getUpdateTokenCall(query));
    }

    private Call<GraphQLResponse<List<Token>>> getTokensCall(GetTokens query) {
        return this.service.getTokens(query);
    }

    private Call<GraphQLResponse<Token>> getImportTokenCall(CreateToken query) {
        return this.service.createToken(query);
    }

    private Call<GraphQLResponse<Token>> getUpdateTokenCall(UpdateToken query) {
        return this.service.updateToken(query);
    }

}
