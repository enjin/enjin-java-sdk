package com.enjin.sdk.services.app.impl;

import java.util.List;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.graphql.GraphQuery;
import com.enjin.sdk.models.app.App;

import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.app.AuthApp;
import com.enjin.sdk.models.app.CreateApp;
import com.enjin.sdk.models.app.DeleteApp;
import com.enjin.sdk.models.app.GetApp;
import com.enjin.sdk.models.app.GetApps;
import com.enjin.sdk.models.app.UnlinkApp;
import com.enjin.sdk.models.app.UpdateApp;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface providing API endpoints for a retrofit adapter.
 */
public interface AppsRetrofitService {

    /**
     * Gets the applications.
     *
     * @see GetApps
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetAppsPaginated")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<List<App>>> getApps(@Body GraphQLRequest request);

    /**
     * Gets an application.
     *
     * @see GetApp
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("GetApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> getApp(@Body GraphQLRequest request);

    /**
     * Creates an application.
     *
     * @see CreateApp
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("CreateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> createApp(@Body GraphQLRequest request);

    /**
     * Deletes an application.
     *
     * @see DeleteApp
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("DeleteApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> deleteApp(@Body GraphQLRequest request);

    /**
     * Updates an application.
     *
     * @see UpdateApp
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("UpdateApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> updateApp(@Body GraphQLRequest request);

    /**
     * Gets an application's access tokens.
     *
     * @see AuthApp
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("AuthApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<AccessToken>> authApp(@Body GraphQLRequest request);

    /**
     * Unlinks a wallet from an application.
     *
     * @see UnlinkApp
     * @param request the request
     * @return        the request call
     */
    @POST("graphql")
    @GraphQuery("UnlinkApp")
    @Headers("Content-Type: application/json")
    Call<GraphQLResponse<App>> unlinkApp(@Body GraphQLRequest request);

}
