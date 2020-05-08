package com.enjin.sdk.models.wallet;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.wallet.WalletService;

/**
 * An object class for getting a wallet from the Trusted Platform.
 *
 * @see WalletService
 */
public class GetWallet extends GraphQLRequest<GetWallet> implements WalletFragment<GetWallet> {

    /**
     * The wallet's Ethereum address.
     *
     * @param ethAddress the Ethereum address
     * @return           this request
     */
    public GetWallet ethAddress(String ethAddress) {
        set("ethAddr", ethAddress);
        return this;
    }

}
