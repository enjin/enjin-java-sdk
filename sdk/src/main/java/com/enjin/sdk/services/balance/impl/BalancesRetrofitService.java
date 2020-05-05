package com.enjin.sdk.services.balance.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.balance.Balance;

import com.enjin.sdk.models.balance.GetBalances;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface BalancesRetrofitService {

    /**
     * Gets the balances.
     *
     * @see GetBalances
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetBalancesPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Balance>>> getBalances(@Body GraphQLRequest request);

}
