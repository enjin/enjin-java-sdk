package com.enjin.enjincoin.sdk.service.ethereum.impl;

import java.io.IOException;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.ethereum.Block;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;

import retrofit2.Retrofit;

public class EthereumServiceImpl extends GraphQLServiceBase implements EthereumService {

    private final EthereumRetrofitService service;
    private final GraphQLRequest emptyRequest = new GraphQLRequest();

    public EthereumServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(EthereumRetrofitService.class);
    }

    @Override
    public void getBlockAsync(HttpCallback<GraphQLResponse<Block>> callback) {
        enqueueGraphQLCall(this.service.getBlock(emptyRequest), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<Block>> getBlockSync() throws IOException {
        return execute(this.service.getBlock(emptyRequest));
    }

}
