package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Token;
import com.enjin.sdk.schemas.BaseSchema;
import com.enjin.sdk.schemas.ProjectService;
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
public class SharedSchema extends BaseSchema {

    protected final ProjectService projectService;

    /**
     * TODO
     * @param middleware
     */
    public SharedSchema(TrustedPlatformMiddleware middleware, String schema) {
        super(middleware, schema);
        projectService = (ProjectService) createService(ProjectService.class);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> advancedSendToken(AdvancedSendToken request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void advancedSendToken(AdvancedSendToken request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> approveEnj(ApproveEnj request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void approveEnj(ApproveEnj request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void approveMaxEnj(ApproveMaxEnj request,
                              HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> completeTrade(CompleteTrade request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void completeTrade(CompleteTrade request,
                              HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> createTrade(CreateTrade request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void createTrade(CreateTrade request,
                            HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<List<Balance>> getBalances(GetBalances request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getBalances(GetBalances request,
                            HttpCallback<GraphQLResponse<List<Balance>>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getGasPrices(GetGasPrices request,
                             HttpCallback<GraphQLResponse<GasPrices>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Platform> getPlatform(GetPlatform request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getPlatform(GetPlatform request,
                            HttpCallback<GraphQLResponse<Platform>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Project> getProject(GetProject request) {
        return sendRequest(projectService.getOne(schema, createRequestBody(request)));
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getProject(GetProject request,
                           HttpCallback<GraphQLResponse<Project>> callback) {
        sendRequest(projectService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> getRequest(GetRequest request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getRequest(GetRequest request,
                           HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<List<Request>> getRequests(GetRequests request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getRequests(GetRequests request,
                            HttpCallback<GraphQLResponse<List<Request>>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Token> getToken(GetToken request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getToken(GetToken request,
                         HttpCallback<GraphQLResponse<Token>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<List<Token>> getTokens(GetTokens request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void getTokens(GetTokens request,
                          HttpCallback<GraphQLResponse<List<Token>>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> meltToken(MeltToken request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void meltToken(MeltToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> message(Message request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void message(Message request,
                        HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void resetEnjApproval(ResetEnjApproval request,
                                 HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> sendEnj(SendEnj request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void sendEnj(SendEnj request,
                        HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> sendToken(SendToken request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void sendToken(SendToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {

    }

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    public GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request) {
        return null;
    }

    /**
     * TODO
     * @param request
     * @param callback
     */
    public void setApprovalForAll(SetApprovalForAll request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {

    }

}
