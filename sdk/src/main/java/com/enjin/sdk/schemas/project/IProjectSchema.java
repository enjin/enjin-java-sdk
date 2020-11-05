package com.enjin.sdk.schemas.project;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Wallet;
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
     * Sends {@link CreateToken} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> createToken(CreateToken request);

    /**
     * Sends {@link CreateToken} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void createToken(CreateToken request,
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
     * Sends {@link InvalidateTokenMetadata} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata request);

    /**
     * Sends {@link InvalidateTokenMetadata} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void invalidateTokenMetadata(InvalidateTokenMetadata request,
                                 HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * Sends {@link MintToken} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> mintToken(MintToken request);

    /**
     * Sends {@link MintToken} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void mintToken(MintToken request,
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
