package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * An object class for getting a player's access token from the Trusted Platform.
 *
 * @see UsersService
 */
public class AuthPlayer extends GraphQLRequest<AuthPlayer> {

    /**
     * The external id for the player.
     *
     * @param id the external id for the player
     * @return   this request
     */
    public AuthPlayer id(String id) {
        set("id", id);
        return this;
    }

}
