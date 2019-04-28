package com.enjin.enjincoin.sdk.service.tokens;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateTokenResult;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokens;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokensResult;
import com.enjin.enjincoin.sdk.model.service.tokens.ImportToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateToken;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateTokenResult;

import java.io.IOException;

public interface SynchronousTokensService {

    /**
     * Gets all app tokens.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetTokensResult>> getAllTokensSync() throws IOException;


    /**
     * Gets app tokens that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetTokensResult>> getTokensSync(GetTokens query) throws IOException;

    /**
     * Imports a token from the blockchain.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<CreateTokenResult>> importTokenSync(ImportToken query) throws IOException;

    /**
     * Updates an app token.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<UpdateTokenResult>> updateTokenSync(UpdateToken query) throws IOException;

}
