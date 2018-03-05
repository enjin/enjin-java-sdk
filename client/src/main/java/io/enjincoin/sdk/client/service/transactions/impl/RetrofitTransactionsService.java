package io.enjincoin.sdk.client.service.transactions.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.ExecuteTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.TransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitTransactionsService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/transactions")
    Call<TransactionResponseBody[]> getTransactions();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/transactions/{id}")
    Call<TransactionResponseBody> getTransaction(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/transactions")
    Call<CreateTransactionResponseBody> createTransaction(@Json @Body CreateTransactionRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @PUT("api/v1/transactions/{id}")
    Call<UpdateTransactionResponseBody> updateTransaction(@Path("id") long id, @Json @Body UpdateTransactionRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @DELETE("api/v1/transactions/{id}")
    Call<Boolean> deleteTransaction(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/transactions/{id}/execute")
    Call<Boolean> executeTransaction(@Path("id") long id, @Json @Body ExecuteTransactionRequestBody request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/transactions/{id}/cancel")
    Call<Boolean> cancelTransaction(@Path("id") long id);
}
