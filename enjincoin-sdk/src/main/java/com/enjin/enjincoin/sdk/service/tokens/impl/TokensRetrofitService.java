package com.enjin.enjincoin.sdk.service.tokens.impl;

import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.tokens.Token;
import com.enjin.enjincoin.sdk.model.service.tokens.TokenEvent;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TokensRetrofitService {

    @POST("graphql")
    @GraphQuery("GetTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Token>>> getTokens(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> createToken(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> updateToken(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> deleteToken(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GetTokenEvents")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<TokenEvent>>> getTokenEvents(@Body GraphQLRequest request);

}
