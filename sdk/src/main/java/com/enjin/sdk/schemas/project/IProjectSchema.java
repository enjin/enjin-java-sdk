/* Copyright 2021 Enjin Pte Ltd.
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
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.project.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.project.mutations.ApproveEnj;
import com.enjin.sdk.schemas.project.mutations.ApproveMaxEnj;
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

/**
 * Interface for project schema implementation.
 */
public interface IProjectSchema {

    /**
     * Sends {@link AdvancedSendAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> advancedSendAsset(AdvancedSendAsset request);

    /**
     * Sends {@link AdvancedSendAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void advancedSendAsset(AdvancedSendAsset request,
                           HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ApproveEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> approveEnj(ApproveEnj request);

    /**
     * Sends {@link ApproveEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void approveEnj(ApproveEnj request,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ApproveMaxEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request);

    /**
     * Sends {@link ApproveMaxEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void approveMaxEnj(ApproveMaxEnj request,
                       HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link AuthPlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<AccessToken> authPlayer(AuthPlayer request);

    /**
     * Sends {@link AuthPlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void authPlayer(AuthPlayer request,
                    HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * Sends {@link AuthProject} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<AccessToken> authProject(AuthProject request);

    /**
     * Sends {@link AuthProject} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void authProject(AuthProject request,
                     HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * Sends {@link CompleteTrade} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> completeTrade(CompleteTrade request);

    /**
     * Sends {@link CompleteTrade} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void completeTrade(CompleteTrade request,
                       HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link CreateAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> createAsset(CreateAsset request);

    /**
     * Sends {@link CreateAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void createAsset(CreateAsset request,
                     HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link CreatePlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<AccessToken> createPlayer(CreatePlayer request);

    /**
     * Sends {@link CreatePlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void createPlayer(CreatePlayer request,
                      HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * Sends {@link CreateTrade} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> createTrade(CreateTrade request);

    /**
     * Sends {@link CreateTrade} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void createTrade(CreateTrade request,
                     HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link DecreaseMaxMeltFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee request);

    /**
     * Sends {@link DecreaseMaxMeltFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void decreaseMaxMeltFee(DecreaseMaxMeltFee request,
                            HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link DecreaseMaxTransferFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee request);

    /**
     * Sends {@link DecreaseMaxTransferFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void decreaseMaxTransferFee(DecreaseMaxTransferFee request,
                                HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link DeletePlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Boolean> deletePlayer(DeletePlayer request);

    /**
     * Sends {@link DeletePlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void deletePlayer(DeletePlayer request,
                      HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * Sends {@link GetPlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Player> getPlayer(GetPlayer request);

    /**
     * Sends {@link GetPlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getPlayer(GetPlayer request,
                   HttpCallback<GraphQLResponse<Player>> callback);

    /**
     * Sends {@link GetPlayers} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Player>> getPlayers(GetPlayers request);

    /**
     * Sends {@link GetPlayers} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getPlayers(GetPlayers request,
                    HttpCallback<GraphQLResponse<List<Player>>> callback);

    /**
     * Sends {@link GetWallet} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Wallet> getWallet(GetWallet request);

    /**
     * Sends {@link GetWallet} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getWallet(GetWallet request,
                   HttpCallback<GraphQLResponse<Wallet>> callback);

    /**
     * Sends {@link GetWallets} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Wallet>> getWallets(GetWallets request);

    /**
     * Sends {@link GetWallets} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getWallets(GetWallets request,
                    HttpCallback<GraphQLResponse<List<Wallet>>> callback);

    /**
     * Sends {@link InvalidateAssetMetadata} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Boolean> invalidateAssetMetadata(InvalidateAssetMetadata request);

    /**
     * Sends {@link InvalidateAssetMetadata} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void invalidateAssetMetadata(InvalidateAssetMetadata request,
                                 HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * Sends {@link MeltAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> meltAsset(MeltAsset request);

    /**
     * Sends {@link MeltAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void meltAsset(MeltAsset request,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link Message} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> message(Message request);

    /**
     * Sends {@link Message} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void message(Message request,
                 HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link MintAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> mintAsset(MintAsset request);

    /**
     * Sends {@link MintAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void mintAsset(MintAsset request,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ReleaseReserve} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> releaseReserve(ReleaseReserve request);

    /**
     * Sends {@link ReleaseReserve} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void releaseReserve(ReleaseReserve request,
                        HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ResetEnjApproval} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request);

    /**
     * Sends {@link ResetEnjApproval} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void resetEnjApproval(ResetEnjApproval request,
                          HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SendAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> sendAsset(SendAsset request);

    /**
     * Sends {@link SendAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void sendAsset(SendAsset request,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SendEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> sendEnj(SendEnj request);

    /**
     * Sends {@link SendEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void sendEnj(SendEnj request,
                 HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetApprovalForAll} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request);

    /**
     * Sends {@link SetApprovalForAll} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setApprovalForAll(SetApprovalForAll request,
                           HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetMeltFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setMeltFee(SetMeltFee request);

    /**
     * Sends {@link SetMeltFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setMeltFee(SetMeltFee request,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetTransferable} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setTransferable(SetTransferable request);

    /**
     * Sends {@link SetTransferable} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setTransferable(SetTransferable request,
                         HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetTransferFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setTransferFee(SetTransferFee request);

    /**
     * Sends {@link SetTransferFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setTransferFee(SetTransferFee request,
                        HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetUri} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setUri(SetUri request);

    /**
     * Sends {@link SetUri} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setUri(SetUri request,
                HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetWhitelisted} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setWhitelisted(SetWhitelisted request);

    /**
     * Sends {@link SetWhitelisted} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setWhitelisted(SetWhitelisted request,
                        HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link UnlinkWallet} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request);

    /**
     * Sends {@link UnlinkWallet} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void unlinkWallet(UnlinkWallet request,
                      HttpCallback<GraphQLResponse<Boolean>> callback);

}
