package com.enjin.sdk.services.wallet;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.wallet.GetWallet;
import com.enjin.sdk.models.wallet.Wallet;

public interface AsynchronousWalletService {

    void getWalletAsync(GetWallet query,
                        HttpCallback<GraphQLResponse<Wallet>> callback);


}
