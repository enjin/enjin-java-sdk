package com.enjin.enjincoin.sdk.service.balances.impl;

import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.balances.Balance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BalancesRetrofitService {

    @POST("graphql")
    @GraphQuery("GetBalances")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Balance>>> getBalances(@Body GraphQLRequest request);

}
