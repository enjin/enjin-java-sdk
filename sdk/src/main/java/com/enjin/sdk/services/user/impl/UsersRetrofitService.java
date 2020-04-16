package com.enjin.sdk.services.user.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.user.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsersRetrofitService {

    @POST("graphql")
    @GraphQuery("LoginUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> oAuthUser(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GetUsersPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<User>>> getUsers(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GetUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> getUser(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> createUser(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("AuthPlayer")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<AccessToken>> authUser(@Body GraphQLRequest request);

}
