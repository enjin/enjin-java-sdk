package com.enjin.enjincoin.sdk.client.service.users;

import com.google.gson.JsonElement;
import retrofit2.Callback;

public interface AsynchronousUsersService {

    void createUserAsync(String name, String email, String password, Callback<JsonElement> callback);

    void loginUserAsync(String name, String email, String password, Callback<JsonElement> callback);

    void getAllUsersAsync(Callback<JsonElement> callback);

    void getUsersAsync(Integer id, String name, String email, Callback<JsonElement> callback);

}
