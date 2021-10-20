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

package com.enjin.sdk.schemas.player;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.player.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.player.mutations.ApproveEnj;
import com.enjin.sdk.schemas.player.mutations.ApproveMaxEnj;
import com.enjin.sdk.schemas.player.mutations.BridgeAsset;
import com.enjin.sdk.schemas.player.mutations.BridgeAssets;
import com.enjin.sdk.schemas.player.mutations.BridgeClaimAsset;
import com.enjin.sdk.schemas.player.mutations.MeltAsset;
import com.enjin.sdk.schemas.player.mutations.Message;
import com.enjin.sdk.schemas.player.mutations.ResetEnjApproval;
import com.enjin.sdk.schemas.player.mutations.SendAsset;
import com.enjin.sdk.schemas.player.mutations.SendEnj;
import com.enjin.sdk.schemas.player.mutations.SetApprovalForAll;
import com.enjin.sdk.schemas.player.queries.GetWallet;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.shared.SharedSchema;
import com.enjin.sdk.services.WalletService;
import com.enjin.sdk.utils.LoggerProvider;

import java.util.concurrent.CompletableFuture;

/**
 * Class for sending requests in the player schema.
 */
public class PlayerSchema extends SharedSchema implements IPlayerSchema {

    /**
     * The name of the schema.
     */
    public static final String SCHEMA = "player";

    protected final PlayerService playerService;
    protected final WalletService walletService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware     the middleware
     * @param loggerProvider the logger provider
     */
    public PlayerSchema(TrustedPlatformMiddleware middleware, LoggerProvider loggerProvider) {
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
    public CompletableFuture<GraphQLResponse<Player>> getPlayer(GetPlayer request) {
        return sendRequest(playerService.getOne(schema, createRequestBody(request)));
    }

    @Override
    public CompletableFuture<GraphQLResponse<Wallet>> getWallet(GetWallet request) {
        return sendRequest(walletService.getOne(schema, createRequestBody(request)));
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
    public CompletableFuture<GraphQLResponse<Boolean>> unlinkWallet(UnlinkWallet request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

}
