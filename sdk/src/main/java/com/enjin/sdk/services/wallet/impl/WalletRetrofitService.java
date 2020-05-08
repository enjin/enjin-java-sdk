package com.enjin.sdk.services.wallet.impl;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.wallet.GetWallet;
import com.enjin.sdk.models.wallet.Wallet;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface WalletRetrofitService {

    /**
     * Gets the wallet.
     *
     * @see GetWallet
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetWallet")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Wallet>> getWallet(@Body GraphQLRequest request);

}
