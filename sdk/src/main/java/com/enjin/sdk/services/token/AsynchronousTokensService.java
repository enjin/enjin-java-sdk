package com.enjin.sdk.services.token;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.token.GetToken;
import com.enjin.sdk.models.token.event.GetTokenEvents;
import com.enjin.sdk.models.token.GetTokens;
import com.enjin.sdk.models.token.InvalidateTokenMetadata;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.event.TokenEvent;

/**
 * Asynchronous methods for querying and mutating app tokens.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousTokensService {

    /**
     * Gets application tokens that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getTokensAsync(GetTokens query,
                        HttpCallback<GraphQLResponse<List<Token>>> callback);

    /**
     * Gets an application token that matches the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getTokenAsync(GetToken query,
                       HttpCallback<GraphQLResponse<Token>> callback);

    /**
     * Gets token events that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getTokenEventsAsync(GetTokenEvents query,
                             HttpCallback<GraphQLResponse<List<TokenEvent>>> callback);

    /**
     * Invalidates a token's cached metadata.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void invalidateTokenMetaAsync(InvalidateTokenMetadata query,
                                  HttpCallback<GraphQLResponse<Boolean>> callback);

}
