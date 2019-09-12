package com.enjin.sdk.model.service.users;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for logging in a user on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class AuthUser extends GraphQLRequest<AuthUser> {

    public AuthUser appId(int id) {
        withParameter("app_id", id);
        return this;
    }

    public AuthUser name(String name) {
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
    public AuthUser email(String email) {
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
    public AuthUser password(String password) {
        withParameter("password", password);
        return this;
    }

    public AuthUser walletSignature(String signature) {
        withParameter("wallet_signature", signature);
        return this;
    }

    public AuthUser walletSignatureTransaction(String transaction) {
        withParameter("wallet_signature_tx", transaction);
        return this;
    }

}
