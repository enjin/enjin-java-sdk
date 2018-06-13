package com.enjin.enjincoin.sdk.client.service.platform.impl;

import com.enjin.enjincoin.sdk.client.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.platform.vo.data.PlatformData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PlatformRetrofitService {

    @POST("graphql")
    @GraphQuery("GetPlatform")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<PlatformData>> getPlatform(@Body GraphQLRequest.Builder request);


}
