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

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.project.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.project.mutations.ApproveEnj;
import com.enjin.sdk.schemas.project.mutations.ApproveMaxEnj;
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

import java.io.IOException;
import java.util.List;

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

    /**
     * Sends {@link AdvancedSendAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> advancedSendAsset(AdvancedSendAsset request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link AdvancedSendAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void advancedSendAsset(AdvancedSendAsset request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ApproveEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> approveEnj(ApproveEnj request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ApproveEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void approveEnj(ApproveEnj request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ApproveMaxEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ApproveMaxEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void approveMaxEnj(ApproveMaxEnj request,
                              HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link AuthPlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<AccessToken> authPlayer(AuthPlayer request) {
        return sendRequest(playerService.getAuth(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link AuthPlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void authPlayer(AuthPlayer request,
                           HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link AuthProject} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<AccessToken> authProject(AuthProject request) {
        return sendRequest(projectService.getAuth(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link AuthProject} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void authProject(AuthProject request,
                            HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(projectService.getAuth(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link CompleteTrade} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> completeTrade(CompleteTrade request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link CompleteTrade} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void completeTrade(CompleteTrade request,
                              HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link CreateAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> createAsset(CreateAsset request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link CreateAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void createAsset(CreateAsset request,
                            HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link CreatePlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<AccessToken> createPlayer(CreatePlayer request) {
        return sendRequest(playerService.getAuth(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link CreatePlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void createPlayer(CreatePlayer request,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link CreateTrade} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> createTrade(CreateTrade request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link CreateTrade} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void createTrade(CreateTrade request,
                            HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link DecreaseMaxMeltFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link DecreaseMaxMeltFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void decreaseMaxMeltFee(DecreaseMaxMeltFee request,
                                   HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link DecreaseMaxTransferFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link DecreaseMaxTransferFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void decreaseMaxTransferFee(DecreaseMaxTransferFee request,
                                       HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link DeletePlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Boolean> deletePlayer(DeletePlayer request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link DeletePlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void deletePlayer(DeletePlayer request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetPlayer} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Player> getPlayer(GetPlayer request) {
        return sendRequest(playerService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlayer} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getPlayer(GetPlayer request,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetPlayers} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<List<Player>> getPlayers(GetPlayers request) {
        return sendRequest(playerService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlayers} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getPlayers(GetPlayers request,
                           HttpCallback<GraphQLResponse<List<Player>>> callback) {
        sendRequest(playerService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetWallet} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Wallet> getWallet(GetWallet request) {
        return sendRequest(walletService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetWallet} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getWallet(GetWallet request,
                          HttpCallback<GraphQLResponse<Wallet>> callback) {
        sendRequest(walletService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetWallets} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<List<Wallet>> getWallets(GetWallets request) {
        return sendRequest(walletService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetWallets} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getWallets(GetWallets request,
                           HttpCallback<GraphQLResponse<List<Wallet>>> callback) {
        sendRequest(walletService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link InvalidateAssetMetadata} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Boolean> invalidateAssetMetadata(InvalidateAssetMetadata request) {
        return sendRequest(projectService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link InvalidateAssetMetadata} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void invalidateAssetMetadata(InvalidateAssetMetadata request,
                                        HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(projectService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link MeltAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> meltAsset(MeltAsset request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link MeltAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void meltAsset(MeltAsset request,
                          HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link Message} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> message(Message request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link Message} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void message(Message request,
                        HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link MintAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> mintAsset(MintAsset request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link MintAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void mintAsset(MintAsset request,
                          HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ReleaseReserve} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> releaseReserve(ReleaseReserve request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ReleaseReserve} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void releaseReserve(ReleaseReserve request,
                               HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ResetEnjApproval} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ResetEnjApproval} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void resetEnjApproval(ResetEnjApproval request,
                                 HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SendAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> sendAsset(SendAsset request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SendAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void sendAsset(SendAsset request,
                          HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SendEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> sendEnj(SendEnj request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SendEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void sendEnj(SendEnj request,
                        HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetApprovalForAll} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetApprovalForAll} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void setApprovalForAll(SetApprovalForAll request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetMeltFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> setMeltFee(SetMeltFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetMeltFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void setMeltFee(SetMeltFee request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetTransferable} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> setTransferable(SetTransferable request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetTransferable} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void setTransferable(SetTransferable request,
                                HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetTransferFee} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> setTransferFee(SetTransferFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetTransferFee} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void setTransferFee(SetTransferFee request,
                               HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetUri} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> setUri(SetUri request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetUri} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void setUri(SetUri request,
                       HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetWhitelisted} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> setWhitelisted(SetWhitelisted request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetWhitelisted} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void setWhitelisted(SetWhitelisted request,
                               HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link UnlinkWallet} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link UnlinkWallet} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void unlinkWallet(UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
    }

}
