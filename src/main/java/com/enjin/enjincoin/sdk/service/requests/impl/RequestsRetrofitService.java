package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.requests.CreateRequestResult;
import com.enjin.enjincoin.sdk.model.service.requests.GetRequestsResult;
import com.enjin.enjincoin.sdk.model.service.requests.UpdateRequestResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestsRetrofitService {

    @POST("graphql")
    @GraphQuery("GET_ALL_REQUESTS")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetRequestsResult>> getAllRequests(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("GET_REQUESTS")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetRequestsResult>> getRequests(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CREATE_REQUEST")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateRequestResult>> createRequest(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UPDATE_REQUEST")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateRequestResult>> updateRequest(@Body GraphQLRequest request);

}
