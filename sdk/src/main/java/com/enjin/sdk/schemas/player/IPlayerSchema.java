package com.enjin.sdk.schemas.player;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.player.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.player.mutations.ApproveEnj;
import com.enjin.sdk.schemas.player.mutations.ApproveMaxEnj;
import com.enjin.sdk.schemas.player.mutations.CompleteTrade;
import com.enjin.sdk.schemas.player.mutations.CreateTrade;
import com.enjin.sdk.schemas.player.mutations.MeltAsset;
import com.enjin.sdk.schemas.player.mutations.Message;
import com.enjin.sdk.schemas.player.mutations.ResetEnjApproval;
import com.enjin.sdk.schemas.player.mutations.SendAsset;
import com.enjin.sdk.schemas.player.mutations.SendEnj;
import com.enjin.sdk.schemas.player.mutations.SetApprovalForAll;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.player.queries.GetWallet;

/**
 * Interface for player schema implementation.
 */
public interface IPlayerSchema {

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
     * Sends the {@link GetWallet} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Wallet> getWallet(GetWallet request);

    /**
     * Sends the {@link GetWallet} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getWallet(GetWallet request,
                   HttpCallback<GraphQLResponse<Wallet>> callback);

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
