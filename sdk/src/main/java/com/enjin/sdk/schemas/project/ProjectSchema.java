package com.enjin.sdk.schemas.project;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.schemas.project.mutations.CreatePlayer;
import com.enjin.sdk.schemas.project.mutations.CreateToken;
import com.enjin.sdk.schemas.project.mutations.DecreaseMaxMeltFee;
import com.enjin.sdk.schemas.project.mutations.DecreaseMaxTransferFee;
import com.enjin.sdk.schemas.project.mutations.DeletePlayer;
import com.enjin.sdk.schemas.project.mutations.InvalidateTokenMetadata;
import com.enjin.sdk.schemas.project.mutations.MintToken;
import com.enjin.sdk.schemas.project.mutations.ReleaseReserve;
import com.enjin.sdk.schemas.project.mutations.SetMeltFee;
import com.enjin.sdk.schemas.project.mutations.SetTransferFee;
import com.enjin.sdk.schemas.project.mutations.SetTransferable;
import com.enjin.sdk.schemas.project.mutations.SetUri;
import com.enjin.sdk.schemas.project.mutations.SetWhitelisted;
import com.enjin.sdk.schemas.project.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.project.mutations.UpdateName;
import com.enjin.sdk.schemas.project.queries.AuthPlayer;
import com.enjin.sdk.schemas.project.queries.AuthProject;
import com.enjin.sdk.schemas.project.queries.GetPlayer;
import com.enjin.sdk.schemas.project.queries.GetPlayers;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.shared.SharedSchema;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;

import java.io.IOException;
import java.util.List;

/**
 * Class for sending requests in the project schema.
 */
public class ProjectSchema extends SharedSchema {

    /**
     * The name of the schema.
     */
    public static final String SCHEMA = "app";

    protected final PlayerService playerService;

    /**
     * Sole constructor.
     *
     * @param middleware the middleware
     */
    public ProjectSchema(TrustedPlatformMiddleware middleware) {
        super(middleware, SCHEMA);
        playerService = (PlayerService) createService(PlayerService.class);
    }

    /**
     * Sends {@link AuthPlayer} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<AccessToken> authPlayer(AuthPlayer request) {
        return sendRequest(playerService.getAuth(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link AuthPlayer} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void authPlayer(AuthPlayer request,
                           HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link AuthProject} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<AccessToken> authProject(AuthProject request) {
        return sendRequest(projectService.getAuth(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link AuthProject} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void authProject(AuthProject request,
                            HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(projectService.getAuth(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link CreatePlayer} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<AccessToken> createPlayer(CreatePlayer request) {
        return sendRequest(playerService.getAuth(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link CreatePlayer} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void createPlayer(CreatePlayer request,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link CreateToken} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> createToken(CreateToken request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link CreateToken} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void createToken(CreateToken request,
                            HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link DecreaseMaxMeltFee} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link DecreaseMaxMeltFee} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void decreaseMaxMeltFee(DecreaseMaxMeltFee request,
                                   HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link DecreaseMaxTransferFee} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link DecreaseMaxTransferFee} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void decreaseMaxTransferFee(DecreaseMaxTransferFee request,
                                       HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link DeletePlayer} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Boolean> deletePlayer(DeletePlayer request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link DeletePlayer} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void deletePlayer(DeletePlayer request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetPlayer} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Player> getPlayer(GetPlayer request) {
        return sendRequest(playerService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlayer} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getPlayer(GetPlayer request,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetPlayers} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<List<Player>> getPlayers(GetPlayers request) {
        return sendRequest(playerService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlayers} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getPlayers(GetPlayers request,
                           HttpCallback<GraphQLResponse<List<Player>>> callback) {
        sendRequest(playerService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link InvalidateTokenMetadata} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata request) {
        return sendRequest(projectService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link InvalidateTokenMetadata} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void invalidateTokenMetadata(InvalidateTokenMetadata request,
                                        HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(projectService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link MintToken} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> mintToken(MintToken request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link MintToken} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void mintToken(MintToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ReleaseReserve} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> releaseReserve(ReleaseReserve request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ReleaseReserve} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void releaseReserve(ReleaseReserve request,
                               HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetMeltFee} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> setMeltFee(SetMeltFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetMeltFee} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void setMeltFee(SetMeltFee request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetTransferable} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> setTransferable(SetTransferable request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetTransferable} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void setTransferable(SetTransferable request,
                                HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetTransferFee} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> setTransferFee(SetTransferFee request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetTransferFee} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void setTransferFee(SetTransferFee request,
                               HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetUri} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> setUri(SetUri request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetUri} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void setUri(SetUri request,
                       HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetWhitelisted} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> setWhitelisted(SetWhitelisted request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetWhitelisted} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void setWhitelisted(SetWhitelisted request,
                               HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link UnlinkWallet} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link UnlinkWallet} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void unlinkWallet(UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link UpdateName} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> updateName(UpdateName request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link UpdateName} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void updateName(UpdateName request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

}
