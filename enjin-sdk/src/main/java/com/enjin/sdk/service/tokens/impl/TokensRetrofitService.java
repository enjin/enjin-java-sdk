package com.enjin.sdk.service.tokens.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.model.service.tokens.TokenEvent;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TokensRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Token>>> getTokens(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("CreateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> createToken(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("UpdateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> updateToken(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("DeleteToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Token>> deleteToken(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("GetTokenEvents")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<TokenEvent>>> getTokenEvents(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
