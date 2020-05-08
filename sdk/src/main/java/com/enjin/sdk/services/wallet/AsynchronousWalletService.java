package com.enjin.sdk.services.wallet;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.wallet.GetWallet;
import com.enjin.sdk.models.wallet.Wallet;

/**
 * Asynchronous methods for querying and mutating wallets.
 */
public interface AsynchronousWalletService {

    /**
     * Gets the wallet that matches the query parameters.
     *
     * @param query    the query
     * @param callback the callback
     */
    void getWalletAsync(GetWallet query,
                        HttpCallback<GraphQLResponse<Wallet>> callback);


}
