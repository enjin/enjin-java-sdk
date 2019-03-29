package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.annotation.GraphQuery;
import com.enjin.enjincoin.sdk.model.body.GraphQLResponse;
import com.enjin.enjincoin.sdk.service.identities.vo.Identity;
import com.enjin.enjincoin.sdk.service.identities.vo.data.CreateIdentityData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.IdentitiesData;
import com.enjin.enjincoin.sdk.service.identities.vo.data.UpdateIdentityData;
import com.enjin.enjincoin.sdk.model.request.GraphQLRequest.Builder;
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
    Call<GraphQLResponse<IdentitiesData>> getAllIdentities(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetIdentities")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<IdentitiesData>> getIdentities(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateIdentityData>> createIdentity(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UnlinkIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<Identity>> unlinkIdentity(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateIdentityData>> updateIdentity(@Body Builder request);

}
