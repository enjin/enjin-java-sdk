package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.http.HttpCallback;

import java.math.BigInteger;

/**
 * Asynchronous methods for querying the blockchain.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousEthereumService {

    /**
     * Gets the allowance of an ethereum address.
     *
     * @param ethAddr  the ethereum address.
     * @param callback the callback.
     */
    void getAllowanceAsync(String ethAddr, HttpCallback<BigInteger> callback);

}
