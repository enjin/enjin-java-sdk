package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for deleting a player from the project.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class DeletePlayer extends GraphQLRequest<DeletePlayer> {

    /**
     * Sole constructor.
     */
    public DeletePlayer() {
        super("enjin.sdk.project.DeletePlayer");
    }

    /**
     * Sets the ID for the player to be deleted.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public DeletePlayer id(String id) {
        return set("id", id);
    }

}
