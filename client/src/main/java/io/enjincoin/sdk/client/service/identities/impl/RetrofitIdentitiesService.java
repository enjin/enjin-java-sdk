package io.enjincoin.sdk.client.service.identities.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import io.enjincoin.sdk.client.service.identities.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.LinkIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityResponseBody;
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
    Call<GetIdentityResponseBody> getIdentity(@Path("id") long id);

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

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })

    @PUT("api/v1/identity/link-wallet/(linking_code}")
    Call<LinkIdentityResponseBody> linkIdentity(@Path("linking_code") String linkingCode, @Json @Body LinkIdentityRequestBody request);
}
