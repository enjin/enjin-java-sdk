package com.enjin.sdk.services;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Player;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * Used internally for player requests.
 */
public interface PlayerService extends Auth, Delete {

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Player>> getOne(@Path("schema") String schema,
                                         @Body JsonObject request);

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Player>>> getMany(@Path("schema") String schema,
                                                @Body JsonObject request);

}
