package com.enjin.enjincoin.sdk.client.service.users;

import java.io.IOException;

import com.enjin.enjincoin.sdk.client.service.users.vo.*;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.LoginUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UpdateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UserResponseBody;
import retrofit2.Response;

public interface SynchronousUsersService {

    Response<UserResponseBody[]> getUsersSync() throws IOException;

    Response<UserResponseBody> getUserSync(long userId) throws IOException;

    Response<CreateUserResponseBody> createUserSync(CreateUserRequestBody createUserRequestVO) throws IOException;

    Response<UserResponseBody> updateUserSync(long userId, UpdateUserRequestBody updateUserRequest) throws IOException;

    Response<LoginUserResponseBody> loginUserSync(String email, String password, long appId) throws IOException;
}
