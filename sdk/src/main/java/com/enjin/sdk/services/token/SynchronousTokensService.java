package com.enjin.sdk.services.token;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.token.GetToken;
import com.enjin.sdk.models.token.event.GetTokenEvents;
import com.enjin.sdk.models.token.GetTokens;
import com.enjin.sdk.models.token.InvalidateTokenMetadata;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.event.TokenEvent;

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
