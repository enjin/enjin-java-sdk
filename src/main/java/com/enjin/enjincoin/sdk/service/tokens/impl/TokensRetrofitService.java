package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest.Builder;
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

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetAllTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetTokensResult>> getAllTokens(@Body Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetTokensResult>> getTokens(@Body Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateTokenResult>> importToken(@Body Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateTokenResult>> updateToken(@Body Builder Token);

}
