package com.enjin.sdk.service.tokens;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.tokens.CreateToken;
import com.enjin.sdk.model.service.tokens.DeleteToken;
import com.enjin.sdk.model.service.tokens.GetTokenEvents;
import com.enjin.sdk.model.service.tokens.GetTokens;
import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.model.service.tokens.TokenEvent;
import com.enjin.sdk.model.service.tokens.UpdateToken;

public interface SynchronousTokensService {

    /**
     * Gets app tokens that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query) throws IOException;

    /**
     * Imports a token from the blockchain.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<Token>> createTokenSync(CreateToken query) throws IOException;

    /**
     * Updates an app token.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<Token>> updateTokenSync(UpdateToken query) throws IOException;

    HttpResponse<GraphQLResponse<Token>> deleteTokenSync(DeleteToken query) throws IOException;

    HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query) throws IOException;

}
