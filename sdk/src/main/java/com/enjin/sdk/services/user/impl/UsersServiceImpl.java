package com.enjin.sdk.services.user.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AuthTokens;
import com.enjin.sdk.models.user.AuthUser;
import com.enjin.sdk.models.user.OAuthUser;
import com.enjin.sdk.models.user.CreateUser;
import com.enjin.sdk.models.user.GetUser;
import com.enjin.sdk.models.user.GetUsers;
import com.enjin.sdk.models.user.User;
import com.enjin.sdk.services.GraphQLServiceBase;
import com.enjin.sdk.services.user.UsersService;

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
    public void getUserAsync(GetUser query, HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.getUser(query), callback);
    }

    @Override
    public void createUserAsync(CreateUser query,
                                HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.createUser(query), callback);
    }

    @Override
    public void oAuthUserAsync(OAuthUser query,
                               HttpCallback<GraphQLResponse<User>> callback) {
        enqueueGraphQLCall(this.service.oAuthUser(query), callback);
    }

    @Override
    public void authUserAsync(AuthUser query, HttpCallback<GraphQLResponse<AuthTokens>> callback) {
        enqueueGraphQLCall(this.service.authUser(query), callback);
    }

    @Override
    public HttpResponse<GraphQLResponse<List<User>>> getUsersSync(GetUsers query) {
        return executeGraphQLCall(this.service.getUsers(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> getUserSync(GetUser query) {
        return executeGraphQLCall(this.service.getUser(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> createUserSync(CreateUser query) {
        return executeGraphQLCall(this.service.createUser(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<User>> oAuthUserSync(OAuthUser query) {
        return executeGraphQLCall(this.service.oAuthUser(query));
    }

    @Override
    public HttpResponse<GraphQLResponse<AuthTokens>> authUserSync(AuthUser query) {
        return executeGraphQLCall(this.service.authUser(query));
    }

}
