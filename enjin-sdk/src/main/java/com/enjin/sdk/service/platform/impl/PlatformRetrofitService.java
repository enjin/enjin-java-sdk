package com.enjin.sdk.service.platform.impl;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.platform.PlatformDetails;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlatformRetrofitService {

    /**
     * Gets the platform details for the trusted platform.
     *
     * @param request the request
     *
     * @return the request call
     */
    @POST("graphql/{schema}")
    @GraphQuery("GetPlatform")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<PlatformDetails>> getPlatform(@Path(value = "schema") String schema, @Body GraphQLRequest request);


}
