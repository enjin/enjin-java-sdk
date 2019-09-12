package com.enjin.sdk.service.balances;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.balances.Balance;
import com.enjin.sdk.model.service.balances.GetBalances;

public interface AsynchronousBalancesService {

    void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback);

}
