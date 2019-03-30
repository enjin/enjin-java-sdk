package com.enjin.enjincoin.sdk.service.tokens.impl;

import com.enjin.enjincoin.sdk.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.CreateTokenData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.TokensData;
import com.enjin.enjincoin.sdk.service.tokens.vo.data.UpdateTokenData;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest.Builder;
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
    Call<GraphQLResponse<TokensData>> getAllTokens(@Body Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetTokens")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<TokensData>> getTokens(@Body Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateTokenData>> importToken(@Body Builder Token);

    /**
     * @param Token
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateToken")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateTokenData>> updateToken(@Body Builder Token);

}
