package io.enjincoin.sdk.client.service.tokens.impl;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import io.enjincoin.sdk.client.service.tokens.vo.Token;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitTokensService {

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/tokens")
    Call<Token[]> getTokens();

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @GET("api/v1/tokens/{id}")
    Call<Token> getToken(@Path("id") long id);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @POST("api/v1/tokens")
    Call<Token> createToken(@Json @Body Token request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @PUT("api/v1/tokens/{id}")
    Call<Token> updateToken(@Path("id") long id, @Json @Body Token request);

    @Headers(value = {
            "Content-Type: application/json",
            "Cache-Control: no-cache"
    })
    @DELETE("api/v1/tokens/{id}")
    Call<Boolean> deleteToken(@Path("id") long id);

}
