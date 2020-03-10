package com.enjin.sdk.service.wallets;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.wallets.GetWallet;
import com.enjin.sdk.model.service.wallets.Wallet;

import java.util.List;

public interface AsynchronousWalletService {

    void getWalletAsync(GetWallet query,
                        HttpCallback<GraphQLResponse<Wallet>> callback);


}
