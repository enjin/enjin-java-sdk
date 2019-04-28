package com.enjin.enjincoin.sdk.service.ethereum.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Retrofit;

import java.io.IOException;
import java.math.BigInteger;

public class EthereumServiceImpl extends ServiceBase implements EthereumService {

    private final EthereumRetrofitService service;

    public EthereumServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(EthereumRetrofitService.class);
    }

    @Override
    public void getAllowanceAsync(String ethAddr, HttpCallback<BigInteger> callback) {
        enqueue(this.service.getAllowance(ethAddr), callback);
    }

    @Override
    public HttpResponse<BigInteger> getAllowanceSync(String ethAddr) throws IOException {
        return execute(this.service.getAllowance(ethAddr));
    }

}
