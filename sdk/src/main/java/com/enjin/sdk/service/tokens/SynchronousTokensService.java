package com.enjin.sdk.service.tokens;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.tokens.GetToken;
import com.enjin.sdk.model.service.tokens.GetTokenEvents;
import com.enjin.sdk.model.service.tokens.GetTokens;
import com.enjin.sdk.model.service.tokens.InvalidateTokenMetadata;
import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.model.service.tokens.TokenEvent;

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
    HttpResponse<GraphQLResponse<List<Token>>> getTokensSync(GetTokens query);

    HttpResponse<GraphQLResponse<Token>> getTokenSync(GetToken query);

    HttpResponse<GraphQLResponse<List<TokenEvent>>> getTokenEventsSync(GetTokenEvents query);

    HttpResponse<GraphQLResponse<Boolean>> invalidateTokenMetaSync(InvalidateTokenMetadata query);

}
