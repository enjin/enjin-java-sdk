package com.enjin.enjincoin.sdk.service.platform.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.platform.GetPlatformResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PlatformRetrofitService {

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GET_PLATFORM")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetPlatformResult>> getPlatform(@Body GraphQLRequest request);


}
