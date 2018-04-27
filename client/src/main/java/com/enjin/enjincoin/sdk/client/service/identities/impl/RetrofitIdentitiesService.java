package com.enjin.enjincoin.sdk.client.service.identities.impl;

import com.enjin.enjincoin.sdk.client.annotations.serialization.Json;
import com.enjin.enjincoin.sdk.client.service.identities.vo.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitIdentitiesService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities")
    Call<Identity[]> getIdentities();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities")
    Call<Identity[]> getIdentities(@Json @Query("q") IdentityFilter filter);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/identities/{id}")
    Call<Identity> getIdentity(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/identities")
    Call<CreateIdentityResponseBody> createIdentity(@Json @Body CreateIdentityRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @PUT("api/v1/identities/{id}")
    Call<UpdateIdentityResponseBody> updateIdentity(@Path("id") long id, @Json @Body UpdateIdentityRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @DELETE("api/v1/identities/{id}")
    Call<Boolean> deleteIdentity(@Path("id") long id);

}
