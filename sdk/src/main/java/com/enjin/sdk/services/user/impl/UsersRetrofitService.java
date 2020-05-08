package com.enjin.sdk.services.user.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.user.AuthPlayer;
import com.enjin.sdk.models.user.CreateUser;
import com.enjin.sdk.models.user.GetUser;
import com.enjin.sdk.models.user.GetUsers;
import com.enjin.sdk.models.user.OAuthUser;
import com.enjin.sdk.models.user.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface UsersRetrofitService {

    /**
     * Login a user.
     *
     * @see OAuthUser
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("LoginUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> oAuthUser(@Body GraphQLRequest request);

    /**
     * Gets the users.
     *
     * @see GetUsers
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetUsersPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<User>>> getUsers(@Body GraphQLRequest request);

    /**
     * Gets a user.
     *
     * @see GetUser
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> getUser(@Body GraphQLRequest request);

    /**
     * Creates a user.
     *
     * @see CreateUser
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("CreateUser")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<User>> createUser(@Body GraphQLRequest request);

    /**
     * Gets a player's access tokens.
     *
     * @see AuthPlayer
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("AuthPlayer")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<AccessToken>> authUser(@Body GraphQLRequest request);

}
