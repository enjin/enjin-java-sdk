package com.enjin.sdk.service.balances.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SchemaProvider;
import com.enjin.sdk.model.service.balances.Balance;
import com.enjin.sdk.model.service.balances.GetBalances;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.balances.BalancesService;

import retrofit2.Call;
import retrofit2.Retrofit;

public class BalancesServiceImpl extends GraphQLServiceBase implements BalancesService {

    private final BalancesRetrofitService service;
    private final SchemaProvider schemaProvider;

    public BalancesServiceImpl(Retrofit retrofit, SchemaProvider schemaProvider) {
        this.service = retrofit.create(BalancesRetrofitService.class);
        this.schemaProvider = schemaProvider;
    }

    @Override
    public HttpResponse<GraphQLResponse<List<Balance>>> getBalancesSync(GetBalances query) throws IOException {
        return execute(this.service.getBalances(schemaProvider.get(), query));
    }

    @Override
    public void getBalancesAsync(GetBalances query, HttpCallback<GraphQLResponse<List<Balance>>> callback) {
        enqueueGraphQLCall(this.service.getBalances(schemaProvider.get(), query), callback);
    }

}
