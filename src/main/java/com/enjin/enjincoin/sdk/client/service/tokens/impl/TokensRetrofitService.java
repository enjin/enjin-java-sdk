package com.enjin.enjincoin.sdk.client.service.tokens.impl;

import com.enjin.enjincoin.sdk.client.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.data.UpdateTokenData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TokensRetrofitService {

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetAllTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<TokensData>> getAllTokens(@Body GraphQLRequest.Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<TokensData>> getTokens(@Body GraphQLRequest.Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateTokenData>> createToken(@Body GraphQLRequest.Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateTokenData>> updateToken(@Body GraphQLRequest.Builder Token);

}
