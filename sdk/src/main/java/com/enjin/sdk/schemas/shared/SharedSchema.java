package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Token;
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
public interface SharedSchema {

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> advancedSendToken(AdvancedSendToken request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void advancedSendToken(AdvancedSendToken request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> approveEnj(ApproveEnj request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void approveEnj(ApproveEnj request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void approveMaxEnj(ApproveMaxEnj request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> completeTrade(CompleteTrade request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void completeTrade(CompleteTrade request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> createTrade(CreateTrade request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void createTrade(CreateTrade request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Balance>> getBalances(GetBalances request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getBalances(GetBalances request, HttpCallback<GraphQLResponse<List<Balance>>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getGasPrices(GetGasPrices request, HttpCallback<GraphQLResponse<GasPrices>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Platform> getPlatform(GetPlatform request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getPlatform(GetPlatform request, HttpCallback<GraphQLResponse<Platform>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Project> getProject(GetProject request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getProject(GetProject request, HttpCallback<GraphQLResponse<Project>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> getRequest(GetRequest request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getRequest(GetRequest request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Request>> getRequests(GetRequests request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getRequests(GetRequests request, HttpCallback<GraphQLResponse<List<Request>>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Token> getToken(GetToken request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getToken(GetToken request, HttpCallback<GraphQLResponse<Token>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Token>> getTokens(GetTokens request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getTokens(GetTokens request, HttpCallback<GraphQLResponse<List<Token>>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> meltToken(MeltToken request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void meltToken(MeltToken request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> message(Message request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void message(Message request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void resetEnjApproval(ResetEnjApproval request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> sendEnj(SendEnj request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void sendEnj(SendEnj request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> sendToken(SendToken request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void sendToken(SendToken request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void setApprovalForAll(SetApprovalForAll request, HttpCallback<GraphQLResponse<Request>> callback);

}
