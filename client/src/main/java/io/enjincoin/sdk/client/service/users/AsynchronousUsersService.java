package io.enjincoin.sdk.client.service.users;

import io.enjincoin.sdk.client.service.users.vo.CreateUserRequestBody;
import io.enjincoin.sdk.client.service.users.vo.CreateUserResponseBody;
import io.enjincoin.sdk.client.service.users.vo.LoginUserResponseBody;
import io.enjincoin.sdk.client.service.users.vo.UpdateUserRequestBody;
import io.enjincoin.sdk.client.service.users.vo.UserResponseBody;
import retrofit2.Callback;

public interface AsynchronousUsersService {

    void getUsersAsync(Callback<UserResponseBody[]> callback);

    void getUserAsync(long userId, Callback<UserResponseBody> callback);

    void createUserAsync(CreateUserRequestBody createUserRequestVO, Callback<CreateUserResponseBody> callback);

    void updateUserAsync(long userId, UpdateUserRequestBody updateUserRequest, Callback<UserResponseBody> callback);

    void loginUserAsync(String email, String password, long appId, Callback<LoginUserResponseBody> callback);
}
