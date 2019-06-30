package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentityFields;
import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.enjin.enjincoin.sdk.model.service.identities.IdentityField;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

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

    @POST("graphql")
    @GraphQuery("GetIdentityFields")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<IdentityField>>> getIdentityFields(@Body GetIdentityFields request);

}
