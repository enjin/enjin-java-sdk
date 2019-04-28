package com.enjin.enjincoin.sdk.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;
import com.enjin.enjincoin.sdk.http.HttpCallback;

/**
 * Asynchronous methods for querying and mutating users.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousUsersService {

    /**
     * Gets all users.
     *
     * @param callback the callback.
     */
    void getAllUsersAsync(HttpCallback<GraphQLResponse<GetUsersResult>> callback);

    /**
     * Gets users that match the query parameters.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void getUsersAsync(GetUsers query,
                       HttpCallback<GraphQLResponse<GetUsersResult>> callback);

    /**
     * Creates a new user.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void createUserAsync(CreateUser query,
                         HttpCallback<GraphQLResponse<CreateUserResult>> callback);

    /**
     * Authenticates a user and returns the users access tokens.
     *
     * @param query    the query.
     * @param callback the callback.
     */
    void loginUserAsync(LoginUser query,
                        HttpCallback<GraphQLResponse<LoginUserResult>> callback);

}
