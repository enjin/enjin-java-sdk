package com.enjin.sdk.model.service.users;

import com.enjin.sdk.model.service.PaginationRequest;
import com.enjin.sdk.service.users.UsersService;

/**
 * A builder for getting users on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class GetUser extends PaginationRequest<GetUser> {

    /**
     * The id of the user.
     *
     * @param userId the user id.
     *
     * @return the builder.
     */
    public GetUser userId(Integer userId) {
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
    public GetUser name(String name) {
        withVariable("name", name);
        return this;
    }

    /**
     * Whether to only get the currently authenticated user.
     *
     * @return the builder.
     */
    public GetUser me() {
        withVariable("me", true);
        return this;
    }

}
