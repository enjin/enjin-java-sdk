package com.enjin.sdk.service.ethereum.impl;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.ethereum.Block;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EthereumRetrofitService {

    @POST("graphql")
    @GraphQuery("GetBlockHeight")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Block>> getBlock(@Body GraphQLRequest request);

}
