package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest.Builder;
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

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetAllRequests")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetRequestsResult>> getAllRequests(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetRequests")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetRequestsResult>> getRequests(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateRequestResult>> createRequest(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateRequestResult>> updateRequest(@Body Builder request);

}
