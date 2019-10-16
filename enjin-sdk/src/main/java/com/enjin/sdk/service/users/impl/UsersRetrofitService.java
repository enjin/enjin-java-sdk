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
import retrofit2.http.Path;

public interface UsersRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("AuthUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> authUser(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("GetUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<User>>> getUsers(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("CreateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> createUser(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("UpdateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> updateUser(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("DeleteUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> deleteUser(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
