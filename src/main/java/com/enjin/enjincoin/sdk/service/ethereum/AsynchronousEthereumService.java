package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.Callback;

public interface AsynchronousEthereumService {

    void getAllowanceAsync(String ethAddr, Callback<Integer> callback);

}
