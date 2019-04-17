package com.enjin.enjincoin.sdk.service.users;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;

import java.io.IOException;

public interface SynchronousUsersService {

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<CreateUserResult>> createUserSync(CreateUser query) throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<LoginUserResult>> loginUserSync(LoginUser query) throws IOException;

    /**
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<GetUsersResult>> getAllUsersSync() throws IOException;

    /**
     * @param query
     *
     * @return
     *
     * @throws IOException
     */
    Response<GraphQLResponse<GetUsersResult>> getUsersSync(GetUsers query) throws IOException;
}
