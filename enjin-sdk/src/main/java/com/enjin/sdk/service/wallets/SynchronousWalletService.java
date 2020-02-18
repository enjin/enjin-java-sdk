package com.enjin.sdk.service.wallets;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.wallets.GetWallet;
import com.enjin.sdk.model.service.wallets.Wallet;

import java.io.IOException;

public interface SynchronousWalletService {

    HttpResponse<GraphQLResponse<Wallet>> getWalletSync(GetWallet query) throws IOException;

}
