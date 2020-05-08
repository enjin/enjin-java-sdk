package com.enjin.sdk.models.user;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * An object class for logging in a user on the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class OAuthUser extends GraphQLRequest<OAuthUser> implements UserFragment<OAuthUser> {

    /**
     * The application id.
     *
     * @param id the app id.
     * @return   this request.
     */
    public OAuthUser appId(int id) {
        set("app_id", id);
        return this;
    }

    /**
     * The name of the user.
     *
     * @param name the name.
     * @return     this request.
     */
    public OAuthUser name(String name) {
        set("name", name);
        return this;
    }

    /**
     * The email of the user.
     *
     * @param email the email.
     * @return      this request.
     */
    public OAuthUser email(String email) {
        set("email", email);
        return this;
    }

    /**
     * The password of the user.
     *
     * @param password the password.
     * @return         this request.
     */
    public OAuthUser password(String password) {
        set("password", password);
        return this;
    }

}
