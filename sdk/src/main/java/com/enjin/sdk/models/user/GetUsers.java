package com.enjin.sdk.models.user;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.services.user.UsersService;

/**
 * An object class for getting users on the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see UsersService
 */
public class GetUsers extends PaginationRequest<GetUsers> implements UserFragment<GetUsers> {

    /**
     * The id of the user.
     *
     * @param userId the user id.
     *
     * @return this request.
     */
    public GetUsers userId(Integer userId) {
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
    public GetUsers name(String name) {
        set("name", name);
        return this;
    }

    /**
     * The email of the user.
     *
     * @param email the email.
     *
     * @return this request.
     */
    public GetUsers email(String email) {
        set("email", email);
        return this;
    }

}
