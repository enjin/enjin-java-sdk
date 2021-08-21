package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Asset;
import com.enjin.sdk.schemas.shared.mutations.CancelTransaction;
import com.enjin.sdk.schemas.shared.queries.GetBalances;
import com.enjin.sdk.schemas.shared.queries.GetGasPrices;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
import com.enjin.sdk.schemas.shared.queries.GetProject;
import com.enjin.sdk.schemas.shared.queries.GetRequest;
import com.enjin.sdk.schemas.shared.queries.GetRequests;
import com.enjin.sdk.schemas.shared.queries.GetAsset;
import com.enjin.sdk.schemas.shared.queries.GetAssets;

import java.util.List;

/**
 * Interface for shared schema implementation.
 */
public interface ISharedSchema {

    /**
     * Sends {@link CancelTransaction} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Boolean> cancelTransaction(CancelTransaction request);

    /**
     * Sends {@link CancelTransaction} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void cancelTransaction(CancelTransaction request,
                           HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * Sends {@link GetAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Asset> getAsset(GetAsset request);

    /**
     * Sends {@link GetAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getAsset(GetAsset request,
                  HttpCallback<GraphQLResponse<Asset>> callback);

    /**
     * Sends {@link GetAssets} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Asset>> getAssets(GetAssets request);

    /**
     * Sends {@link GetAssets} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getAssets(GetAssets request,
                   HttpCallback<GraphQLResponse<List<Asset>>> callback);

    /**
     * Sends {@link GetBalances} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Balance>> getBalances(GetBalances request);

    /**
     * Sends {@link GetBalances} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getBalances(GetBalances request,
                     HttpCallback<GraphQLResponse<List<Balance>>> callback);

    /**
     * Sends {@link GetGasPrices} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request);

    /**
     * Sends {@link GetGasPrices} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getGasPrices(GetGasPrices request,
                      HttpCallback<GraphQLResponse<GasPrices>> callback);

    /**
     * Sends {@link GetPlatform} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Platform> getPlatform(GetPlatform request);

    /**
     * Sends {@link GetPlatform} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getPlatform(GetPlatform request,
                     HttpCallback<GraphQLResponse<Platform>> callback);

    /**
     * Sends {@link GetProject} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Project> getProject(GetProject request);

    /**
     * Sends {@link GetProject} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getProject(GetProject request,
                    HttpCallback<GraphQLResponse<Project>> callback);

    /**
     * Sends {@link GetRequest} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> getRequest(GetRequest request);

    /**
     * Sends {@link GetRequest} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getRequest(GetRequest request,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link GetRequests} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Request>> getRequests(GetRequests request);

    /**
     * Sends {@link GetRequests} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getRequests(GetRequests request,
                     HttpCallback<GraphQLResponse<List<Request>>> callback);

}
