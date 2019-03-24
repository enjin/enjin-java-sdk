package com.enjin.enjincoin.sdk.client.service.identities.impl;

import com.enjin.enjincoin.sdk.client.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.client.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.client.service.identities.vo.data.UpdateIdentityData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IdentitiesRetrofitService {

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetAllIdentities")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<IdentitiesData>> getAllIdentities(@Body GraphQLRequest.Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetIdentities")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<IdentitiesData>> getIdentities(@Body GraphQLRequest.Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateIdentityData>> createIdentity(@Body GraphQLRequest.Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UnlinkIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> unlinkIdentity(@Body GraphQLRequest.Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateIdentityData>> updateIdentity(@Body GraphQLRequest.Builder request);

}
