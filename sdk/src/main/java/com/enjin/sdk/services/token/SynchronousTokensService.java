package com.enjin.sdk.services.token;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.token.GetToken;
import com.enjin.sdk.models.token.event.GetTokenEvents;
import com.enjin.sdk.models.token.GetTokens;
import com.enjin.sdk.models.token.InvalidateTokenMetadata;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.event.TokenEvent;

/**
 * Synchronous methods for querying and mutating app tokens.
 */
public interface SynchronousTokensService {

    /**
     * Gets application tokens that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query);

    /**
     * Gets an application token that matches the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Token>> getTokenSync(GetToken query);

    /**
     * Gets token events that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query);

    /**
     * Invalidates a token's cached metadata.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<Boolean>> invalidateTokenMetaSync(InvalidateTokenMetadata query);

}
