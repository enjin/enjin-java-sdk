package com.enjin.sdk.service.ethereum.impl;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.ethereum.Block;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EthereumRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetBlockHeight")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Block>> getBlock(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
