package com.enjin.enjincoin.sdk.client.service.users.impl;

import com.enjin.enjincoin.sdk.client.Callback;
import com.enjin.enjincoin.sdk.client.Response;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.ServiceBase;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.UsersData;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class UsersServiceImpl extends ServiceBase implements UsersService {

    private UsersRetrofitService service;

    public UsersServiceImpl(final Retrofit retrofit) {
        this.service = retrofit.create(UsersRetrofitService.class);
    }

    @Override
    public void createUserAsync(final String name,
                                final String email,
                                final String password,
                                final Callback<GraphQLResponse<CreateUserData>> callback) {
        enqueue(getCreateCall(name, email, password), callback);
    }

    @Override
    public void loginUserAsync(final String name,
                               final String email,
                               final String password,
                               final Callback<GraphQLResponse<LoginUserData>> callback) {
        enqueue(getLoginCall(name, email, password), callback);
    }

    @Override
    public void getAllUsersAsync(final Callback<GraphQLResponse<UsersData>> callback) {
        enqueue(getAllUsersCall(), callback);
    }

    @Override
    public void getUsersAsync(final Integer userId,
                              final String name,
                              final String email,
                              final Callback<GraphQLResponse<UsersData>> callback) {
        enqueue(getUsersCall(userId, name, email), callback);
    }

    @Override
    public Response<GraphQLResponse<CreateUserData>> createUserSync(final String name,
                                                                    final String email,
                                                                    final String password) throws IOException {
        return execute(getCreateCall(name, email, password));
    }

    @Override
    public Response<GraphQLResponse<LoginUserData>> loginUserSync(final String name,
                                                                  final String email,
                                                                  final String password) throws IOException {
        return execute(getLoginCall(name, email, password));
    }

    @Override
    public Response<GraphQLResponse<UsersData>> getAllUsersSync() throws IOException {
        return execute(getAllUsersCall());
    }

    @Override
    public Response<GraphQLResponse<UsersData>> getUsersSync(final Integer userId,
                                                             final String name,
                                                             final String email) throws IOException {
        return execute(getUsersCall(userId, name, email));
    }

    private Call<GraphQLResponse<CreateUserData>> getCreateCall(final String name,
                                                                final String email,
                                                                final String password) {
        return this.service.createUser(GraphQLRequest.builder()
                                                     .withParameter("name", name)
                                                     .withParameter("email", email)
                                                     .withParameter("password", password));
    }

    private Call<GraphQLResponse<LoginUserData>> getLoginCall(final String name,
                                                              final String email,
                                                              final String password) {
        return this.service.loginUser(GraphQLRequest.builder()
                                                    .withParameter("name", name)
                                                    .withParameter("email", email)
                                                    .withParameter("password", password));
    }

    private Call<GraphQLResponse<UsersData>> getAllUsersCall() {
        return this.service.getAllUsers(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<UsersData>> getUsersCall(final Integer id, final String name, final String email) {
        return this.service.getUsers(GraphQLRequest.builder()
                                                   .withParameter("id", id)
                                                   .withParameter("name", name)
                                                   .withParameter("email", email));
    }
}
