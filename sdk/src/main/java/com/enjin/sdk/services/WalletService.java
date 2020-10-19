package com.enjin.sdk.services;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Wallet;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * Used internally for wallet requests.
 */
public interface WalletService {

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Wallet>> getOne(@Path("schema") String schema,
                                         @Body JsonObject request);

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Wallet>>> getMany(@Path("schema") String schema,
                                                @Body JsonObject request);

}
