package com.enjin.sdk.services.wallet;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.wallet.GetWallet;
import com.enjin.sdk.models.wallet.Wallet;

/**
 * Synchronous methods for querying and mutating wallets.
 */
public interface SynchronousWalletService {

    /**
     * Gets the wallet that matches the query parameters.
     *
     * @param query the query
     * @return      the callback
     */
    HttpResponse<GraphQLResponse<Wallet>> getWalletSync(GetWallet query);

}
