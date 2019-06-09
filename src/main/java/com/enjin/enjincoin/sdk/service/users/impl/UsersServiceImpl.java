package com.enjin.enjincoin.sdk.service.users.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;
import com.enjin.enjincoin.sdk.model.service.users.User;
import com.enjin.enjincoin.sdk.service.GraphQLServiceBase;
import com.enjin.enjincoin.sdk.service.users.UsersService;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class UsersServiceImpl extends GraphQLServiceBase implements UsersService {

    private final UsersRetrofitService service;

    public UsersServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(UsersRetrofitService.class);
    }

    @Override
    public void createUserAsync(CreateUser query,
                                HttpCallback<GraphQLResponse<CreateUserResult>> callback) {
        enqueueGraphQLCall(getCreateCall(query), callback);
    }

    @Override
    public void loginUserAsync(LoginUser query,
                               HttpCallback<GraphQLResponse<LoginUserResult>> callback) {
        enqueueGraphQLCall(getLoginCall(query), callback);
    }

    @Override
    public void getAllUsersAsync(HttpCallback<GraphQLResponse<GetUsersResult>> callback) {
        enqueueGraphQLCall(getAllUsersCall(), callback);
    }

    @Override
    public void getUsersAsync(GetUsers query,
                              HttpCallback<GraphQLResponse<GetUsersResult>> callback) {
        enqueueGraphQLCall(getUsersCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<CreateUserResult>> createUserSync(CreateUser query) throws IOException {
        return executeGraphQLCall(getCreateCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<LoginUserResult>> loginUserSync(LoginUser query) throws IOException {
        return executeGraphQLCall(getLoginCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<GetUsersResult>> getAllUsersSync() throws IOException {
        return executeGraphQLCall(getAllUsersCall());
    }

    @Override
    public HttpResponse<GraphQLResponse<GetUsersResult>> getUsersSync(GetUsers query) throws IOException {
        return executeGraphQLCall(getUsersCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<List<User>>> getUsers2Sync(GetUsers query) throws IOException {
        return executeGraphQLCall(getUsers2Call(query));
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

    private Call<GraphQLResponse<List<User>>> getUsers2Call(GetUsers query) {
        return this.service.getUsers2(query);
    }
}
