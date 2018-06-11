package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import retrofit2.Callback;

public interface AsynchronousUsersService {

    void createUserAsync(String name, String email, String password, Callback<GraphQLResponse> callback);

    void loginUserAsync(String name, String email, String password, Callback<GraphQLResponse> callback);

    void getAllUsersAsync(Callback<GraphQLResponse> callback);

    void getUsersAsync(Integer id, String name, String email, Callback<GraphQLResponse> callback);

}
