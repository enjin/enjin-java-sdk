package com.enjin.sdk.services.balance;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.balance.GetBalances;

public interface SynchronousBalancesService {

    HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query);

}
