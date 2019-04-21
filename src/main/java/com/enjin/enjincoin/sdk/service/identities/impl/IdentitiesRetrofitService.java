package com.enjin.enjincoin.sdk.service.identities.impl;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest.Builder;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQuery;
import com.enjin.enjincoin.sdk.model.service.identities.CreateIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.DeleteIdentityResult;
import com.enjin.enjincoin.sdk.model.service.identities.GetIdentitiesResult;
import com.enjin.enjincoin.sdk.model.service.identities.Identity;
import com.enjin.enjincoin.sdk.model.service.identities.UpdateIdentityResult;
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
    Call<GraphQLResponse<GetIdentitiesResult>> getAllIdentities(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("GetIdentities")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<GetIdentitiesResult>> getIdentities(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("CreateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<CreateIdentityResult>> createIdentity(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("DeleteIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<DeleteIdentityResult>> deleteIdentity(@Body Builder request);

    /**
     * @param request
     *
     * @return
     */
    @POST("graphql")
    @GraphQuery("UpdateIdentity")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<UpdateIdentityResult>> updateIdentity(@Body Builder request);

}
