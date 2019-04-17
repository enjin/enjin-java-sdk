package com.enjin.enjincoin.sdk.service.users.impl;

import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.users.UsersService;
import com.enjin.enjincoin.sdk.util.concurrent.Callback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class UsersServiceImpl extends ServiceBase implements UsersService {

    private UsersRetrofitService service;

    public UsersServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(UsersRetrofitService.class);
    }

    @Override
    public void createUserAsync(CreateUser query,
                                Callback<GraphQLResponse<CreateUserResult>> callback) {
        enqueue(getCreateCall(query), callback);
    }

    @Override
    public void loginUserAsync(LoginUser query,
                               Callback<GraphQLResponse<LoginUserResult>> callback) {
        enqueue(getLoginCall(query), callback);
    }

    @Override
    public void getAllUsersAsync(Callback<GraphQLResponse<GetUsersResult>> callback) {
        enqueue(getAllUsersCall(), callback);
    }

    @Override
    public void getUsersAsync(GetUsers query,
                              Callback<GraphQLResponse<GetUsersResult>> callback) {
        enqueue(getUsersCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<CreateUserResult>> createUserSync(CreateUser query) throws IOException {
        return execute(getCreateCall(query));
    }

    @Override
    public Response<GraphQLResponse<LoginUserResult>> loginUserSync(LoginUser query) throws IOException {
        return execute(getLoginCall(query));
    }

    @Override
    public Response<GraphQLResponse<GetUsersResult>> getAllUsersSync() throws IOException {
        return execute(getAllUsersCall());
    }

    @Override
    public Response<GraphQLResponse<GetUsersResult>> getUsersSync(GetUsers query) throws IOException {
        return execute(getUsersCall(query));
    }

    private Call<GraphQLResponse<CreateUserResult>> getCreateCall(CreateUser query) {
        return this.service.createUser(query);
    }

    private Call<GraphQLResponse<LoginUserResult>> getLoginCall(LoginUser query) {
        return this.service.loginUser(query);
    }

    private Call<GraphQLResponse<GetUsersResult>> getAllUsersCall() {
        return this.service.getAllUsers(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<GetUsersResult>> getUsersCall(GetUsers query) {
        return this.service.getUsers(query);
    }
}
