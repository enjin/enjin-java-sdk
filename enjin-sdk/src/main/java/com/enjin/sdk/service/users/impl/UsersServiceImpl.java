package com.enjin.sdk.service.users.impl;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.users.AuthUser;
import com.enjin.sdk.model.service.users.CreateUser;
import com.enjin.sdk.model.service.users.DeleteUser;
import com.enjin.sdk.model.service.users.GetUsers;
import com.enjin.sdk.model.service.users.UpdateUser;
import com.enjin.sdk.model.service.users.User;
import com.enjin.sdk.service.GraphQLServiceBase;
import com.enjin.sdk.service.users.UsersService;

import retrofit2.Retrofit;

public class UsersServiceImpl extends GraphQLServiceBase implements UsersService {

    private final UsersRetrofitService service;

    public UsersServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(UsersRetrofitService.class);
    }

    @Override
    public void getUsersAsync(GetUsers query,
                              HttpCallback<GraphQLResponse<List<User>>> callback) {
        enqueueGraphQLCall(this.service.getUsers(query), callback);
    }

    @Override
    public void createUserAsync(CreateUser query,
                                HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.createUser(query), callback);
    }

    @Override
    public void updateUserAsync(UpdateUser query, HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.updateUser(query), callback);
    }

    @Override
    public void deleteUserAsync(DeleteUser query, HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.deleteUser(query), callback);
    }

    @Override
    public void authUserAsync(AuthUser query,
                              HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.authUser(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<User>>> getUsersSync(GetUsers query) throws IOException {
        return executeGraphQLCall(this.service.getUsers(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> createUserSync(CreateUser query) throws IOException {
        return executeGraphQLCall(this.service.createUser(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> updateUserSync(UpdateUser query) throws IOException {
        return executeGraphQLCall(this.service.updateUser(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> deleteUserSync(DeleteUser query) throws IOException {
        return executeGraphQLCall(this.service.deleteUser(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> authUserSync(AuthUser query) throws IOException {
        return executeGraphQLCall(this.service.authUser(query));
    }

}
