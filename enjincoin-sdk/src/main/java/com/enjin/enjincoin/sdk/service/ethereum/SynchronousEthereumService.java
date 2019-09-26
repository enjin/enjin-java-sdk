package com.enjin.enjincoin.sdk.service.ethereum;

import java.io.IOException;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.ethereum.Block;

/**
 * Synchronous methods for querying the blockchain.
 *
 * @author Evan Lindsay
 */
public interface SynchronousEthereumService {

    HttpResponse<GraphQLResponse<Block>> getBlockSync() throws IOException;

}
