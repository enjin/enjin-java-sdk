package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateTokenResult;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokensResult;
import com.enjin.enjincoin.sdk.model.service.tokens.ImportToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateTokenResult;
import com.enjin.enjincoin.sdk.http.HttpCallback;

/**
 * Asynchronous methods for querying and mutating app tokens.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousTokensService {

    /**
     * Gets all app tokens.
     *
     * @param callback the callback.
     */
    void getAllTokensAsync(HttpCallback<GraphQLResponse<GetTokensResult>> callback);

    /**
     * Gets app tokens that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getTokensAsync(GetTokens query,
                        HttpCallback<GraphQLResponse<GetTokensResult>> callback);

    /**
     * Imports a token from the blockchain.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void importTokenAsync(ImportToken query,
                          HttpCallback<GraphQLResponse<CreateTokenResult>> callback);

    /**
     * Updates an app token.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void updateTokenAsync(UpdateToken query,
                          HttpCallback<GraphQLResponse<UpdateTokenResult>> callback);

}
