package com.enjin.enjincoin.sdk.client.service.users;

import com.google.gson.JsonElement;
import retrofit2.Callback;

public interface AsynchronousUsersService {

    void createUserSync(String name, String email, String password, Callback<JsonElement> callback);

    void loginUserAsync(String name, String email, String password, Callback<JsonElement> callback);
}
