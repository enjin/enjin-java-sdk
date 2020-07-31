package com.enjin.sdk.schemas;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.AccessToken;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Auth {

    @POST("graphql")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<AccessToken>> getAuth(@Body JsonObject request);

}
