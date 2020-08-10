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
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> advancedSendToken(AdvancedSendToken mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void advancedSendToken(AdvancedSendToken mutation,
                           HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> approveEnj(ApproveEnj mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void approveEnj(ApproveEnj mutation,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void approveMaxEnj(ApproveMaxEnj mutation,
                       HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> completeTrade(CompleteTrade mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void completeTrade(CompleteTrade mutation,
                       HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> createTrade(CreateTrade mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void createTrade(CreateTrade mutation,
                     HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Balance>> getBalances(GetBalances query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getBalances(GetBalances query,
                     HttpCallback<GraphQLResponse<List<Balance>>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<GasPrices> getGasPrices(GetGasPrices query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getGasPrices(GetGasPrices query,
                      HttpCallback<GraphQLResponse<GasPrices>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Platform> getPlatform(GetPlatform query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getPlatform(GetPlatform query,
                     HttpCallback<GraphQLResponse<Platform>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Project> getProject(GetProject query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getProject(GetProject query,
                    HttpCallback<GraphQLResponse<Project>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> getRequest(GetRequest query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getRequest(GetRequest query,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Request>> getRequests(GetRequests query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getRequests(GetRequests query,
                     HttpCallback<GraphQLResponse<List<Request>>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Token> getToken(GetToken query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getToken(GetToken query,
                  HttpCallback<GraphQLResponse<Token>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Token>> getTokens(GetTokens query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getTokens(GetTokens query,
                   HttpCallback<GraphQLResponse<List<Token>>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> meltToken(MeltToken mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void meltToken(MeltToken mutation,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> message(Message mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void message(Message mutation,
                 HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void resetEnjApproval(ResetEnjApproval mutation,
                          HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> sendEnj(SendEnj mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void sendEnj(SendEnj mutation,
                 HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> sendToken(SendToken mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void sendToken(SendToken mutation,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void setApprovalForAll(SetApprovalForAll mutation,
                           HttpCallback<GraphQLResponse<Request>> callback);

}
