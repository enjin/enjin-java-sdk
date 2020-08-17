package com.enjin.sdk.schemas.project;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.schemas.PlayerService;
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
 * TODO
 */
public class ProjectSchema extends SharedSchema {

    /**
     * TODO
     */
    public static final String SCHEMA = "app";

    protected final PlayerService playerService;

    /**
     * TODO
     * @param middleware
     */
    public ProjectSchema(TrustedPlatformMiddleware middleware) {
        super(middleware, SCHEMA);
        playerService = (PlayerService) createService(PlayerService.class);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<AccessToken> authPlayer(AuthPlayer request) {
        return sendRequest(playerService.getAuth(SCHEMA, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void authPlayer(AuthPlayer request,
                           HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(SCHEMA, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<AccessToken> authProject(AuthProject request) {
        return sendRequest(projectService.getAuth(SCHEMA, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void authProject(AuthProject request,
                            HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(projectService.getAuth(SCHEMA, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<AccessToken> createPlayer(CreatePlayer request) {
        return sendRequest(playerService.getAuth(SCHEMA, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void createPlayer(CreatePlayer request,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(SCHEMA, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> createToken(CreateToken request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void createToken(CreateToken request,
                            HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void decreaseMaxMeltFee(DecreaseMaxMeltFee request,
                                   HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void decreaseMaxTransferFee(DecreaseMaxTransferFee request,
                                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Boolean> deletePlayer(DeletePlayer request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void deletePlayer(DeletePlayer request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
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
    public GraphQLResponse<List<Player>> getPlayers(GetPlayers request) {
        return sendRequest(playerService.getMany(SCHEMA, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getPlayers(GetPlayers request,
                           HttpCallback<GraphQLResponse<List<Player>>> callback) {
        sendRequest(playerService.getMany(SCHEMA, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void invalidateTokenMetadata(InvalidateTokenMetadata request,
                                        HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> mintToken(MintToken request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void mintToken(MintToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> releaseReserve(ReleaseReserve request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void releaseReserve(ReleaseReserve request,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> setMeltFee(SetMeltFee request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void setMeltFee(SetMeltFee request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> setTransferable(SetTransferable request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void setTransferable(SetTransferable request,
                                HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> setTransferFee(SetTransferFee request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void setTransferFee(SetTransferFee request,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> setUri(SetUri request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void setUri(SetUri request,
                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> setWhitelisted(SetWhitelisted request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void setWhitelisted(SetWhitelisted request,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request) {
        return sendRequest(playerService.delete(schema, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void unlinkWallet(UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(playerService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> updateName(UpdateName request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void updateName(UpdateName request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

}
