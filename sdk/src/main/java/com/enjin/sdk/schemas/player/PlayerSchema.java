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
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Player> getPlayer(GetPlayer query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getPlayer(GetPlayer query, HttpCallback<GraphQLResponse<Player>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void unlinkWallet(UnlinkWallet mutation, HttpCallback<GraphQLResponse<Boolean>> callback);

}
