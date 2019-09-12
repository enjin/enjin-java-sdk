package com.enjin.sdk.service.users;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.users.AuthUser;
import com.enjin.sdk.model.service.users.CreateUser;
import com.enjin.sdk.model.service.users.DeleteUser;
import com.enjin.sdk.model.service.users.GetUsers;
import com.enjin.sdk.model.service.users.UpdateUser;
import com.enjin.sdk.model.service.users.User;

public interface SynchronousUsersService {

    /**
     * Gets users that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<List<User>>> getUsersSync(GetUsers query) throws IOException;

    /**
     * Creates a new user.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<User>> createUserSync(CreateUser query) throws IOException;

    HttpResponse<GraphQLResponse<User>> updateUserSync(UpdateUser query) throws IOException;

    HttpResponse<GraphQLResponse<User>> deleteUserSync(DeleteUser query) throws IOException;

    /**
     * Authenticates a user and returns the users access tokens.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<User>> authUserSync(AuthUser query) throws IOException;

}
