package com.enjin.enjincoin.sdk.client.service.users.impl;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class UsersServiceImpl implements UsersService {

    private GraphQLRetrofitService service;

    public UsersServiceImpl(final GraphQLRetrofitService service) {
        this.service = service;
    }

    @Override
    public void createUserAsync(final String name, final String email, final String password, final Callback<GraphQLResponse> callback) {
        getCreateCall(name, email, password).enqueue(callback);
    }

    @Override
    public void loginUserAsync(final String name, final String email, final String password, final Callback<GraphQLResponse> callback) {
        getLoginCall(name, email, password).enqueue(callback);
    }

    @Override
    public void getAllUsersAsync(final Callback<GraphQLResponse> callback) {
        getAllUsersCall().enqueue(callback);
    }

    @Override
    public void getUsersAsync(final Integer id, final String name, final String email, final Callback<GraphQLResponse> callback) {
        getUsersCall(id, name, email).enqueue(callback);
    }

    @Override
    public Response<GraphQLResponse> createUserSync(final String name, final String email, final String password) throws IOException {
        return getCreateCall(name, email, password).execute();
    }

    @Override
    public Response<GraphQLResponse> loginUserSync(final String name, final String email, final String password) throws IOException {
        return getLoginCall(name, email, password).execute();
    }

    @Override
    public Response<GraphQLResponse> getAllUsersSync() throws IOException {
        return getAllUsersCall().execute();
    }

    @Override
    public Response<GraphQLResponse> getUsersSync(final Integer id, final String name, final String email) throws IOException {
        return getUsersCall(id, name, email).execute();
    }

    private Call<GraphQLResponse> getCreateCall(final String name, final String email, final String password) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/users/createUser.mutation")
                .withParameter("name", name)
                .withParameter("email", email)
                .withParameter("password", password)
                .build().call();
    }

    private Call<GraphQLResponse> getLoginCall(final String name, final String email, final String password) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/users/loginUser.query")
                .withParameter("name", name)
                .withParameter("email", email)
                .withParameter("password", password)
                .build().call();
    }

    private Call<GraphQLResponse> getAllUsersCall() {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/users/getAllUsers.query")
                .build().call();
    }

    private Call<GraphQLResponse> getUsersCall(final Integer id, final String name, final String email) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/users/getUsers.query")
                .withParameter("id", id)
                .withParameter("name", name)
                .withParameter("email", email)
                .build().call();
    }
}
