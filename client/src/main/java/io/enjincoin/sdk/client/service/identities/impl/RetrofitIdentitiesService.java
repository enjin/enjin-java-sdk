package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitIdentitiesService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities")
    Call<GetIdentityResponseBody[]> getIdentities();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities")
    Call<GetIdentityResponseBody[]> getIdentities(@Json @Query("q") IdentityFilter filter);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities/{id}")
    Call<GetIdentityResponseBody> getIdentity(@Path("id") int id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/identities")
    Call<CreateIdentityResponseBody> createIdentity(@Json @Body CreateIdentityRequestBody request);

}
