package com.enjin.sdk.schemas.player.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * Request for getting information about the player.
 *
 * @see com.enjin.sdk.models.Player
 * @see com.enjin.sdk.schemas.player.PlayerSchema
 */
public class GetPlayer
        extends GraphQLRequest<GetPlayer>
        implements PlayerFragmentArguments<GetPlayer> {

    /**
     * Sole constructor.
     */
    public GetPlayer() {
        super("enjin.sdk.player.GetPlayer");
    }

}
