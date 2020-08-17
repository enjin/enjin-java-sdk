package com.enjin.sdk.schemas;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * TODO
 */
public interface PlatformService {

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Platform>> getPlatform(@Path("schema") String schema,
                                                @Body JsonObject request);

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GasPrices>> getGasPrices(@Path("schema") String schema,
                                                  @Body JsonObject request);

}
