package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * A builder for logging in a user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class OAuthUser extends GraphQLRequest<OAuthUser> implements UserFragment<OAuthUser> {

    public OAuthUser appId(int id) {
        set("app_id", id);
        return this;
    }

    public OAuthUser name(String name) {
        set("name", name);
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
        set("email", email);
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
        set("password", password);
        return this;
    }

}
