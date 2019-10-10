package com.enjin.sdk.service.balances;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.balances.Balance;
import com.enjin.sdk.model.service.balances.GetBalances;

public interface SynchronousBalancesService {

    HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query) throws IOException;

}
