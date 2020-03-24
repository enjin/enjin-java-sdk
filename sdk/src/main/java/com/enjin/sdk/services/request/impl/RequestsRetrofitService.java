package com.enjin.sdk.services.request.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.request.Transaction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestsRetrofitService {

    @POST("graphql")
    @GraphQuery("GetRequestsPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Transaction>>> getRequests(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> createRequest(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> updateRequest(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> deleteRequest(@Body GraphQLRequest request);

}
