package com.enjin.sdk.service.ethereum;

import java.io.IOException;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.ethereum.Block;

/**
 * Synchronous methods for querying the blockchain.
 *
 * @author Evan Lindsay
 */
public interface SynchronousEthereumService {

    HttpResponse<GraphQLResponse<Block>> getBlockSync() throws IOException;

}
