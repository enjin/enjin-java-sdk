package com.enjin.sdk.services.balance.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.balance.Balance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BalancesRetrofitService {

    @POST("graphql")
    @GraphQuery("GetBalancesPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Balance>>> getBalances(@Body GraphQLRequest request);

}
