package com.enjin.enjincoin.sdk.service.users.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.users.CreateUser;
import com.enjin.enjincoin.sdk.model.service.users.GetUsers;
import com.enjin.enjincoin.sdk.model.service.users.LoginUser;
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
                                HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(getCreateCall(query), callback);
    }

    @Override
    public void loginUserAsync(LoginUser query,
                               HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(getLoginCall(query), callback);
    }

    @Override
    public void getUsersAsync(GetUsers query,
                              HttpCallback<GraphQLResponse<List<User>>> callback) {
        enqueueGraphQLCall(getUsersCall(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> createUserSync(CreateUser query) throws IOException {
        return executeGraphQLCall(getCreateCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> loginUserSync(LoginUser query) throws IOException {
        return executeGraphQLCall(getLoginCall(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<List<User>>> getUsersSync(GetUsers query) throws IOException {
        return executeGraphQLCall(getUsersCall(query));
    }


    private Call<GraphQLResponse<User>> getCreateCall(CreateUser query) {
        return this.service.createUser(query);
    }

    private Call<GraphQLResponse<User>> getLoginCall(LoginUser query) {
        return this.service.loginUser(query);
    }

    private Call<GraphQLResponse<List<User>>> getUsersCall(GetUsers query) {
        return this.service.getUsers(query);
    }
}
