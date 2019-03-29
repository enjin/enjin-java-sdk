package com.enjin.enjincoin.sdk.service.requests.impl;

import com.enjin.enjincoin.sdk.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.requests.vo.data.CreateRequestData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.RequestsData;
import com.enjin.enjincoin.sdk.service.requests.vo.data.UpdateRequestData;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest.Builder;
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
    Call<GraphQLResponse<RequestsData>> getAllRequests(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetRequests")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<RequestsData>> getRequests(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateRequestData>> createRequest(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateRequestData>> updateRequest(@Body Builder request);

}
