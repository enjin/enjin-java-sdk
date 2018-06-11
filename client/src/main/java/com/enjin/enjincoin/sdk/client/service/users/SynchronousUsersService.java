package com.enjin.enjincoin.sdk.client.service.users;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import retrofit2.Response;

import java.io.IOException;

public interface SynchronousUsersService {

    Response<GraphQLResponse> createUserSync(String name, String email, String password) throws IOException;

    Response<GraphQLResponse> loginUserSync(String name, String email, String password) throws IOException;

    Response<GraphQLResponse> getAllUsersSync() throws IOException;

    Response<GraphQLResponse> getUsersSync(Integer id, String name, String email) throws IOException;
}
