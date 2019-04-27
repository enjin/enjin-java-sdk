package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.HttpCallback;

import java.math.BigInteger;

public interface AsynchronousEthereumService {

    void getAllowanceAsync(String ethAddr, HttpCallback<BigInteger> callback);

}
