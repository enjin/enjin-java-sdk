package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * A builder for creating a new user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class CreateUser extends GraphQLRequest<CreateUser> implements UserFragment<CreateUser> {

    /**
     * The name of the user.
     *
     * @param name the name.
     *
     * @return the builder.
     */
    public CreateUser name(String name) {
        set("name", name);
        return this;
    }

}
