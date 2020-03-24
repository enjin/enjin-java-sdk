package com.enjin.sdk.services.balance;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.balance.GetBalances;

public interface AsynchronousBalancesService {

    void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback);

}
