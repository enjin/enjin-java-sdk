package com.enjin.enjincoin.sdk.service.ethereum.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
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
        this.service.getAllowance(ethAddr).enqueue(new retrofit2.Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, retrofit2.Response<Integer> response) {
                callback.onComplete(new Response<>(response.code(), response.body()));
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
    }

    @Override
    public Response<Integer> getAllowanceSync(String ethAddr) throws IOException {
        retrofit2.Response<Integer> response = this.service.getAllowance(ethAddr).execute();

        return new Response<>(response.code(), response.body());
    }

}
