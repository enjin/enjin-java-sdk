package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.Response;

import java.io.IOException;

public interface SynchronousEthereumService {

    Response<Integer> getAllowanceSync(String ethAddr) throws IOException;

}
