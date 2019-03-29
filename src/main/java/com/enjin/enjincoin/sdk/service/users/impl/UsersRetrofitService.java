package com.enjin.enjincoin.sdk.service.users.impl;

import com.enjin.enjincoin.sdk.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.users.vo.data.CreateUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.LoginUserData;
import com.enjin.enjincoin.sdk.service.users.vo.data.UsersData;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest.Builder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsersRetrofitService {

    /**
     * @param User
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetAllUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UsersData>> getAllUsers(@Body Builder User);

    /**
     * @param User
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UsersData>> getUsers(@Body Builder User);

    /**
     * @param User
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateUserData>> createUser(@Body Builder User);

    /**
     * @param User
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("LoginUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<LoginUserData>> loginUser(@Body Builder User);

}
