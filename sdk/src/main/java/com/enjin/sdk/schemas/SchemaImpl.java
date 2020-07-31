package com.enjin.sdk.schemas;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.schemas.player.PlayerSchema;
import com.enjin.sdk.schemas.project.ProjectSchema;
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
import com.enjin.sdk.models.Player;
import com.enjin.sdk.models.Request;

import java.io.IOException;
import java.util.Collection;

/**
 * TODO
 */
public class SchemaImpl extends BaseService implements PlayerSchema, ProjectSchema {

    private final PlayerService playerService;
    private final ProjectService projectService;

    /**
     * TODO
     * @param middleware
     */
    public SchemaImpl(TrustedPlatformMiddleware middleware) {
        super(middleware);
        this.playerService = (PlayerService) createService(PlayerService.class);
        this.projectService = (ProjectService) createService(ProjectService.class);
    }

    @Override
    public GraphQLResponse<AccessToken> authPlayer(AuthPlayer query) throws IOException {
        return sendRequest(playerService.getAuth(createRequestBody(query, "")));
    }

    @Override
    public void authPlayer(AuthPlayer query,
                           HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(createRequestBody(query, "")), callback);
    }

    @Override
    public GraphQLResponse<AccessToken> authProject(AuthProject query) throws IOException {
        return sendRequest(projectService.getAuth(createRequestBody(query, "")));
    }

    @Override
    public void authProject(AuthProject query,
                            HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(projectService.getAuth(createRequestBody(query, "")), callback);
    }

    @Override
    public GraphQLResponse<AccessToken> createPlayer(CreatePlayer mutation) throws IOException {
        return sendRequest(playerService.getAuth(createRequestBody(mutation, "")));
    }

    @Override
    public void createPlayer(CreatePlayer mutation,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(createRequestBody(mutation, "")), callback);
    }

    @Override
    public GraphQLResponse<Request> createToken(CreateToken mutation) throws IOException {
        return null;
    }

    @Override
    public void createToken(CreateToken mutation,
                            HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee mutation) throws IOException {
        return null;
    }

    @Override
    public void decreaseMaxMeltFee(DecreaseMaxMeltFee mutation,
                                   HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee mutation) throws IOException {
        return null;
    }

    @Override
    public void decreaseMaxTransferFee(DecreaseMaxTransferFee mutation,
                                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Boolean> deletePlayer(DeletePlayer mutation) throws IOException {
        return null;
    }

    @Override
    public void deletePlayer(DeletePlayer mutation,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<Player> getPlayer(GetPlayer query) throws IOException {
        return sendRequest(playerService.getOne(createRequestBody(query, "")));
    }

    @Override
    public void getPlayer(GetPlayer query,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(createRequestBody(query, "")), callback);
    }

    @Override
    public GraphQLResponse<Collection<Player>> getPlayers(GetPlayers query) throws IOException {
        return sendRequest(playerService.getMany(createRequestBody(query, "")));
    }

    @Override
    public void getPlayers(GetPlayers query,
                           HttpCallback<GraphQLResponse<Collection<Player>>> callback) {
        sendRequest(playerService.getMany(createRequestBody(query, "")), callback);
    }

    @Override
    public GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata mutation) throws IOException {
        return null;
    }

    @Override
    public void invalidateTokenMetadata(InvalidateTokenMetadata mutation,
                                        HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<Request> mintToken(MintToken mutation) throws IOException {
        return null;
    }

    @Override
    public void mintToken(MintToken mutation,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> releaseReserve(ReleaseReserve mutation) throws IOException {
        return null;
    }

    @Override
    public void releaseReserve(ReleaseReserve mutation,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setMeltFee(SetMeltFee mutation) throws IOException {
        return null;
    }

    @Override
    public void setMeltFee(SetMeltFee mutation,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setTransferable(SetTransferable mutation) throws IOException {
        return null;
    }

    @Override
    public void setTransferable(SetTransferable mutation,
                                HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setTransferFee(SetTransferFee mutation) throws IOException {
        return null;
    }

    @Override
    public void setTransferFee(SetTransferFee mutation,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setUri(SetUri mutation) throws IOException {
        return null;
    }

    @Override
    public void setUri(SetUri mutation,
                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setWhitelisted(SetWhitelisted mutation) throws IOException {
        return null;
    }

    @Override
    public void setWhitelisted(SetWhitelisted mutation,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet mutation) throws IOException {
        return null;
    }

    @Override
    public void unlinkWallet(UnlinkWallet mutation,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<Request> updateName(UpdateName mutation) throws IOException {
        return null;
    }

    @Override
    public void updateName(UpdateName mutation,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }
}
