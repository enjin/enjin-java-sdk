package com.enjin.sdk.schemas;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface GetOne<T> {

    @POST("graphql")
    // TODO: Add the @GraphQuery annotation for the appropriate template, if necessary.
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<T>> getOne(@Body GraphQLRequest request);

}
