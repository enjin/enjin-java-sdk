package com.enjin.sdk.service.tokens.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SchemaProvider;
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
    private final SchemaProvider schemaProvider;

    public TokensServiceImpl(Retrofit retrofit, SchemaProvider schemaProvider) {
        this.service = retrofit.create(TokensRetrofitService.class);
        this.schemaProvider = schemaProvider;
    }

    @Override
    public void getTokensAsync(GetTokens query,
                               HttpCallback<GraphQLResponse<List<Token>>> callback) {
        enqueueGraphQLCall(this.service.getTokens(schemaProvider.get(), query), callback);
    }

    @Override
    public void createTokenAsync(CreateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(this.service.createToken(schemaProvider.get(), query), callback);
    }

    @Override
    public void updateTokenAsync(UpdateToken query,
                                 HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(this.service.updateToken(schemaProvider.get(), query), callback);
    }

    @Override
    public void deleteTokenAsync(DeleteToken query, HttpCallback<GraphQLResponse<Token>> callback) {
        enqueueGraphQLCall(this.service.deleteToken(schemaProvider.get(), query), callback);
    }

    @Override
    public void getTokenEventsAsync(GetTokenEvents query, HttpCallback<GraphQLResponse<List<TokenEvent>>> callback) {
        enqueueGraphQLCall(this.service.getTokenEvents(schemaProvider.get(), query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query) throws IOException {
        return executeGraphQLCall(this.service.getTokens(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> createTokenSync(CreateToken query) throws IOException {
        return executeGraphQLCall(this.service.createToken(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> updateTokenSync(UpdateToken query) throws IOException {
        return executeGraphQLCall(this.service.updateToken(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Token>> deleteTokenSync(DeleteToken query) throws IOException {
        return executeGraphQLCall(this.service.deleteToken(schemaProvider.get(), query));
    }

    @Override
    public HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query) throws IOException {
        return executeGraphQLCall(this.service.getTokenEvents(schemaProvider.get(), query));
    }

}
