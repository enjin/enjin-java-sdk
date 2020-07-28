package com.enjin.sdk.schemas;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.AccessToken;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Auth {

    @POST("graphql")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<AccessToken>> getAuth(@Body GraphQLRequest request);

}
