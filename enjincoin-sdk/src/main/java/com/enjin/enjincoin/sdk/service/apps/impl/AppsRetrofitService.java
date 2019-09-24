package com.enjin.enjincoin.sdk.service.apps.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.apps.App;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

public interface AppsRetrofitService {

    @POST("graphql")
    @GraphQuery("GetApps")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<App>>> getApps(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> createApps(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> deleteApps(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> updateApps(@Body GraphQLRequest request);

}
