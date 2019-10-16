package com.enjin.sdk.service.balances.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.balances.Balance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BalancesRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetBalances")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Balance>>> getBalances(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
