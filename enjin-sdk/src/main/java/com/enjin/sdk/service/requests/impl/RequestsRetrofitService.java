package com.enjin.sdk.service.requests.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.requests.Transaction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RequestsRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetRequests")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Transaction>>> getRequests(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("CreateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> createRequest(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("UpdateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> updateRequest(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("DeleteRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> deleteRequest(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
