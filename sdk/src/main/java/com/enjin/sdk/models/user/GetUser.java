package com.enjin.sdk.models.user;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * A builder for getting users on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class GetUser extends PaginationRequest<GetUser> implements UserFragment<GetUser> {

    /**
     * The id of the user.
     *
     * @param userId the user id.
     *
     * @return the builder.
     */
    public GetUser userId(Integer userId) {
        set("id", userId);
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
        set("name", name);
        return this;
    }

    /**
     * Whether to only get the currently authenticated user.
     *
     * @return the builder.
     */
    public GetUser me() {
        set("me", true);
        return this;
    }

}
