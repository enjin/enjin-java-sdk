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
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.player.queries.GetWallet;

import java.util.concurrent.CompletableFuture;

/**
 * Interface for player schema implementation.
 */
public interface IPlayerSchema {

    /**
     * Sends {@link AdvancedSendAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> advancedSendAsset(AdvancedSendAsset request);

    /**
     * Sends {@link ApproveEnj} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> approveEnj(ApproveEnj request);

    /**
     * Sends {@link ApproveMaxEnj} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> approveMaxEnj(ApproveMaxEnj request);

    /**
     * Sends {@link BridgeAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> bridgeAsset(BridgeAsset request);

    /**
     * Sends {@link BridgeAssets} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> bridgeAssets(BridgeAssets request);

    /**
     * Sends {@link BridgeClaimAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> bridgeClaimAsset(BridgeClaimAsset request);

    /**
     * Sends {@link GetPlayer} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Player>> getPlayer(GetPlayer request);

    /**
     * Sends {@link GetWallet} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Wallet>> getWallet(GetWallet request);

    /**
     * Sends {@link MeltAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> meltAsset(MeltAsset request);

    /**
     * Sends {@link Message} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> message(Message request);

    /**
     * Sends {@link ResetEnjApproval} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> resetEnjApproval(ResetEnjApproval request);

    /**
     * Sends {@link SendAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> sendAsset(SendAsset request);

    /**
     * Sends {@link SendEnj} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> sendEnj(SendEnj request);

    /**
     * Sends {@link SetApprovalForAll} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> setApprovalForAll(SetApprovalForAll request);

    /**
     * Sends {@link UnlinkWallet} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Boolean>> unlinkWallet(UnlinkWallet request);

}
