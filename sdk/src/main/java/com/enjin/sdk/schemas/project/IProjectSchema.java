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

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.project.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.project.mutations.ApproveEnj;
import com.enjin.sdk.schemas.project.mutations.ApproveMaxEnj;
import com.enjin.sdk.schemas.project.mutations.BridgeAsset;
import com.enjin.sdk.schemas.project.mutations.BridgeAssets;
import com.enjin.sdk.schemas.project.mutations.BridgeClaimAsset;
import com.enjin.sdk.schemas.project.mutations.CompleteTrade;
import com.enjin.sdk.schemas.project.mutations.CreatePlayer;
import com.enjin.sdk.schemas.project.mutations.CreateAsset;
import com.enjin.sdk.schemas.project.mutations.CreateTrade;
import com.enjin.sdk.schemas.project.mutations.DecreaseMaxMeltFee;
import com.enjin.sdk.schemas.project.mutations.DecreaseMaxTransferFee;
import com.enjin.sdk.schemas.project.mutations.DeletePlayer;
import com.enjin.sdk.schemas.project.mutations.InvalidateAssetMetadata;
import com.enjin.sdk.schemas.project.mutations.MeltAsset;
import com.enjin.sdk.schemas.project.mutations.Message;
import com.enjin.sdk.schemas.project.mutations.MintAsset;
import com.enjin.sdk.schemas.project.mutations.ReleaseReserve;
import com.enjin.sdk.schemas.project.mutations.ResetEnjApproval;
import com.enjin.sdk.schemas.project.mutations.SendAsset;
import com.enjin.sdk.schemas.project.mutations.SendEnj;
import com.enjin.sdk.schemas.project.mutations.SetApprovalForAll;
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
import com.enjin.sdk.schemas.project.queries.GetWallet;
import com.enjin.sdk.schemas.project.queries.GetWallets;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Interface for project schema implementation.
 */
public interface IProjectSchema {

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
     * Sends {@link AuthPlayer} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<AccessToken>> authPlayer(AuthPlayer request);

    /**
     * Sends {@link AuthProject} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<AccessToken>> authProject(AuthProject request);

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
     * Sends {@link CompleteTrade} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> completeTrade(CompleteTrade request);

    /**
     * Sends {@link CreateAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> createAsset(CreateAsset request);

    /**
     * Sends {@link CreatePlayer} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<AccessToken>> createPlayer(CreatePlayer request);

    /**
     * Sends {@link CreateTrade} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> createTrade(CreateTrade request);

    /**
     * Sends {@link DecreaseMaxMeltFee} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> decreaseMaxMeltFee(DecreaseMaxMeltFee request);

    /**
     * Sends {@link DecreaseMaxTransferFee} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> decreaseMaxTransferFee(DecreaseMaxTransferFee request);

    /**
     * Sends {@link DeletePlayer} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Boolean>> deletePlayer(DeletePlayer request);

    /**
     * Sends {@link GetPlayer} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Player>> getPlayer(GetPlayer request);

    /**
     * Sends {@link GetPlayers} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<List<Player>>> getPlayers(GetPlayers request);

    /**
     * Sends {@link GetWallet} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Wallet>> getWallet(GetWallet request);

    /**
     * Sends {@link GetWallets} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<List<Wallet>>> getWallets(GetWallets request);

    /**
     * Sends {@link InvalidateAssetMetadata} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Boolean>> invalidateAssetMetadata(InvalidateAssetMetadata request);

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
     * Sends {@link MintAsset} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> mintAsset(MintAsset request);

    /**
     * Sends {@link ReleaseReserve} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> releaseReserve(ReleaseReserve request);

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
     * Sends {@link SetMeltFee} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> setMeltFee(SetMeltFee request);

    /**
     * Sends {@link SetTransferable} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> setTransferable(SetTransferable request);

    /**
     * Sends {@link SetTransferFee} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> setTransferFee(SetTransferFee request);

    /**
     * Sends {@link SetUri} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> setUri(SetUri request);

    /**
     * Sends {@link SetWhitelisted} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Request>> setWhitelisted(SetWhitelisted request);

    /**
     * Sends {@link UnlinkWallet} request to the platform.
     *
     * @param request the request
     *
     * @return the future for this operation
     */
    CompletableFuture<GraphQLResponse<Boolean>> unlinkWallet(UnlinkWallet request);

}
