package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.UsersData;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousUsersService {

    Response<GraphQLResponse<CreateUserData>> createUserSync(String name, String email, String password) throws IOException;

    Response<GraphQLResponse<LoginUserData>> loginUserSync(String name, String email, String password) throws IOException;

    Response<GraphQLResponse<UsersData>> getAllUsersSync() throws IOException;

    Response<GraphQLResponse<UsersData>> getUsersSync(Integer id, String name, String email) throws IOException;
}
