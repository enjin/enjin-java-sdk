package com.enjin.sdk.service.users;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.model.service.auth.AuthTokens;
import com.enjin.sdk.model.service.auth.AuthUser;
import com.enjin.sdk.model.service.users.OAuthUser;
import com.enjin.sdk.model.service.users.CreateUser;
import com.enjin.sdk.model.service.users.GetUser;
import com.enjin.sdk.model.service.users.GetUsers;
import com.enjin.sdk.model.service.users.User;

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

    void authUserAsync(AuthUser query,
                       HttpCallback<GraphQLResponse<AuthTokens>> callback);

}
