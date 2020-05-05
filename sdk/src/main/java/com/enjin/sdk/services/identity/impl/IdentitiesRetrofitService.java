package com.enjin.sdk.services.identity.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.identity.CreateIdentity;
import com.enjin.sdk.models.identity.DeleteIdentity;
import com.enjin.sdk.models.identity.GetIdentities;
import com.enjin.sdk.models.identity.GetIdentity;
import com.enjin.sdk.models.identity.Identity;

import com.enjin.sdk.models.identity.UnlinkIdentity;
import com.enjin.sdk.models.identity.UpdateIdentity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface IdentitiesRetrofitService {

    /**
     * Gets the identities.
     *
     * @see GetIdentities
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetIdentitiesPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<Identity>>> getIdentities(@Body GraphQLRequest request);

    /**
     * Gets an identity.
     *
     * @see GetIdentity
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> getIdentity(@Body GraphQLRequest request);

    /**
     * Creates an identity.
     *
     * @see CreateIdentity
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("CreateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> createIdentity(@Body GraphQLRequest request);

    /**
     * Deletes an identity.
     *
     * @see DeleteIdentity
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("DeleteIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> deleteIdentity(@Body GraphQLRequest request);

    /**
     * Updates an identity.
     *
     * @see UpdateIdentity
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("UpdateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> updateIdentity(@Body GraphQLRequest request);

    /**
     * Unlinks an identity.
     *
     * @see UnlinkIdentity
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("UnlinkIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> unlinkIdentity(@Body GraphQLRequest request);

}
