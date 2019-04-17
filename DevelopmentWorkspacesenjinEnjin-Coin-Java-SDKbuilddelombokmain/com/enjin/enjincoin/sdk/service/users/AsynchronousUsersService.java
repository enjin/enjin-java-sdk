package com.enjin.enjincoin.sdk.service.users;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;
import com.enjin.enjincoin.sdk.http.Callback;

public interface AsynchronousUsersService {

    /**
     * @param query
     * @param callback
     */
    void createUserAsync(CreateUser query,
                         Callback<GraphQLResponse<CreateUserResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void loginUserAsync(LoginUser query,
                        Callback<GraphQLResponse<LoginUserResult>> callback);

    /**
     * @param callback
     */
    void getAllUsersAsync(Callback<GraphQLResponse<GetUsersResult>> callback);

    /**
     * @param query
     * @param callback
     */
    void getUsersAsync(GetUsers query,
                       Callback<GraphQLResponse<GetUsersResult>> callback);

}
