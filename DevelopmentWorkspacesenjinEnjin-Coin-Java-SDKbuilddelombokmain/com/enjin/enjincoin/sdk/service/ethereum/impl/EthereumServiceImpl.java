package com.enjin.enjincoin.sdk.service.ethereum.impl;

import com.enjin.enjincoin.sdk.http.Result;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
import com.enjin.enjincoin.sdk.http.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class EthereumServiceImpl extends ServiceBase implements EthereumService {

    private EthereumRetrofitService service;

    public EthereumServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(EthereumRetrofitService.class);
    }

    @Override
    public void getAllowanceAsync(String ethAddr, Callback<Integer> callback) {
        enqueue(this.service.getAllowance(ethAddr), callback);
    }

    @Override
    public Result<Integer> getAllowanceSync(String ethAddr) throws IOException {
        return execute(this.service.getAllowance(ethAddr));
    }

}
