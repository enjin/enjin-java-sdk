package com.enjin.sdk.schemas.player;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.services.PlayerService;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.shared.SharedSchema;
import com.enjin.sdk.utils.LoggerProvider;

import java.io.IOException;

/**
 * Class for sending requests in the player schema.
 */
public class PlayerSchema extends SharedSchema {

    /**
     * The name of the schema.
     */
    public static final String SCHEMA = "player";

    private final PlayerService playerService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware the middleware
     * @param loggerProvider the logger provider
     */
    public PlayerSchema(TrustedPlatformMiddleware middleware, LoggerProvider loggerProvider) {
        super(middleware, SCHEMA, loggerProvider);
        playerService = (PlayerService) createService(PlayerService.class);
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

}
