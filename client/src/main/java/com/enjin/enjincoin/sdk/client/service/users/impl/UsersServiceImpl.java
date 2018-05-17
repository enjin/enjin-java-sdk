package com.enjin.enjincoin.sdk.client.service.users.impl;

import java.io.IOException;

import com.enjin.enjincoin.sdk.client.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsersServiceImpl implements UsersService {

    private GraphQLRetrofitService service;

    public UsersServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(GraphQLRetrofitService.class);
    }

    @Override
    public void createUserSync(String name, String email, String password, Callback<JsonElement> callback) {
        getCreateCall(name, email, password).enqueue(callback);
    }

    @Override
    public void loginUserAsync(String name, String email, String password, Callback<JsonElement> callback) {
        getLoginCall(name, email, password).enqueue(callback);
    }

    @Override
    public Response<JsonElement> createUserSync(String name, String email, String password) throws IOException {
        return getCreateCall(name, email, password).execute();
    }

    @Override
    public Response<JsonElement> loginUserSync(String name, String email, String password) throws IOException {
        return getLoginCall(name, email, password).execute();
    }

    private Call<JsonElement> getCreateCall(String name, String email, String password) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/createUser.query")
                .withParameter("name", name)
                .withParameter("email", email)
                .withParameter("password", password)
                .build().call();
    }

    private Call<JsonElement> getLoginCall(String name, String email, String password) {
        return GraphQLRequest.builder(this.service)
                .fromResource("/graphql/loginUser.query")
                .withParameter("name", name)
                .withParameter("email", email)
                .withParameter("password", password)
                .build().call();
    }
}
