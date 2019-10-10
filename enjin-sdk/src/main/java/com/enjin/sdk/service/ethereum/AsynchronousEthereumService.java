package com.enjin.sdk.service.ethereum;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.ethereum.Block;

/**
 * Asynchronous methods for querying the blockchain.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousEthereumService {

    void getBlockAsync(HttpCallback<GraphQLResponse<Block>> callback);

}
