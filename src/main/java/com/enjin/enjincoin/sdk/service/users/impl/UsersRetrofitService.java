package com.enjin.enjincoin.sdk.service.users.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest.Builder;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.users.CreateUserResult;
import com.enjin.enjincoin.sdk.model.service.users.GetUsersResult;
import com.enjin.enjincoin.sdk.model.service.users.LoginUserResult;
import com.enjin.enjincoin.sdk.model.service.users.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

public interface UsersRetrofitService {

    @POST("graphql")
    @GraphQuery("GET_ALL_USERS")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetUsersResult>> getAllUsers(@Body Builder builder);

    @POST("graphql")
    @GraphQuery("GET_USERS")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetUsersResult>> getUsers(@Body Builder builder);

    @POST("graphql")
    @GraphQuery("CREATE_USER")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateUserResult>> createUser(@Body Builder builder);

    @POST("graphql")
    @GraphQuery("LOGIN_USER")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<LoginUserResult>> loginUser(@Body Builder builder);

    @POST("graphql")
    @GraphQuery("GetUsers")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<User>>> getUsers2(@Body Builder builder);

}
