package com.enjin.enjincoin.sdk.client.service.users.impl;

import java.io.IOException;

import com.enjin.enjincoin.sdk.client.service.users.UsersService;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.LoginUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UpdateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UserResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsersServiceImpl implements UsersService{

    private RetrofitUsersService service;

    public UsersServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitUsersService.class);
    }

    @Override
    public void getUsersAsync(Callback<UserResponseBody[]> callback) {
        Call<UserResponseBody[]> call = this.service.getUsers();
        call.enqueue(callback);
    }

    @Override
    public void getUserAsync(long userId, Callback<UserResponseBody> callback) {
        Call<UserResponseBody> call = this.service.getUser(userId);
        call.enqueue(callback);
    }

    @Override
    public void createUserAsync(CreateUserRequestBody createUserRequestVO, Callback<CreateUserResponseBody> callback) {
        Call<CreateUserResponseBody> call = this.service.createUser(createUserRequestVO);
        call.enqueue(callback);
    }

    @Override
    public void updateUserAsync(long userId, UpdateUserRequestBody updateUserRequest, Callback<UserResponseBody> callback) {
        Call<UserResponseBody> call = this.service.updateUser(userId, updateUserRequest);
        call.enqueue(callback);
    }

    @Override
    public void loginUserAsync(String emailAddress, String password, long appId, Callback<LoginUserResponseBody> callback) {
        Call<LoginUserResponseBody> call = this.service.loginUser(emailAddress, password, appId);
        call.enqueue(callback);
    }

    @Override
    public Response<UserResponseBody[]> getUsersSync() throws IOException {
        Call<UserResponseBody[]> call = this.service.getUsers();
        return call.execute();
    }

    @Override
    public Response<UserResponseBody> getUserSync(long userId) throws IOException{
        Call<UserResponseBody> call = this.service.getUser(userId);
        return call.execute();
    }

    @Override
    public Response<CreateUserResponseBody> createUserSync(CreateUserRequestBody createUserRequestVO) throws IOException{
        Call<CreateUserResponseBody> call = this.service.createUser(createUserRequestVO);
        return call.execute();
    }

    @Override
    public Response<UserResponseBody> updateUserSync(long userId, UpdateUserRequestBody updateUserRequest) throws IOException{
        Call<UserResponseBody> call = this.service.updateUser(userId, updateUserRequest);
        return call.execute();
    }

    @Override
    public Response<LoginUserResponseBody> loginUserSync(String emailAddress, String password, long appId) throws IOException{
        Call<LoginUserResponseBody> call = this.service.loginUser(emailAddress, password, appId);
        return call.execute();
    }

}
