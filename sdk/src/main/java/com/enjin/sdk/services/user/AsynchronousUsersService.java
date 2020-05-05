package com.enjin.sdk.services.user;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.user.AuthPlayer;
import com.enjin.sdk.models.user.OAuthUser;
import com.enjin.sdk.models.user.CreateUser;
import com.enjin.sdk.models.user.GetUser;
import com.enjin.sdk.models.user.GetUsers;
import com.enjin.sdk.models.user.User;

/**
 * Asynchronous methods for querying and mutating users.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousUsersService {

    /**
     * Gets users that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getUsersAsync(GetUsers query,
                       HttpCallback<GraphQLResponse<List<User>>> callback);

    /**
     * Gets a user that matches the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getUserAsync(GetUser query,
                      HttpCallback<GraphQLResponse<User>> callback);

    /**
     * Creates a new user.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void createUserAsync(CreateUser query,
                         HttpCallback<GraphQLResponse<User>> callback);

    /**
     * Authenticates a user and returns the users access tokens.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void oAuthUserAsync(OAuthUser query,
                        HttpCallback<GraphQLResponse<User>> callback);

    /**
     * Gets the access tokens of the player that matches the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void authUserAsync(AuthPlayer query,
                       HttpCallback<GraphQLResponse<AccessToken>> callback);

}
