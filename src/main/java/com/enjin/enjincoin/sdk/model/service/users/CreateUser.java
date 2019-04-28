package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

/**
 * A builder for creating a new user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
public class CreateUser extends GraphQLRequest.Builder {

    /**
     * The name of the user.
     *
     * @param name the name.
     *
     * @return the builder.
     */
    public CreateUser withName(String name) {
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
    public CreateUser withEmail(String email) {
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
    public CreateUser withPassword(String password) {
        withParameter("password", password);
        return this;
    }

}
