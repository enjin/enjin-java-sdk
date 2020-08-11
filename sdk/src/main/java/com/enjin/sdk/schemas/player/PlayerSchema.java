package com.enjin.sdk.schemas.player;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.shared.SharedSchema;

import java.io.IOException;

/**
 * TODO
 */
public interface PlayerSchema extends SharedSchema {

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Player> getPlayer(GetPlayer request) throws IOException;

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getPlayer(GetPlayer request, HttpCallback<GraphQLResponse<Player>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request) throws IOException;

    /**
     * TODO
     * @param request
     * @param callback
     */
    void unlinkWallet(UnlinkWallet request, HttpCallback<GraphQLResponse<Boolean>> callback);

}
