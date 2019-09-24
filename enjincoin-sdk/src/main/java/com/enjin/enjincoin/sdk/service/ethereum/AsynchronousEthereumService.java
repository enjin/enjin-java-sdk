package com.enjin.enjincoin.sdk.service.ethereum;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.model.service.ethereum.Block;

/**
 * Asynchronous methods for querying the blockchain.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousEthereumService {

    void getBlockAsync(HttpCallback<GraphQLResponse<Block>> callback);

}
