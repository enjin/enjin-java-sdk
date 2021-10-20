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

package com.enjin.sdk.schemas.project;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.project.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.project.mutations.ApproveEnj;
import com.enjin.sdk.schemas.project.mutations.ApproveMaxEnj;
import com.enjin.sdk.schemas.project.mutations.BridgeAsset;
import com.enjin.sdk.schemas.project.mutations.BridgeAssets;
import com.enjin.sdk.schemas.project.mutations.BridgeClaimAsset;
import com.enjin.sdk.schemas.project.mutations.CompleteTrade;
import com.enjin.sdk.schemas.project.mutations.CreateTrade;
import com.enjin.sdk.schemas.project.mutations.MeltAsset;
import com.enjin.sdk.schemas.project.mutations.Message;
import com.enjin.sdk.schemas.project.mutations.ResetEnjApproval;
import com.enjin.sdk.schemas.project.mutations.SendAsset;
import com.enjin.sdk.schemas.project.mutations.SendEnj;
import com.enjin.sdk.schemas.project.mutations.SetApprovalForAll;
import com.enjin.sdk.schemas.project.queries.GetWallet;
import com.enjin.sdk.schemas.project.queries.GetWallets;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.schemas.project.mutations.CreatePlayer;
import com.enjin.sdk.schemas.project.mutations.CreateAsset;
import com.enjin.sdk.schemas.project.mutations.DecreaseMaxMeltFee;
import com.enjin.sdk.schemas.project.mutations.DecreaseMaxTransferFee;
import com.enjin.sdk.schemas.project.mutations.DeletePlayer;
import com.enjin.sdk.schemas.project.mutations.InvalidateAssetMetadata;
import com.enjin.sdk.schemas.project.mutations.MintAsset;
import com.enjin.sdk.schemas.project.mutations.ReleaseReserve;
import com.enjin.sdk.schemas.project.mutations.SetMeltFee;
import com.enjin.sdk.schemas.project.mutations.SetTransferFee;
import com.enjin.sdk.schemas.project.mutations.SetTransferable;
import com.enjin.sdk.schemas.project.mutations.SetUri;
import com.enjin.sdk.schemas.project.mutations.SetWhitelisted;
import com.enjin.sdk.schemas.project.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.project.queries.AuthPlayer;
import com.enjin.sdk.schemas.project.queries.AuthProject;
import com.enjin.sdk.schemas.project.queries.GetPlayer;
import com.enjin.sdk.schemas.project.queries.GetPlayers;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.shared.SharedSchema;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.services.WalletService;
import com.enjin.sdk.utils.LoggerProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Class for sending requests in the project schema.
 */
public class ProjectSchema extends SharedSchema implements IProjectSchema {

    /**
     * The name of the schema.
     */
    public static final String SCHEMA = "project";

    protected final PlayerService playerService;
    protected final WalletService walletService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware     the middleware
     * @param loggerProvider the logger provider
     */
    public ProjectSchema(TrustedPlatformMiddleware middleware, LoggerProvider loggerProvider) {
        super(middleware, SCHEMA, loggerProvider);
        playerService = (PlayerService) createService(PlayerService.class);
        walletService = (WalletService) createService(WalletService.class);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> advancedSendAsset(AdvancedSendAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> approveEnj(ApproveEnj request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> approveMaxEnj(ApproveMaxEnj request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<AccessToken>> authPlayer(AuthPlayer request) {
        return sendRequest(playerService.getAuth(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<AccessToken>> authProject(AuthProject request) {
        return sendRequest(projectService.getAuth(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> bridgeAsset(BridgeAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> bridgeAssets(BridgeAssets request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> bridgeClaimAsset(BridgeClaimAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> completeTrade(CompleteTrade request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> createAsset(CreateAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<AccessToken>> createPlayer(CreatePlayer request) {
        return sendRequest(playerService.getAuth(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> createTrade(CreateTrade request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> decreaseMaxMeltFee(DecreaseMaxMeltFee request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> decreaseMaxTransferFee(DecreaseMaxTransferFee request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Boolean>> deletePlayer(DeletePlayer request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Player>> getPlayer(GetPlayer request) {
        return sendRequest(playerService.getOne(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<List<Player>>> getPlayers(GetPlayers request) {
        return sendRequest(playerService.getMany(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Wallet>> getWallet(GetWallet request) {
        return sendRequest(walletService.getOne(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<List<Wallet>>> getWallets(GetWallets request) {
        return sendRequest(walletService.getMany(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Boolean>> invalidateAssetMetadata(InvalidateAssetMetadata request) {
        return sendRequest(projectService.delete(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> meltAsset(MeltAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> message(Message request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> mintAsset(MintAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> releaseReserve(ReleaseReserve request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> resetEnjApproval(ResetEnjApproval request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> sendAsset(SendAsset request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> sendEnj(SendEnj request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> setApprovalForAll(SetApprovalForAll request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> setMeltFee(SetMeltFee request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> setTransferable(SetTransferable request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> setTransferFee(SetTransferFee request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> setUri(SetUri request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Request>> setWhitelisted(SetWhitelisted request) {
        return transactionRequest(request);
    }

    @Override
    public CompletableFuture<GraphQLResponse<Boolean>> unlinkWallet(UnlinkWallet request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

}
