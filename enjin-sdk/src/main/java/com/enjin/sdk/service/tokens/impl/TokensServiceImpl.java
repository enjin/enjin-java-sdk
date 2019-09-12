package com.enjin.sdk.service.tokens.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.tokens.CreateToken;
import com.enjin.sdk.model.service.tokens.DeleteToken;
import com.enjin.sdk.model.service.tokens.GetTokenEvents;
import com.enjin.sdk.model.service.tokens.GetTokens;
import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.model.service.tokens.TokenEvent;
import com.enjin.sdk.model.service.tokens.UpdateToken;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.tokens.TokensService;

import retrofit2.Call;
import retrofit2.Retrofit;

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
    public void createTokenAsync(CreateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(getImportTokenCall(query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(getUpdateTokenCall(query), callback);
    }

    @Override
    public void deleteTokenAsync(DeleteToken query, HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(getDeleteTokenCall(query), callback);
    }

    @Override
    public void getTokenEventsAsync(GetTokenEvents query, HttpCallback<GraphQLResponse<List<TokenEvent>>> callback) {
        enqueueGraphQLCall(getTokenEventsCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query) throws IOException {
        return executeGraphQLCall(getTokensCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> createTokenSync(CreateToken query) throws IOException {
        return executeGraphQLCall(getImportTokenCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> updateTokenSync(UpdateToken query) throws IOException {
        return executeGraphQLCall(getUpdateTokenCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> deleteTokenSync(DeleteToken query) throws IOException {
        return executeGraphQLCall(getDeleteTokenCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query) throws IOException {
        return executeGraphQLCall(getTokenEventsCall(query));
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

    private Call<GraphQLResponse<Token>> getDeleteTokenCall(DeleteToken query) {
        return this.service.deleteToken(query);
    }

    private Call<GraphQLResponse<List<TokenEvent>>> getTokenEventsCall(GetTokenEvents query) {
        return this.service.getTokenEvents(query);
    }

}
