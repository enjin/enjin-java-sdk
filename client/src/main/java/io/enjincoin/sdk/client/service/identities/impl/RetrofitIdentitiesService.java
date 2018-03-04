package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.identities.IdentityFilter;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitIdentitiesService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities")
    Call<GetIdentityResponseVO[]> getIdentities();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities")
    Call<GetIdentityResponseVO[]> getIdentities(@Json @Query("q") IdentityFilter filter);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities/{id}")
    Call<GetIdentityResponseVO> getIdentity(@Path("id") int id);

}
