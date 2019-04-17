package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.Result;

import java.io.IOException;

public interface SynchronousEthereumService {

    Result<Integer> getAllowanceSync(String ethAddr) throws IOException;

}
