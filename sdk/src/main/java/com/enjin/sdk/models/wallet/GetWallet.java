package com.enjin.sdk.models.wallet;

import com.enjin.sdk.graphql.GraphQLRequest;

public class GetWallet extends GraphQLRequest<GetWallet> implements WalletFragment<GetWallet> {

    public GetWallet ethAddress(String ethAddress) {
        set("ethAddr", ethAddress);
        return this;
    }

}
