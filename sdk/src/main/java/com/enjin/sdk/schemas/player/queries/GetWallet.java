package com.enjin.sdk.schemas.player.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for getting the player's wallet.
 *
 * @see com.enjin.sdk.models.Wallet
 * @see com.enjin.sdk.schemas.player.PlayerSchema
 */
public class GetWallet extends GraphQLRequest<GetWallet> {

    /**
     * Sole constructor.
     */
    public GetWallet() {
        super("enjin.sdk.player.GetWallet");
    }

}
