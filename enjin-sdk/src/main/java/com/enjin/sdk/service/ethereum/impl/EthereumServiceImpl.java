package com.enjin.sdk.service.ethereum.impl;

import java.io.IOException;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SchemaProvider;
import com.enjin.sdk.model.service.ethereum.Block;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.ethereum.EthereumService;

import retrofit2.Retrofit;

public class EthereumServiceImpl extends GraphQLServiceBase implements EthereumService {

    private final EthereumRetrofitService service;
    private final SchemaProvider schemaProvider;
    private final GraphQLRequest emptyRequest = new GraphQLRequest();

    public EthereumServiceImpl(Retrofit retrofit, SchemaProvider schemaProvider) {
        this.service = retrofit.create(EthereumRetrofitService.class);
        this.schemaProvider = schemaProvider;
    }

    @Override
    public void getBlockAsync(HttpCallback<GraphQLResponse<Block>> callback) {
        enqueueGraphQLCall(this.service.getBlock(schemaProvider.get(), emptyRequest), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<Block>> getBlockSync() throws IOException {
        return execute(this.service.getBlock(schemaProvider.get(), emptyRequest));
    }

}
