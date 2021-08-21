package com.enjin.sdk.schemas.player;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.player.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.player.mutations.ApproveEnj;
import com.enjin.sdk.schemas.player.mutations.ApproveMaxEnj;
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

import java.io.IOException;

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
     * Sends the {@link GetWallet} request synchronously.
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
     * Sends the {@link GetWallet} request asynchronously.
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
