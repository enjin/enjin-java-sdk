package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.Callback;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.UsersData;

public interface AsynchronousUsersService {

    /**
     * @param name
     * @param email
     * @param password
     * @param callback
     */
    void createUserAsync(String name,
                         String email,
                         String password,
                         Callback<GraphQLResponse<CreateUserData>> callback);

    /**
     * @param name
     * @param email
     * @param password
     * @param callback
     */
    void loginUserAsync(String name, String email, String password, Callback<GraphQLResponse<LoginUserData>> callback);

    /**
     * @param callback
     */
    void getAllUsersAsync(Callback<GraphQLResponse<UsersData>> callback);

    /**
     * @param userId
     * @param name
     * @param email
     * @param callback
     */
    void getUsersAsync(Integer userId, String name, String email, Callback<GraphQLResponse<UsersData>> callback);

}
