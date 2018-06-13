package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.UsersData;
import retrofit2.Callback;

public interface AsynchronousUsersService {

    void createUserAsync(String name, String email, String password, Callback<GraphQLResponse<CreateUserData>> callback);

    void loginUserAsync(String name, String email, String password, Callback<GraphQLResponse<LoginUserData>> callback);

    void getAllUsersAsync(Callback<GraphQLResponse<UsersData>> callback);

    void getUsersAsync(Integer id, String name, String email, Callback<GraphQLResponse<UsersData>> callback);

}
