package com.enjin.enjincoin.sdk.client.service.requests.impl;

import com.enjin.enjincoin.sdk.client.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.client.service.requests.vo.data.UpdateRequestData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestsRetrofitService {

    @POST("graphql")
    @GraphQuery("GetAllRequests")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<RequestsData>> getAllRequests(@Body GraphQLRequest.Builder request);

    @POST("graphql")
    @GraphQuery("GetRequests")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<RequestsData>> getRequests(@Body GraphQLRequest.Builder request);

    @POST("graphql")
    @GraphQuery("CreateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateRequestData>> createRequest(@Body GraphQLRequest.Builder request);

    @POST("graphql")
    @GraphQuery("UpdateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateRequestData>> updateRequest(@Body GraphQLRequest.Builder request);

}
