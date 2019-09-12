package com.enjin.sdk.service.users.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.users.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsersRetrofitService {

    @POST("graphql")
    @GraphQuery("AuthUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> authUser(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GetUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<User>>> getUsers(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> createUser(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> updateUser(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> deleteUser(@Body GraphQLRequest request);

}
