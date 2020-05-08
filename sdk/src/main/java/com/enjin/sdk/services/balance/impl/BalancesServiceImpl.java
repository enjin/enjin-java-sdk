package com.enjin.sdk.services.balance.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.balance.Balance;
import com.enjin.sdk.models.balance.GetBalances;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.balance.BalancesService;

import retrofit2.Retrofit;

/**
 * Implementation class of {@link BalancesService}.
 *
 * @see BalancesService
 */
public class BalancesServiceImpl extends GraphQLServiceBase implements BalancesService {

    private final BalancesRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit the retrofit adapter
     */
    public BalancesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(BalancesRetrofitService.class);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query) {
        return execute(this.service.getBalances(query));
    }

    @Override
    public void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback) {
        enqueueGraphQLCall(this.service.getBalances(query), callback);
    }

}
