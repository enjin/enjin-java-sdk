package com.enjin.enjincoin.sdk.service.ethereum.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.ethereum.Block;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Retrofit;

import java.io.IOException;
import java.math.BigInteger;

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
