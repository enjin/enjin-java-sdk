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
import retrofit2.http.Path;

public interface IdentitiesRetrofitService {

    @POST("graphql/{schema}")
    @GraphQuery("GetIdentities")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Identity>>> getIdentities(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("CreateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> createIdentity(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("DeleteIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> deleteIdentity(@Path(value = "schema") String schema, @Body GraphQLRequest request);

    @POST("graphql/{schema}")
    @GraphQuery("UpdateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> updateIdentity(@Path(value = "schema") String schema, @Body GraphQLRequest request);

}
