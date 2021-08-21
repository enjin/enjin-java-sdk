package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request to obtain an access token for a player.
 *
 * @see com.enjin.sdk.models.AccessToken
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class AuthPlayer extends GraphQLRequest<AuthPlayer> {

    /**
     * Sole constructor.
     */
    public AuthPlayer() {
        super("enjin.sdk.project.AuthPlayer");
    }

    /**
     * Sets the player ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public AuthPlayer id(String id) {
        return set("id", id);
    }

}
