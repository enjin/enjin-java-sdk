package com.enjin.sdk.model.service.users;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for creating a new user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class DeleteUser extends GraphQLRequest<DeleteUser> {

    public DeleteUser id(String id) {
        withParameter("id", id);
        return this;
    }

}
