package com.enjin.sdk.model.service.users;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for creating a new user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class UpdateUser extends GraphQLRequest<UpdateUser> {

    public UpdateUser id(String id) {
        withParameter("id", id);
        return this;
    }

    /**
     * The name of the user.
     *
     * @param name the name.
     *
     * @return the builder.
     */
    public UpdateUser name(String name) {
        withParameter("name", name);
        return this;
    }

    /**
     * The email of the user.
     *
     * @param email the email.
     *
     * @return the builder.
     */
    public UpdateUser email(String email) {
        withParameter("email", email);
        return this;
    }

    /**
     * The password of the user.
     *
     * @param password the password.
     *
     * @return the builder.
     */
    public UpdateUser password(String password) {
        withParameter("password", password);
        return this;
    }

    public UpdateUser identityId(int identityId) {
        withParameter("identityId", identityId);
        return this;
    }

}
