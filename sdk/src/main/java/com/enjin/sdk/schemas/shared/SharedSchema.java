package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Token;
import com.enjin.sdk.services.BalanceService;
import com.enjin.sdk.schemas.BaseSchema;
import com.enjin.sdk.services.PlatformService;
import com.enjin.sdk.services.ProjectService;
import com.enjin.sdk.services.RequestService;
import com.enjin.sdk.services.TokenService;
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
import com.enjin.sdk.utils.LoggerProvider;

import java.io.IOException;
import java.util.List;

/**
 * Schema class which implements requests shared across multiple schemas.
 */
public class SharedSchema extends BaseSchema {

    protected final BalanceService balanceService;
    protected final PlatformService platformService;
    protected final ProjectService projectService;
    protected final RequestService requestService;
    protected final TokenService tokenService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware the middleware
     * @param schema the schema
     * @param loggerProvider the logger provider
     */
    public SharedSchema(TrustedPlatformMiddleware middleware, String schema, LoggerProvider loggerProvider) {
        super(middleware, schema, loggerProvider);
        balanceService = (BalanceService) createService(BalanceService.class);
        platformService = (PlatformService) createService(PlatformService.class);
        projectService = (ProjectService) createService(ProjectService.class);
        requestService = (RequestService) createService(RequestService.class);
        tokenService = (TokenService) createService(TokenService.class);
    }

    /**
     * Sends {@link AdvancedSendToken} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> advancedSendToken(AdvancedSendToken request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link AdvancedSendToken} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void advancedSendToken(AdvancedSendToken request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ApproveEnj} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> approveEnj(ApproveEnj request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ApproveEnj} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void approveEnj(ApproveEnj request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ApproveMaxEnj} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ApproveMaxEnj} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void approveMaxEnj(ApproveMaxEnj request,
                              HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link CompleteTrade} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> completeTrade(CompleteTrade request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link CompleteTrade} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void completeTrade(CompleteTrade request,
                              HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link CreateTrade} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> createTrade(CreateTrade request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link CreateTrade} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void createTrade(CreateTrade request,
                            HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link GetBalances} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<List<Balance>> getBalances(GetBalances request) {
        return sendRequest(balanceService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetBalances} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getBalances(GetBalances request,
                            HttpCallback<GraphQLResponse<List<Balance>>> callback) {
        sendRequest(balanceService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetGasPrices} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request) {
        return sendRequest(platformService.getGasPrices(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetGasPrices} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getGasPrices(GetGasPrices request,
                             HttpCallback<GraphQLResponse<GasPrices>> callback) {
        sendRequest(platformService.getGasPrices(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetPlatform} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Platform> getPlatform(GetPlatform request) {
        return sendRequest(platformService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlatform} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getPlatform(GetPlatform request,
                            HttpCallback<GraphQLResponse<Platform>> callback) {
        sendRequest(platformService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetProject} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Project> getProject(GetProject request) {
        return sendRequest(projectService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetProject} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getProject(GetProject request,
                           HttpCallback<GraphQLResponse<Project>> callback) {
        sendRequest(projectService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetRequest} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> getRequest(GetRequest request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link GetRequest} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getRequest(GetRequest request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link GetRequests} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<List<Request>> getRequests(GetRequests request) {
        return sendRequest(requestService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetRequests} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getRequests(GetRequests request,
                            HttpCallback<GraphQLResponse<List<Request>>> callback) {
        sendRequest(requestService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetToken} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Token> getToken(GetToken request) {
        return sendRequest(tokenService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetToken} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getToken(GetToken request,
                         HttpCallback<GraphQLResponse<Token>> callback) {
        sendRequest(tokenService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetTokens} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<List<Token>> getTokens(GetTokens request) {
        return sendRequest(tokenService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetTokens} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void getTokens(GetTokens request,
                          HttpCallback<GraphQLResponse<List<Token>>> callback) {
        sendRequest(tokenService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link MeltToken} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> meltToken(MeltToken request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link MeltToken} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void meltToken(MeltToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link Message} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> message(Message request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link Message} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void message(Message request,
                        HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link ResetEnjApproval} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link ResetEnjApproval} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void resetEnjApproval(ResetEnjApproval request,
                                 HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SendEnj} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> sendEnj(SendEnj request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SendEnj} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void sendEnj(SendEnj request,
                        HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SendToken} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> sendToken(SendToken request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SendToken} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void sendToken(SendToken request,
                          HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link SetApprovalForAll} request synchronously.
     *
     * @param request the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    public GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link SetApprovalForAll} request asynchronously.
     *
     * @param request the request
     * @param callback the callback
     */
    public void setApprovalForAll(SetApprovalForAll request,
                                  HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Helper method for sending synchronous transaction requests.
     *
     * @param request the request
     * @param <T> the type of the request
     * @return the response
     * @throws IOException if a problem occurred talking to the server
     */
    protected <T extends GraphQLRequest<T>> GraphQLResponse<Request> transactionRequest(GraphQLRequest<T> request) {
        return sendRequest(requestService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Helper method for sending asynchronous transaction requests.
     *
     * @param request the request
     * @param callback the callback
     * @param <T> the type of the request
     */
    protected <T extends GraphQLRequest<T>> void transactionRequest(GraphQLRequest<T> request,
                                                                    HttpCallback<GraphQLResponse<Request>> callback) {
        sendRequest(requestService.getOne(schema, createRequestBody(request)), callback);
    }

}
