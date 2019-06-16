package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.Token;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.http.HttpCallback;

import java.util.List;

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

    /**
     * Imports a token from the blockchain.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void importTokenAsync(CreateToken query,
                          HttpCallback<GraphQLResponse<Token>> callback);

    /**
     * Updates an app token.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void updateTokenAsync(UpdateToken query,
                          HttpCallback<GraphQLResponse<Token>> callback);

}
