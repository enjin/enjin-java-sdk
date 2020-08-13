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
import com.enjin.sdk.schemas.project.mutations.UpdateName;
import com.enjin.sdk.schemas.project.queries.AuthPlayer;
import com.enjin.sdk.schemas.project.queries.AuthProject;
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
    public GraphQLResponse<Request> advancedSendToken(AdvancedSendToken request) {
        return null;
    }

    @Override
    public void advancedSendToken(AdvancedSendToken request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> approveEnj(ApproveEnj request) {
        return null;
    }

    @Override
    public void approveEnj(ApproveEnj request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request) {
        return null;
    }

    @Override
    public void approveMaxEnj(ApproveMaxEnj request,
                              HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<AccessToken> authPlayer(AuthPlayer request) {
        return sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(request)));
    }

    @Override
    public void authPlayer(AuthPlayer request,
                           HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(request)), callback);
    }

    @Override
    public GraphQLResponse<AccessToken> authProject(AuthProject request) {
        return sendRequest(projectService.getAuth(middleware.getSchema(), createRequestBody(request)));
    }

    @Override
    public void authProject(AuthProject request,
                            HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(projectService.getAuth(middleware.getSchema(), createRequestBody(request)), callback);
    }

    @Override
    public GraphQLResponse<Request> completeTrade(CompleteTrade request) {
        return null;
    }

    @Override
    public void completeTrade(CompleteTrade request,
                              HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<AccessToken> createPlayer(CreatePlayer request) {
        return sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(request)));
    }

    @Override
    public void createPlayer(CreatePlayer request,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        sendRequest(playerService.getAuth(middleware.getSchema(), createRequestBody(request)), callback);
    }

    @Override
    public GraphQLResponse<Request> createTrade(CreateTrade request) {
        return null;
    }

    @Override
    public void createTrade(CreateTrade request,
                            HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> createToken(CreateToken request) {
        return null;
    }

    @Override
    public void createToken(CreateToken request,
                            HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee request) {
        return null;
    }

    @Override
    public void decreaseMaxMeltFee(DecreaseMaxMeltFee request,
                                   HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee request) {
        return null;
    }

    @Override
    public void decreaseMaxTransferFee(DecreaseMaxTransferFee request,
                                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Boolean> deletePlayer(DeletePlayer request) {
        return null;
    }

    @Override
    public void deletePlayer(DeletePlayer request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<List<Balance>> getBalances(GetBalances request) {
        return null;
    }

    @Override
    public void getBalances(GetBalances request,
                            HttpCallback<GraphQLResponse<List<Balance>>> callback) {

    }

    @Override
    public GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request) {
        return null;
    }

    @Override
    public void getGasPrices(GetGasPrices request,
                             HttpCallback<GraphQLResponse<GasPrices>> callback) {

    }

    @Override
    public GraphQLResponse<Platform> getPlatform(GetPlatform request) {
        return null;
    }

    @Override
    public void getPlatform(GetPlatform request,
                            HttpCallback<GraphQLResponse<Platform>> callback) {

    }

    @Override
    public GraphQLResponse<Player> getPlayer(com.enjin.sdk.schemas.player.queries.GetPlayer request) {
        return null;
    }

    @Override
    public void getPlayer(com.enjin.sdk.schemas.player.queries.GetPlayer request,
                          HttpCallback<GraphQLResponse<Player>> callback) {

    }

    @Override
    public GraphQLResponse<Player> getPlayer(com.enjin.sdk.schemas.project.queries.GetPlayer request) {
        return sendRequest(playerService.getOne(middleware.getSchema(), createRequestBody(request)));
    }

    @Override
    public void getPlayer(com.enjin.sdk.schemas.project.queries.GetPlayer request,
                          HttpCallback<GraphQLResponse<Player>> callback) {
        sendRequest(playerService.getOne(middleware.getSchema(), createRequestBody(request)), callback);
    }

    @Override
    public GraphQLResponse<List<Player>> getPlayers(GetPlayers request) {
        return sendRequest(playerService.getMany(middleware.getSchema(), createRequestBody(request)));
    }

    @Override
    public void getPlayers(GetPlayers request,
                           HttpCallback<GraphQLResponse<List<Player>>> callback) {
        sendRequest(playerService.getMany(middleware.getSchema(), createRequestBody(request)), callback);
    }

    @Override
    public GraphQLResponse<Project> getProject(GetProject request) {
        return null;
    }

    @Override
    public void getProject(GetProject request,
                           HttpCallback<GraphQLResponse<Project>> callback) {

    }

    @Override
    public GraphQLResponse<Request> getRequest(GetRequest request) {
        return null;
    }

    @Override
    public void getRequest(GetRequest request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<List<Request>> getRequests(GetRequests request) {
        return null;
    }

    @Override
    public void getRequests(GetRequests request,
                            HttpCallback<GraphQLResponse<List<Request>>> callback) {

    }

    @Override
    public GraphQLResponse<Token> getToken(GetToken request) {
        return null;
    }

    @Override
    public void getToken(GetToken request,
                         HttpCallback<GraphQLResponse<Token>> callback) {

    }

    @Override
    public GraphQLResponse<List<Token>> getTokens(GetTokens request) {
        return null;
    }

    @Override
    public void getTokens(GetTokens request,
                          HttpCallback<GraphQLResponse<List<Token>>> callback) {

    }

    @Override
    public GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata request) {
        return null;
    }

    @Override
    public void invalidateTokenMetadata(InvalidateTokenMetadata request,
                                        HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<Request> meltToken(MeltToken request) {
        return null;
    }

    @Override
    public void meltToken(MeltToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> message(Message request) {
        return null;
    }

    @Override
    public void message(Message request,
                        HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> mintToken(MintToken request) {
        return null;
    }

    @Override
    public void mintToken(MintToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> releaseReserve(ReleaseReserve request) {
        return null;
    }

    @Override
    public void releaseReserve(ReleaseReserve request,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request) {
        return null;
    }

    @Override
    public void resetEnjApproval(ResetEnjApproval request,
                                 HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> sendEnj(SendEnj request) {
        return null;
    }

    @Override
    public void sendEnj(SendEnj request,
                        HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> sendToken(SendToken request) {
        return null;
    }

    @Override
    public void sendToken(SendToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request) {
        return null;
    }

    @Override
    public void setApprovalForAll(SetApprovalForAll request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setMeltFee(SetMeltFee request) {
        return null;
    }

    @Override
    public void setMeltFee(SetMeltFee request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setTransferable(SetTransferable request) {
        return null;
    }

    @Override
    public void setTransferable(SetTransferable request,
                                HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setTransferFee(SetTransferFee request) {
        return null;
    }

    @Override
    public void setTransferFee(SetTransferFee request,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setUri(SetUri request) {
        return null;
    }

    @Override
    public void setUri(SetUri request,
                       HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Request> setWhitelisted(SetWhitelisted request) {
        return null;
    }

    @Override
    public void setWhitelisted(SetWhitelisted request,
                               HttpCallback<GraphQLResponse<Request>> callback) {

    }

    @Override
    public GraphQLResponse<Boolean> unlinkWallet(com.enjin.sdk.schemas.player.mutations.UnlinkWallet request) {
        return null;
    }

    @Override
    public void unlinkWallet(com.enjin.sdk.schemas.player.mutations.UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<Boolean> unlinkWallet(com.enjin.sdk.schemas.project.mutations.UnlinkWallet request) {
        return null;
    }

    @Override
    public void unlinkWallet(com.enjin.sdk.schemas.project.mutations.UnlinkWallet request,
                             HttpCallback<GraphQLResponse<Boolean>> callback) {

    }

    @Override
    public GraphQLResponse<Request> updateName(UpdateName request) {
        return null;
    }

    @Override
    public void updateName(UpdateName request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

}
