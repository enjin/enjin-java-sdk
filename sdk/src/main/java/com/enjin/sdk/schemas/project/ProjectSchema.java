package com.enjin.sdk.schemas.project;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
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
public interface ProjectSchema extends SharedSchema {

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<AccessToken> authPlayer(AuthPlayer request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void authPlayer(AuthPlayer request, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<AccessToken> authProject(AuthProject request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void authProject(AuthProject request, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<AccessToken> createPlayer(CreatePlayer request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void createPlayer(CreatePlayer request, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> createToken(CreateToken request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void createToken(CreateToken request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void decreaseMaxMeltFee(DecreaseMaxMeltFee request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void decreaseMaxTransferFee(DecreaseMaxTransferFee request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> deletePlayer(DeletePlayer request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void deletePlayer(DeletePlayer request, HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Player> getPlayer(GetPlayer request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getPlayer(GetPlayer request, HttpCallback<GraphQLResponse<Player>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<List<Player>> getPlayers(GetPlayers request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void getPlayers(GetPlayers request, HttpCallback<GraphQLResponse<List<Player>>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void invalidateTokenMetadata(InvalidateTokenMetadata request, HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> mintToken(MintToken request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void mintToken(MintToken request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> releaseReserve(ReleaseReserve request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void releaseReserve(ReleaseReserve request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setMeltFee(SetMeltFee request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void setMeltFee(SetMeltFee request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setTransferable(SetTransferable request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void setTransferable(SetTransferable request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setTransferFee(SetTransferFee request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void setTransferFee(SetTransferFee request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setUri(SetUri request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void setUri(SetUri request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setWhitelisted(SetWhitelisted request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void setWhitelisted(SetWhitelisted request, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void unlinkWallet(UnlinkWallet request, HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * TODO
     * @param request
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> updateName(UpdateName request);

    /**
     * TODO
     * @param request
     * @param callback
     */
    void updateName(UpdateName request, HttpCallback<GraphQLResponse<Request>> callback);

}
