package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.Callback;

import java.math.BigInteger;

public interface AsynchronousEthereumService {

    void getAllowanceAsync(String ethAddr, Callback<BigInteger> callback);

}
