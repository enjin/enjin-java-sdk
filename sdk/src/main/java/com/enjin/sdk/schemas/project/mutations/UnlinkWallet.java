package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for unlinking a wallet from the project.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class UnlinkWallet extends GraphQLRequest<UnlinkWallet> {

    /**
     * Sole constructor.
     */
    public UnlinkWallet() {
        super("enjin.sdk.project.UnlinkWallet");
    }

    /**
     * Sets the Ethereum address of the wallet to unlink.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    public UnlinkWallet ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
