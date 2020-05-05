package com.enjin.sdk.services.balance;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.balance.GetBalances;

/**
 * Synchronous methods for querying and mutating balances.
 */
public interface SynchronousBalancesService {

    /**
     * Gets the balances that match the query parameters.
     *
     * @param query the query
     * @return      the response
     */
    HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query);

}
