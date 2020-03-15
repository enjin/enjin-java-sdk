package com.enjin.sdk.service.balances.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.balances.Balance;
import com.enjin.sdk.model.service.balances.GetBalances;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.balances.BalancesService;

import retrofit2.Retrofit;

public class BalancesServiceImpl extends GraphQLServiceBase implements BalancesService {

    private final BalancesRetrofitService service;

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
