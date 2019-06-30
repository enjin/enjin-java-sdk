package com.enjin.enjincoin.sdk.service.balances;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.balances.Balance;
import com.enjin.enjincoin.sdk.model.service.balances.GetBalances;

import java.io.IOException;
import java.util.List;

public interface SynchronousBalancesService {

    HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query) throws IOException;

}
