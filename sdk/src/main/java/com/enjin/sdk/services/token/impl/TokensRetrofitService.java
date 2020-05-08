package com.enjin.sdk.services.token.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.token.GetToken;
import com.enjin.sdk.models.token.GetTokens;
import com.enjin.sdk.models.token.InvalidateTokenMetadata;
import com.enjin.sdk.models.token.Token;
import com.enjin.sdk.models.token.event.GetTokenEvents;
import com.enjin.sdk.models.token.event.TokenEvent;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface TokensRetrofitService {

    /**
     * Gets the application tokens.
     *
     * @see GetTokens
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetTokensPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Token>>> getTokens(@Body GraphQLRequest request);

    /**
     * Gets an application token.
     *
     * @see GetToken
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> getToken(@Body GraphQLRequest request);

    /**
     * Gets token events.
     *
     * @see GetTokenEvents
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetTokenEventsPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<TokenEvent>>> getTokenEvents(@Body GraphQLRequest request);

    /**
     * Invalidates cached token metadata.
     *
     * @see InvalidateTokenMetadata
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("InvalidateTokenMetadata")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Boolean>> invalidateTokenMetadata(@Body GraphQLRequest request);

}
