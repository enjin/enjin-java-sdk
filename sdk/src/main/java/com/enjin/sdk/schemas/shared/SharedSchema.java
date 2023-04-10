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

import com.enjin.sdk.ClientMiddleware;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Transaction;
import com.enjin.sdk.models.Asset;
import com.enjin.sdk.schemas.shared.mutations.CancelTransaction;
import com.enjin.sdk.schemas.shared.queries.GetBalancesFromProjects;
import com.enjin.sdk.services.BalanceService;
import com.enjin.sdk.schemas.BaseSchema;
import com.enjin.sdk.services.PlatformService;
import com.enjin.sdk.services.ProjectService;
import com.enjin.sdk.services.TransactionService;
import com.enjin.sdk.services.AssetService;
import com.enjin.sdk.schemas.shared.queries.GetBalances;
import com.enjin.sdk.schemas.shared.queries.GetGasPrices;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
import com.enjin.sdk.schemas.shared.queries.GetProject;
import com.enjin.sdk.schemas.shared.queries.GetTransaction;
import com.enjin.sdk.schemas.shared.queries.GetTransactions;
import com.enjin.sdk.schemas.shared.queries.GetAsset;
import com.enjin.sdk.schemas.shared.queries.GetAssets;
import com.enjin.sdk.utils.LoggerProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Class for sending requests shared across schemas.
 */
public class SharedSchema extends BaseSchema implements ISharedSchema {

    protected final BalanceService balanceService;
    protected final PlatformService platformService;
    protected final ProjectService projectService;
    protected final TransactionService transactionService;
    protected final AssetService assetService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware     the middleware
     * @param schema         the schema
     * @param loggerProvider the logger provider
     */
    public SharedSchema(ClientMiddleware middleware, String schema, LoggerProvider loggerProvider) {
        super(middleware, schema, loggerProvider);
        balanceService = (BalanceService) createService(BalanceService.class);
        platformService = (PlatformService) createService(PlatformService.class);
        projectService = (ProjectService) createService(ProjectService.class);
        transactionService = (TransactionService) createService(TransactionService.class);
        assetService = (AssetService) createService(AssetService.class);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Boolean>> cancelTransaction(CancelTransaction request) {
        return sendRequest(transactionService.delete(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Asset>> getAsset(GetAsset request) {
        return sendRequest(assetService.getOne(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<List<Asset>>> getAssets(GetAssets request) {
        return sendRequest(assetService.getMany(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<List<Balance>>> getBalances(GetBalances request) {
        return sendRequest(balanceService.getMany(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<List<Balance>>> getBalancesFromProjects(GetBalancesFromProjects request) {
        return sendRequest(balanceService.getMany(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<GasPrices>> getGasPrices(GetGasPrices request) {
        return sendRequest(platformService.getGasPrices(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Platform>> getPlatform(GetPlatform request) {
        return sendRequest(platformService.getOne(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Project>> getProject(GetProject request) {
        return sendRequest(projectService.getOne(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Transaction>> getRequest(GetTransaction request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<List<Transaction>>> getRequests(GetTransactions request) {
        return sendRequest(transactionService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Helper method for sending transaction requests.
     *
     * @param request the request
     * @param <T>     the type of the request
     *
     * @return the future for the request
     */
    protected <T extends GraphQLRequest<T>> CompletableFuture<GraphQLResponse<Transaction>> transactionRequest(
            GraphQLRequest<T> request) {
        return sendRequest(transactionService.getOne(schema, createRequestBody(request)));
    }

}
