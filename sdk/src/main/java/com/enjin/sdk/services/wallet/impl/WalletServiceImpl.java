package com.enjin.sdk.services.wallet.impl;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.wallet.GetWallet;
import com.enjin.sdk.models.wallet.Wallet;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.wallet.WalletService;
import retrofit2.Retrofit;

/**
 * Implementation class of {@link WalletService}.
 *
 * @see WalletService
 */
public class WalletServiceImpl extends GraphQLServiceBase implements WalletService {

    private WalletRetrofitService service;

    /**
     * Sole constructor.
     *
     * @param retrofit the retrofit adapter
     */
    public WalletServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(WalletRetrofitService.class);
    }

    @Override
    public void getWalletAsync(GetWallet query, HttpCallback<GraphQLResponse<Wallet>> callback) {
        enqueueGraphQLCall(this.service.getWallet(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<Wallet>> getWalletSync(GetWallet query) {
        return executeGraphQLCall(this.service.getWallet(query));
    }

}
