package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;

public interface AsynchronousEthereumService {

    void getAllowanceAsync(String ethAddr, Callback<Integer> callback);

}
