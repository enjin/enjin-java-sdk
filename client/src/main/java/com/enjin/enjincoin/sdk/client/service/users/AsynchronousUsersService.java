package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.service.users.vo.*;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.LoginUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UpdateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UserResponseBody;
import retrofit2.Callback;

public interface AsynchronousUsersService {

    void getUsersAsync(Callback<UserResponseBody[]> callback);

    void getUserAsync(long userId, Callback<UserResponseBody> callback);

    void createUserAsync(CreateUserRequestBody createUserRequestVO, Callback<CreateUserResponseBody> callback);

    void updateUserAsync(long userId, UpdateUserRequestBody updateUserRequest, Callback<UserResponseBody> callback);

    void loginUserAsync(String email, String password, long appId, Callback<LoginUserResponseBody> callback);
}
