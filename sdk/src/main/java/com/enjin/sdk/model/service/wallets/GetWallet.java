package com.enjin.sdk.model.service.wallets;

import com.enjin.sdk.graphql.GraphQLRequest;

public class GetWallet extends GraphQLRequest<GetWallet> {

    public GetWallet ethaddress(String ethAddress) {
        withVariable("ethAddress", ethAddress);
        return this;
    }

}
