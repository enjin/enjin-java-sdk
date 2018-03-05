package io.enjincoin.sdk.client.service.requests.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.ExecuteRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitRequestsService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/requests")
    Call<RequestResponseBody[]> getRequests();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/requests/{id}")
    Call<RequestResponseBody> getRequest(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/requests")
    Call<CreateRequestResponseBody> createRequest(@Json @Body CreateRequestRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @PUT("api/v1/requests/{id}")
    Call<UpdateRequestResponseBody> updateRequest(@Path("id") long id, @Json @Body UpdateRequestRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @DELETE("api/v1/requests/{id}")
    Call<Boolean> deleteRequest(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/requests/{id}/execute")
    Call<Boolean> executeRequest(@Path("id") long id, @Json @Body ExecuteRequestRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/requests/{id}/cancel")
    Call<Boolean> cancelRequest(@Path("id") long id);
}
