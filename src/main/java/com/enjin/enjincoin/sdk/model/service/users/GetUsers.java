package com.enjin.enjincoin.sdk.model.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.model.service.PaginationInput;

import java.math.BigInteger;

/**
 * A builder for getting users on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.users.UsersService
 */
public class GetUsers extends GraphQLRequest.Builder {

    /**
     * The id of the user.
     *
     * @param userId the user id.
     *
     * @return the builder.
     */
    public GetUsers withUserId(BigInteger userId) {
        withParameter("id", userId);
        return this;
    }

    /**
     * The name of the user.
     *
     * @param name the name.
     *
     * @return the builder.
     */
    public GetUsers withName(String name) {
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
    public GetUsers withEmail(String email) {
        withParameter("email", email);
        return this;
    }

    /**
     * Whether to only get the currently authenticated user.
     *
     * @param me should only get current user?
     *
     * @return the builder.
     */
    public GetUsers withMe(boolean me) {
        withParameter("me", me);
        return this;
    }

    /**
     * Whether the request should be paginated.
     *
     * @param pagination the pagination input.
     *
     * @return the builder.
     */
    public GetUsers withPagination(PaginationInput pagination) {
        withParameter("pagination", pagination);
        return this;
    }

}
