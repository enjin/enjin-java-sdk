package com.enjin.sdk.service.tokens.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.tokens.CreateToken;
import com.enjin.sdk.model.service.tokens.GetToken;
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
        enqueueGraphQLCall(this.service.getTokens(query), callback);
    }

    @Override
    public void getTokenAsync(GetToken query, HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(this.service.getToken(query), callback);
    }

    @Override
    public void createTokenAsync(CreateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(this.service.createToken(query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(this.service.updateToken(query), callback);
    }

    @Override
    public void getTokenEventsAsync(GetTokenEvents query, HttpCallback<GraphQLResponse<List<TokenEvent>>> callback) {
        enqueueGraphQLCall(this.service.getTokenEvents(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query) {
        return executeGraphQLCall(this.service.getTokens(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> getTokenSync(GetToken query) {
        return executeGraphQLCall(this.service.getToken(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> createTokenSync(CreateToken query) {
        return executeGraphQLCall(this.service.createToken(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> updateTokenSync(UpdateToken query) {
        return executeGraphQLCall(this.service.updateToken(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query) {
        return executeGraphQLCall(this.service.getTokenEvents(query));
    }

}
