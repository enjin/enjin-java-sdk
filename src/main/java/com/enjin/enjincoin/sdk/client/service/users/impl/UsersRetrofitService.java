package com.enjin.enjincoin.sdk.client.service.users.impl;

import com.enjin.enjincoin.sdk.client.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.client.service.users.vo.data.UsersData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsersRetrofitService {

    /**
     *
     * @param User
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetAllUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UsersData>> getAllUsers(@Body GraphQLRequest.Builder User);

    /**
     *
     * @param User
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UsersData>> getUsers(@Body GraphQLRequest.Builder User);

    /**
     *
     * @param User
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateUserData>> createUser(@Body GraphQLRequest.Builder User);

    /**
     *
     * @param User
     * @return
     */
    @POST("graphql")
    @GraphQuery("LoginUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<LoginUserData>> loginUser(@Body GraphQLRequest.Builder User);

}
