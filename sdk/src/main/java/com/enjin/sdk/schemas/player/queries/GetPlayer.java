package com.enjin.sdk.schemas.player.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * TODO
 */
public class GetPlayer
        extends GraphQLRequest<GetPlayer>
        implements PlayerFragmentArguments<GetPlayer> {

    /**
     * TODO
     */
    public GetPlayer() {
        super("enjin.sdk.player.GetPlayer");
    }

}
