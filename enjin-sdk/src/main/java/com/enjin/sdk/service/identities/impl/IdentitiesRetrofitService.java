package com.enjin.sdk.service.identities.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.model.service.identities.Identity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IdentitiesRetrofitService {

    @POST("graphql")
    @GraphQuery("GetIdentities")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Identity>>> getIdentities(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("CreateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> createIdentity(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("DeleteIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> deleteIdentity(@Body GraphQLRequest request);

    @POST("graphql")
    @GraphQuery("UpdateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> updateIdentity(@Body GraphQLRequest request);

}
