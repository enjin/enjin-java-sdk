package com.enjin.sdk.services;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

interface GetMany<T> {

    @POST("/graphql/{schema}")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<T>>> getMany(@Path("schema") String schema,
                                           @Body JsonObject request);

}
