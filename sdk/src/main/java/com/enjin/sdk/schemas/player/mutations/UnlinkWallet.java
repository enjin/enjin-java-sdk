package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for unlinking a wallet from the player.
 *
 * @see com.enjin.sdk.schemas.player.PlayerSchema
 */
public class UnlinkWallet extends GraphQLRequest<UnlinkWallet> {

    /**
     * Sole constructor.
     */
    public UnlinkWallet() {
        super("enjin.sdk.player.UnlinkWallet");
    }

}
