package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.HttpResponse;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Synchronous methods for querying the blockchain.
 *
 * @author Evan Lindsay
 */
public interface SynchronousEthereumService {

    /**
     * Gets the allowance of an ethereum address.
     *
     * @param ethAddr the ethereum address.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<BigInteger> getAllowanceSync(String ethAddr) throws IOException;

}
