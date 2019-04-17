package com.enjin.enjincoin.sdk.service.ethereum.impl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EthereumRetrofitService {

    @GET("api/v1/ethereum/{eth_addr}/allowance")
    Call<Integer> getAllowance(@Path("eth_addr") String ethAddr);

}
