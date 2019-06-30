package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

/**
 * A builder for creating a new user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
public class DeleteUser extends GraphQLRequest<DeleteUser> {

    public DeleteUser id(String id) {
        withParameter("id", id);
        return this;
    }

}
