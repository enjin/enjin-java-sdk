package com.enjin.enjincoin.sdk.service.users;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;
import com.enjin.enjincoin.sdk.model.service.users.User;

import java.io.IOException;
import java.util.List;

public interface SynchronousUsersService {

    /**
     * Gets all users.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetUsersResult>> getAllUsersSync() throws IOException;

    /**
     * Gets users that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<GetUsersResult>> getUsersSync(GetUsers query) throws IOException;

    /**
     * Creates a new user.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<CreateUserResult>> createUserSync(CreateUser query) throws IOException;

    /**
     * Authenticates a user and returns the users access tokens.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<LoginUserResult>> loginUserSync(LoginUser query) throws IOException;

    HttpResponse<GraphQLResponse<List<User>>> getUsers2Sync(GetUsers query) throws IOException;

}
