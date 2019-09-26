package com.enjin.enjincoin.sdk.service.balances.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.balances.Balance;
import com.enjin.enjincoin.sdk.model.service.balances.GetBalances;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.balances.BalancesService;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BalancesServiceImpl extends GraphQLServiceBase implements BalancesService {

    private final BalancesRetrofitService service;

    public BalancesServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(BalancesRetrofitService.class);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query) throws IOException {
        return execute(getBalancesCall(query));
    }

    @Override
    public void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback) {
        enqueueGraphQLCall(getBalancesCall(query), callback);
    }

    private Call<GraphQLResponse<List<Balance>>> getBalancesCall(GetBalances query) {
        return this.service.getBalances(query);
    }

}
