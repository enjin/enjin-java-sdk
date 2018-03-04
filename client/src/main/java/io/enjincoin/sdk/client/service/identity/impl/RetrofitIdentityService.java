package io.enjincoin.sdk.client.service.identity.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitIdentityService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @PUT("api/v1/identity/link-wallet/{linking_code}")
    Call<LinkIdentityResponseBody> linkIdentity(@Path("linking_code") String linkingCode, @Json @Body LinkIdentityRequestBody request);

}
