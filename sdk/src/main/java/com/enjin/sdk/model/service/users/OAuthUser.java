package com.enjin.sdk.model.service.users;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for logging in a user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class OAuthUser extends GraphQLRequest<OAuthUser> {

    public OAuthUser appId(int id) {
        withVariable("app_id", id);
        return this;
    }

    public OAuthUser name(String name) {
        withVariable("name", name);
        return this;
    }

    /**
     * The email of the user.
     *
     * @param email the email.
     *
     * @return the builder.
     */
    public OAuthUser email(String email) {
        withVariable("email", email);
        return this;
    }

    /**
     * The password of the user.
     *
     * @param password the password.
     *
     * @return the builder.
     */
    public OAuthUser password(String password) {
        withVariable("password", password);
        return this;
    }

}
