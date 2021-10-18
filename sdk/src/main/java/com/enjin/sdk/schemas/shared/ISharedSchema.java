/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.graphql.GraphQLResponse;
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
import java.util.concurrent.CompletableFuture;

/**
 * Interface for shared schema implementation.
 */
public interface ISharedSchema {

    /**
     * Sends {@link CancelTransaction} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Boolean>> cancelTransaction(CancelTransaction request);

    /**
     * Sends {@link GetAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Asset>> getAsset(GetAsset request);

    /**
     * Sends {@link GetAssets} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<List<Asset>>> getAssets(GetAssets request);

    /**
     * Sends {@link GetBalances} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<List<Balance>>> getBalances(GetBalances request);

    /**
     * Sends {@link GetGasPrices} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<GasPrices>> getGasPrices(GetGasPrices request);

    /**
     * Sends {@link GetPlatform} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Platform>> getPlatform(GetPlatform request);

    /**
     * Sends {@link GetProject} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Project>> getProject(GetProject request);

    /**
     * Sends {@link GetRequest} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> getRequest(GetRequest request);

    /**
     * Sends {@link GetRequests} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<List<Request>>> getRequests(GetRequests request);

}
