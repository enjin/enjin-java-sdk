package com.enjin.enjincoin.sdk.service.users;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateUser;
import com.enjin.enjincoin.sdk.model.query.GetUsers;
import com.enjin.enjincoin.sdk.model.query.LoginUser;
import com.enjin.enjincoin.sdk.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.UsersData;

import java.io.IOException;

public interface SynchronousUsersService {

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<CreateUserData>> createUserSync(CreateUser query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<LoginUserData>> loginUserSync(LoginUser query) throws IOException;

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<UsersData>> getAllUsersSync() throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<UsersData>> getUsersSync(GetUsers query) throws IOException;
}
