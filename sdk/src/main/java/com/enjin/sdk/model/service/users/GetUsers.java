package com.enjin.sdk.model.service.users;

import com.enjin.sdk.model.service.PaginationRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for getting users on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class GetUsers extends PaginationRequest<GetUsers> {

    /**
     * The id of the user.
     *
     * @param userId the user id.
     *
     * @return the builder.
     */
    public GetUsers userId(Integer userId) {
        withVariable("id", userId);
        return this;
    }

    /**
     * The name of the user.
     *
     * @param name the name.
     *
     * @return the builder.
     */
    public GetUsers name(String name) {
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
    public GetUsers email(String email) {
        withVariable("email", email);
        return this;
    }

}
