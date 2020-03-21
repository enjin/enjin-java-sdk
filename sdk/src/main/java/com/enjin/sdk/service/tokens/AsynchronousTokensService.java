package com.enjin.sdk.service.tokens;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.tokens.GetToken;
import com.enjin.sdk.model.service.tokens.GetTokenEvents;
import com.enjin.sdk.model.service.tokens.GetTokens;
import com.enjin.sdk.model.service.tokens.InvalidateTokenMetadata;
import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.model.service.tokens.TokenEvent;

/**
 * Asynchronous methods for querying and mutating app tokens.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousTokensService {

    /**
     * Gets app tokens that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getTokensAsync(GetTokens query,
                        HttpCallback<GraphQLResponse<List<Token>>> callback);

    void getTokenAsync(GetToken query,
                       HttpCallback<GraphQLResponse<Token>> callback);

    void getTokenEventsAsync(GetTokenEvents query,
                             HttpCallback<GraphQLResponse<List<TokenEvent>>> callback);

    void invalidateTokenMetaAsync(InvalidateTokenMetadata query,
                                  HttpCallback<GraphQLResponse<Boolean>> callback);

}
