package com.enjin.enjincoin.sdk.client.service.users.impl;

import com.enjin.enjincoin.sdk.client.annotations.serialization.Json;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.CreateUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.LoginUserResponseBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UpdateUserRequestBody;
import com.enjin.enjincoin.sdk.client.service.users.vo.UserResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitUsersService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/users")
    Call<UserResponseBody[]> getUsers();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/users/{id}")
    Call<UserResponseBody> getUser(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/users")
    Call<CreateUserResponseBody> createUser(@Json @Body CreateUserRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @PUT("api/v1/users/{id}")
    Call<UserResponseBody> updateUser(@Path("id") long id, @Json @Body UpdateUserRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/user/login")
    Call<LoginUserResponseBody> loginUser(@Query("email") String emailAddress, @Query("password") String password, @Query("app_id") long appId);

}
