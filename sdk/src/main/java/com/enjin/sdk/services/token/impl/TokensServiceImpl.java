package com.enjin.sdk.services.token.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.token.GetToken;
import com.enjin.sdk.models.token.event.GetTokenEvents;
import com.enjin.sdk.models.token.GetTokens;
import com.enjin.sdk.models.token.InvalidateTokenMetadata;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.event.TokenEvent;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.token.TokensService;

import retrofit2.Retrofit;

/**
 * Implementation class of {@link TokensService}.
 *
 * @see TokensService
 */
public class TokensServiceImpl extends GraphQLServiceBase implements TokensService {

    private final TokensRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit a retrofit adapter
     */
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
    public void getTokenEventsAsync(GetTokenEvents query, HttpCallback<GraphQLResponse<List<TokenEvent>>> callback) {
        enqueueGraphQLCall(this.service.getTokenEvents(query), callback);
    }

    @Override
    public void invalidateTokenMetaAsync(InvalidateTokenMetadata query,
                                         HttpCallback<GraphQLResponse<Boolean>> callback) {
        enqueueGraphQLCall(this.service.invalidateTokenMetadata(query), callback);
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
    public HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query) {
        return executeGraphQLCall(this.service.getTokenEvents(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<Boolean>> invalidateTokenMetaSync(InvalidateTokenMetadata query) {
        return executeGraphQLCall(this.service.invalidateTokenMetadata(query));
    }

}
