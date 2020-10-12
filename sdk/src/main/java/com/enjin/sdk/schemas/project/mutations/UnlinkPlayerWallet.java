package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for unlinking a wallet from the application.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class UnlinkPlayerWallet extends GraphQLRequest<UnlinkPlayerWallet> {

    /**
     * Sole constructor.
     */
    public UnlinkPlayerWallet() {
        super("enjin.sdk.project.UnlinkPlayerWallet");
    }

    /**
     * Sets the Ethereum address of the wallet to unlink.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    public UnlinkPlayerWallet ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
