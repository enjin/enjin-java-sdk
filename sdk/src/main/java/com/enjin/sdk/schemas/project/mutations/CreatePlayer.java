package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for creating a player for the application.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class CreatePlayer extends GraphQLRequest<CreatePlayer> {

    /**
     * Sole constructor.
     */
    public CreatePlayer() {
        super("enjin.sdk.project.CreatePlayer");
    }

    /**
     * Sets the ID of the player.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public CreatePlayer id(String id) {
        return set("id", id);
    }

}
