package com.enjin.sdk.model.service.users;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for creating a new user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class CreateUser extends GraphQLRequest<CreateUser> {

    /**
     * The name of the user.
     *
     * @param name the name.
     *
     * @return the builder.
     */
    public CreateUser name(String name) {
        withParameter("name", name);
        return this;
    }

}
