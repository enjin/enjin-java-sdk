package com.enjin.enjincoin.sdk.service.ethereum.impl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.math.BigInteger;

public interface EthereumRetrofitService {

    @GET("api/v1/ethereum/{eth_addr}/allowance")
    Call<BigInteger> getAllowance(@Path("eth_addr") String ethAddr);

}
