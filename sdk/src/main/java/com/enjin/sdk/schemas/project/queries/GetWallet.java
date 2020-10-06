package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for getting a player's wallet.
 *
 * @see com.enjin.sdk.models.Wallet
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class GetWallet extends GraphQLRequest<GetWallet> {

    /**
     * Sole constructor.
     */
    public GetWallet() {
        super("enjin.sdk.project.GetWallet");
    }

    /**
     * Sets the user ID owning the wallet to get.
     *
     * @param userId the user ID
     * @return this request for chaining
     */
    public GetWallet userId(String userId) {
        return set("userId", userId);
    }

    /**
     * Sets the Ethereum address of the wallet to get.
     *
     * @param ethAddress the address
     * @return this request for chaining
     */
    public GetWallet ethAddress(String ethAddress) {
        return set("ethAddress", ethAddress);
    }

}
