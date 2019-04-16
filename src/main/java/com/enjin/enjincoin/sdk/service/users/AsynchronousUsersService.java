package com.enjin.enjincoin.sdk.service.users;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateUser;
import com.enjin.enjincoin.sdk.model.query.GetUsers;
import com.enjin.enjincoin.sdk.model.query.LoginUser;
import com.enjin.enjincoin.sdk.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.UsersData;

public interface AsynchronousUsersService {

    /**
     * @param query
     * @param callback
     */
    void createUserAsync(CreateUser query,
                         Callback<GraphQLResponse<CreateUserData>> callback);

    /**
     * @param query
     * @param callback
     */
    void loginUserAsync(LoginUser query,
                        Callback<GraphQLResponse<LoginUserData>> callback);

    /**
     * @param callback
     */
    void getAllUsersAsync(Callback<GraphQLResponse<UsersData>> callback);

    /**
     * @param query
     * @param callback
     */
    void getUsersAsync(GetUsers query,
                       Callback<GraphQLResponse<UsersData>> callback);

}
