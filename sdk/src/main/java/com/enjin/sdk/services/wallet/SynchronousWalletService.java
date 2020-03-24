package com.enjin.sdk.services.wallet;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.wallet.GetWallet;
import com.enjin.sdk.models.wallet.Wallet;

public interface SynchronousWalletService {

    HttpResponse<GraphQLResponse<Wallet>> getWalletSync(GetWallet query);

}
