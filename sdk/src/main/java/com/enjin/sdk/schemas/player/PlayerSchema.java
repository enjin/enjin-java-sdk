package com.enjin.sdk.schemas.player;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.schemas.PlayerService;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.shared.SharedSchema;

import java.io.IOException;

/**
 * TODO
 */
public class PlayerSchema extends SharedSchema {

    /**
     * TODO
     */
    public static final String SCHEMA = "player";

    private final PlayerService playerService;

    /**
     * TODO
     * @param middleware
     */
    public PlayerSchema(TrustedPlatformMiddleware middleware) {
        super(middleware, SCHEMA);
        playerService = (PlayerService) createService(PlayerService.class);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Player> getPlayer(GetPlayer request) {
        return sendRequest(playerService.getOne(SCHEMA, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getPlayer(GetPlayer request,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(SCHEMA, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void unlinkWallet(UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

}
