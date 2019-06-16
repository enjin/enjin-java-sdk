package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.tokens.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

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

}
