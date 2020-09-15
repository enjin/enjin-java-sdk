package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.PlayerFragmentArguments;

/**
 * Request for getting a player on the application.
 *
 * @see com.enjin.sdk.models.Player
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class GetPlayer
        extends GraphQLRequest<GetPlayer>
        implements PlayerFragmentArguments<GetPlayer> {

    /**
     * Sole constructor.
     */
    public GetPlayer() {
        super("enjin.sdk.project.GetPlayer");
    }

    /**
     * Sets the player ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetPlayer id(String id) {
        return set("id", id);
    }

}
