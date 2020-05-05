package com.enjin.sdk.services.request.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.request.CreateRequest;
import com.enjin.sdk.models.request.DeleteRequest;
import com.enjin.sdk.models.request.GetRequests;
import com.enjin.sdk.models.request.Transaction;

import com.enjin.sdk.models.request.UpdateRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface RequestsRetrofitService {

    /**
     * Gets the requests.
     *
     * @see GetRequests
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetRequestsPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Transaction>>> getRequests(@Body GraphQLRequest request);

    /**
     * Creates a request.
     *
     * @see CreateRequest
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("CreateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> createRequest(@Body GraphQLRequest request);

    /**
     * Updates a request.
     *
     * @see UpdateRequest
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("UpdateRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> updateRequest(@Body GraphQLRequest request);

    /**
     * Deletes a request.
     *
     * @see DeleteRequest
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("DeleteRequest")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Transaction>> deleteRequest(@Body GraphQLRequest request);

}
