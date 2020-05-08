package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * An object class for creating a new user on the Trusted Platform.
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
     * @return this request.
     */
    public CreateUser name(String name) {
        set("name", name);
        return this;
    }

}
