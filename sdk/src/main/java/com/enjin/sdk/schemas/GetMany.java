package com.enjin.sdk.schemas;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.Collection;

interface GetMany<T> {

    @POST("graphql")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Collection<T>>> getMany(@Body JsonObject request);

}
