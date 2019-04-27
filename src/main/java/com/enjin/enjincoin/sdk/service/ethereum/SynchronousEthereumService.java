package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.HttpResponse;

import java.io.IOException;
import java.math.BigInteger;

public interface SynchronousEthereumService {

    HttpResponse<BigInteger> getAllowanceSync(String ethAddr) throws IOException;

}
