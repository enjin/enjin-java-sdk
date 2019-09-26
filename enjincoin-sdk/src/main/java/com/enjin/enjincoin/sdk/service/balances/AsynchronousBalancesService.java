package com.enjin.enjincoin.sdk.service.balances;

import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.model.service.balances.Balance;
import com.enjin.enjincoin.sdk.model.service.balances.GetBalances;

public interface AsynchronousBalancesService {

    void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback);

}
