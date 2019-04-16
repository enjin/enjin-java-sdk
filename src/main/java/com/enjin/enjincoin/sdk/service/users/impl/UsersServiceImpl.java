package com.enjin.enjincoin.sdk.service.users.impl;

import com.enjin.enjincoin.sdk.Callback;
import com.enjin.enjincoin.sdk.Response;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.query.CreateUser;
import com.enjin.enjincoin.sdk.model.query.GetUsers;
import com.enjin.enjincoin.sdk.model.query.LoginUser;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.ServiceBase;
import com.enjin.enjincoin.sdk.service.users.UsersService;
import com.enjin.enjincoin.sdk.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.UsersData;
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
                                Callback<GraphQLResponse<CreateUserData>> callback) {
        enqueue(getCreateCall(query), callback);
    }

    @Override
    public void loginUserAsync(LoginUser query,
                               Callback<GraphQLResponse<LoginUserData>> callback) {
        enqueue(getLoginCall(query), callback);
    }

    @Override
    public void getAllUsersAsync(Callback<GraphQLResponse<UsersData>> callback) {
        enqueue(getAllUsersCall(), callback);
    }

    @Override
    public void getUsersAsync(GetUsers query,
                              Callback<GraphQLResponse<UsersData>> callback) {
        enqueue(getUsersCall(query), callback);
    }

    @Override
    public Response<GraphQLResponse<CreateUserData>> createUserSync(CreateUser query) throws IOException {
        return execute(getCreateCall(query));
    }

    @Override
    public Response<GraphQLResponse<LoginUserData>> loginUserSync(LoginUser query) throws IOException {
        return execute(getLoginCall(query));
    }

    @Override
    public Response<GraphQLResponse<UsersData>> getAllUsersSync() throws IOException {
        return execute(getAllUsersCall());
    }

    @Override
    public Response<GraphQLResponse<UsersData>> getUsersSync(GetUsers query) throws IOException {
        return execute(getUsersCall(query));
    }

    private Call<GraphQLResponse<CreateUserData>> getCreateCall(CreateUser query) {
        return this.service.createUser(query);
    }

    private Call<GraphQLResponse<LoginUserData>> getLoginCall(LoginUser query) {
        return this.service.loginUser(query);
    }

    private Call<GraphQLResponse<UsersData>> getAllUsersCall() {
        return this.service.getAllUsers(GraphQLRequest.builder());
    }

    private Call<GraphQLResponse<UsersData>> getUsersCall(GetUsers query) {
        return this.service.getUsers(query);
    }
}
