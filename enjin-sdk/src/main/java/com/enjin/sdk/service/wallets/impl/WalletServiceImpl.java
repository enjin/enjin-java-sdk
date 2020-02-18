package com.enjin.sdk.service.wallets.impl;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.wallets.GetWallet;
import com.enjin.sdk.model.service.wallets.Wallet;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.wallets.WalletService;
import retrofit2.Retrofit;

import java.io.IOException;

public class WalletServiceImpl extends GraphQLServiceBase implements WalletService {

    private WalletRetrofitService service;

    public WalletServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(WalletRetrofitService.class);
    }

    @Override
    public void getWalletAsync(GetWallet query, HttpCallback<GraphQLResponse<Wallet>> callback) {
        enqueueGraphQLCall(this.service.getWallet(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<Wallet>> getWalletSync(GetWallet query) throws IOException {
        return executeGraphQLCall(this.service.getWallet(query));
    }

}
