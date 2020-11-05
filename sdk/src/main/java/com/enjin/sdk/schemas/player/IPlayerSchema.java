package com.enjin.sdk.schemas.player;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Wallet;
import com.enjin.sdk.schemas.player.mutations.UnlinkWallet;
import com.enjin.sdk.schemas.player.queries.GetPlayer;
import com.enjin.sdk.schemas.player.queries.GetWallet;

/**
 * Interface for player schema implementation.
 */
public interface IPlayerSchema {

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
