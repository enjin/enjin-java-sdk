package com.enjin.sdk.service.apps.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.apps.App;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AppsRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetApps")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<App>>> getApps(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("CreateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> createApps(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("DeleteApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> deleteApps(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("UpdateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> updateApps(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
