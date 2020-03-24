package com.enjin.sdk.services.app.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.app.App;

import com.enjin.sdk.models.AuthTokens;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AppsRetrofitService {

    @POST("graphql")
    @GraphQuery("GetAppsPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<App>>> getApps(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GetApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> getApp(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> createApp(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> deleteApp(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> updateApp(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("AuthApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<AuthTokens>> authApp(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UnlinkApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> unlinkApp(@Body GraphQLRequest request);

}
