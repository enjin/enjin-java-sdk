package com.enjin.sdk.services.user;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.user.AuthPlayer;
import com.enjin.sdk.models.user.OAuthUser;
import com.enjin.sdk.models.user.CreateUser;
import com.enjin.sdk.models.user.GetUser;
import com.enjin.sdk.models.user.GetUsers;
import com.enjin.sdk.models.user.User;

/**
 * Synchronous methods for querying and mutating users.
 */
public interface SynchronousUsersService {

    /**
     * Gets users that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<List<User>>> getUsersSync(GetUsers query);

    /**
     * Gets a user that matches the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<User>> getUserSync(GetUser query);

    /**
     * Creates a new user.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<User>> createUserSync(CreateUser query);

    /**
     * Authenticates a user and returns the users access tokens.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<User>> oAuthUserSync(OAuthUser query);

    /**
     * Gets the access tokens of the player that matches the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     */
    HttpResponse<GraphQLResponse<AccessToken>> authUserSync(AuthPlayer query);

}
