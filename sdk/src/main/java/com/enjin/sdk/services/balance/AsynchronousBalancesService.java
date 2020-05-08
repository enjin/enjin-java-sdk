package com.enjin.sdk.services.balance;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.balance.GetBalances;

/**
 * Asynchronous methods for querying and mutating balances.
 */
public interface AsynchronousBalancesService {

    /**
     * Gets the balances that match the query parameters.
     *
     * @param query    the query
     * @param callback the callback
     */
    void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback);

}
