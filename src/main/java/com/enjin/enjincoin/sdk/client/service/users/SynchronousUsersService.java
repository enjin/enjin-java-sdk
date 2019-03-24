package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.UsersData;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousUsersService {

    /**
     *
     * @param name
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<CreateUserData>> createUserSync(String name, String email, String password) throws IOException;

    /**
     *
     * @param name
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<LoginUserData>> loginUserSync(String name, String email, String password) throws IOException;

    /**
     *
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UsersData>> getAllUsersSync() throws IOException;

    /**
     *
     * @param userId
     * @param name
     * @param email
     * @return
     * @throws IOException
     */
    Response<GraphQLResponse<UsersData>> getUsersSync(Integer userId, String name, String email) throws IOException;
}
