package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

/**
 * A builder for logging in a user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
public class LoginUser extends GraphQLRequest.Builder {

    /**
     * The email of the user.
     *
     * @param email the email.
     *
     * @return the builder.
     */
    public LoginUser withEmail(String email) {
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
    public LoginUser withPassword(String password) {
        withParameter("password", password);
        return this;
    }

}
