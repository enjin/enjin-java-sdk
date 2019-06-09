package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.tokens.CreateTokenResult;
import com.enjin.enjincoin.sdk.model.service.tokens.GetTokensResult;
import com.enjin.enjincoin.sdk.model.service.tokens.UpdateTokenResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TokensRetrofitService {

    @POST("graphql")
    @GraphQuery("GET_ALL_TOKENS")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetTokensResult>> getAllTokens(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GET_TOKENS")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetTokensResult>> getTokens(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("IMPORT_TOKEN")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateTokenResult>> importToken(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UPDATE_TOKEN")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateTokenResult>> updateToken(@Body GraphQLRequest request);

}
