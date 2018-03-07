package io.enjincoin.sdk.client.service.platform.impl;

import io.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RetrofitPlatformService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/platform")
    Call<PlatformResponseBody> getPlatform();

}
