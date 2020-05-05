package com.enjin.sdk.models.user;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * An object class for getting users on the Trusted Platform.
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
     * @return this request.
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
     * @return this request.
     */
    public GetUser name(String name) {
        set("name", name);
        return this;
    }

    /**
     * Whether to only get the currently authenticated user.
     *
     * @return this request.
     */
    public GetUser me() {
        set("me", true);
        return this;
    }

}
