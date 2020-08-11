package com.enjin.sdk.schemas;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Token;
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
import com.enjin.sdk.schemas.shared.mutations.AdvancedSendToken;
import com.enjin.sdk.schemas.shared.mutations.ApproveEnj;
import com.enjin.sdk.schemas.shared.mutations.ApproveMaxEnj;
import com.enjin.sdk.schemas.shared.mutations.CompleteTrade;
import com.enjin.sdk.schemas.shared.mutations.CreateTrade;
import com.enjin.sdk.schemas.shared.mutations.MeltToken;
import com.enjin.sdk.schemas.shared.mutations.Message;
import com.enjin.sdk.schemas.shared.mutations.ResetEnjApproval;
import com.enjin.sdk.schemas.shared.mutations.SendEnj;
import com.enjin.sdk.schemas.shared.mutations.SendToken;
import com.enjin.sdk.schemas.shared.mutations.SetApprovalForAll;
import com.enjin.sdk.schemas.shared.queries.GetBalances;
import com.enjin.sdk.schemas.shared.queries.GetGasPrices;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
import com.enjin.sdk.schemas.shared.queries.GetProject;
import com.enjin.sdk.schemas.shared.queries.GetRequest;
import com.enjin.sdk.schemas.shared.queries.GetRequests;
import com.enjin.sdk.schemas.shared.queries.GetToken;
import com.enjin.sdk.schemas.shared.queries.GetTokens;

import java.io.IOException;
import java.util.List;

/**
 * TODO
 */
public class Schema extends BaseSchema implements PlayerSchema, ProjectSchema {

    private final PlayerService playerService;
    private final ProjectService projectService;

    /**
     * TODO
     * @param middleware
     */
    public Schema(TrustedPlatformMiddleware middleware) {
        super(middleware);
        this.playerService = (PlayerService) createService(PlayerService.class);
        this.projectService = (ProjectService) createService(ProjectService.class);
    }

    @Override
    public GraphQLResponse<Request> advancedSendToken(AdvancedSendToken mutation) throws IOException {
        return null;
    }

    @Override
    public void advancedSendToken(AdvancedSendToken mutation,
                                  HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> approveEnj(ApproveEnj mutation) throws IOException {
        return null;
    }

    @Override
    public void approveEnj(ApproveEnj mutation,
                    HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj mutation) throws IOException {
        return null;
    }

    @Override
    public void approveMaxEnj(ApproveMaxEnj mutation,
                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<AccessToken> authPlayer(AuthPlayer query) throws IOException {
        return sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(query)));
    }

    @Override
    public void authPlayer(AuthPlayer query,
                           HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(query)), callback);
    }

    @Override
    public GraphQLResponse<AccessToken> authProject(AuthProject query) throws IOException {
        return sendRequest(projectService.getAuth(middleware.getSchema(), createRequestBody(query)));
    }

    @Override
    public void authProject(AuthProject query,
                            HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(projectService.getAuth(middleware.getSchema(), createRequestBody(query)), callback);
    }

    @Override
    public GraphQLResponse<Request> completeTrade(CompleteTrade mutation) throws IOException {
        return null;
    }

    @Override
    public void completeTrade(CompleteTrade mutation,
                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<AccessToken> createPlayer(CreatePlayer mutation) throws IOException {
        return sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(mutation)));
    }

    @Override
    public void createPlayer(CreatePlayer mutation,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(mutation)), callback);
    }

    @Override
    public GraphQLResponse<Request> createTrade(CreateTrade mutation) throws IOException {
        return null;
    }

    @Override
    public void createTrade(CreateTrade mutation,
                     HttpCallback<GraphQLResponse<Request>> callback) {

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
    public GraphQLResponse<List<Balance>> getBalances(GetBalances query) throws IOException {
        return null;
    }

    @Override
    public void getBalances(GetBalances query,
                     HttpCallback<GraphQLResponse<List<Balance>>> callback) {

    }

    @Override
    public GraphQLResponse<GasPrices> getGasPrices(GetGasPrices query) throws IOException {
        return null;
    }

    @Override
    public void getGasPrices(GetGasPrices query,
                      HttpCallback<GraphQLResponse<GasPrices>> callback) {

    }

    @Override
    public GraphQLResponse<Platform> getPlatform(GetPlatform query) throws IOException {
        return null;
    }

    @Override
    public void getPlatform(GetPlatform query,
                     HttpCallback<GraphQLResponse<Platform>> callback) {

    }

    @Override
    public GraphQLResponse<Player> getPlayer(GetPlayer query) throws IOException {
        return sendRequest(playerService.getOne(middleware.getSchema(), createRequestBody(query)));
    }

    @Override
    public void getPlayer(GetPlayer query,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(middleware.getSchema(), createRequestBody(query)), callback);
    }

    @Override
    public GraphQLResponse<List<Player>> getPlayers(GetPlayers query) throws IOException {
        return sendRequest(playerService.getMany(middleware.getSchema(), createRequestBody(query)));
    }

    @Override
    public void getPlayers(GetPlayers query,
                           HttpCallback<GraphQLResponse<List<Player>>> callback) {
        sendRequest(playerService.getMany(middleware.getSchema(), createRequestBody(query)), callback);
    }

    @Override
    public GraphQLResponse<Project> getProject(GetProject query) throws IOException {
        return null;
    }

    @Override
    public void getProject(GetProject query,
                    HttpCallback<GraphQLResponse<Project>> callback) {

    }

    @Override
    public GraphQLResponse<Request> getRequest(GetRequest query) throws IOException {
        return null;
    }

    @Override
    public void getRequest(GetRequest query,
                    HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<List<Request>> getRequests(GetRequests query) throws IOException {
        return null;
    }

    @Override
    public void getRequests(GetRequests query,
                     HttpCallback<GraphQLResponse<List<Request>>> callback) {

    }

    @Override
    public GraphQLResponse<Token> getToken(GetToken query) throws IOException {
        return null;
    }

    @Override
    public void getToken(GetToken query,
                  HttpCallback<GraphQLResponse<Token>> callback) {

    }

    @Override
    public GraphQLResponse<List<Token>> getTokens(GetTokens query) throws IOException {
        return null;
    }

    @Override
    public void getTokens(GetTokens query,
                   HttpCallback<GraphQLResponse<List<Token>>> callback) {

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
    public GraphQLResponse<Request> meltToken(MeltToken mutation) throws IOException {
        return null;
    }

    @Override
    public void meltToken(MeltToken mutation,
                   HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> message(Message mutation) throws IOException {
        return null;
    }

    @Override
    public void message(Message mutation,
                 HttpCallback<GraphQLResponse<Request>> callback) {

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
    public GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval mutation) throws IOException {
        return null;
    }

    @Override
    public void resetEnjApproval(ResetEnjApproval mutation,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> sendEnj(SendEnj mutation) throws IOException {
        return null;
    }

    @Override
    public void sendEnj(SendEnj mutation,
                 HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> sendToken(SendToken mutation) throws IOException {
        return null;
    }

    @Override
    public void sendToken(SendToken mutation,
                   HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll mutation) throws IOException {
        return null;
    }

    @Override
    public void setApprovalForAll(SetApprovalForAll mutation,
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
