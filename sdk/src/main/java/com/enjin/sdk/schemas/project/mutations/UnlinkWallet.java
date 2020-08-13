package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * TODO
 */
public class UnlinkWallet extends GraphQLRequest<UnlinkWallet> {

    /**
     * TODO
     */
    public UnlinkWallet() {
        super("enjin.sdk.project.UnlinkWallet");
    }

    /**
     * TODO
     * @param ethAddress
     * @return
     */
    public UnlinkWallet ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
