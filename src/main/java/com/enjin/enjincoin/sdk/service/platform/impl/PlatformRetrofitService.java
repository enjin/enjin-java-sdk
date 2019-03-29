package com.enjin.enjincoin.sdk.service.platform.impl;

import com.enjin.enjincoin.sdk.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.platform.vo.data.PlatformData;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest.Builder;
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
    @GraphQuery("GetPlatform")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<PlatformData>> getPlatform(@Body Builder request);


}
