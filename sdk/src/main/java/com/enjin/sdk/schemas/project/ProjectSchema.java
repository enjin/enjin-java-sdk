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
import java.util.Collection;

/**
 * TODO
 */
public interface ProjectSchema extends SharedSchema {

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<AccessToken> authPlayer(AuthPlayer query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void authPlayer(AuthPlayer query, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<AccessToken> authProject(AuthProject query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void authProject(AuthProject query, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<AccessToken> createPlayer(CreatePlayer mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void createPlayer(CreatePlayer mutation, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> createToken(CreateToken mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void createToken(CreateToken mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void decreaseMaxMeltFee(DecreaseMaxMeltFee mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void decreaseMaxTransferFee(DecreaseMaxTransferFee mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> deletePlayer(DeletePlayer mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void deletePlayer(DeletePlayer mutation, HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Player> getPlayer(GetPlayer query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getPlayer(GetPlayer query, HttpCallback<GraphQLResponse<Player>> callback);

    /**
     * TODO
     * @param query
     * @return
     * @throws IOException
     */
    GraphQLResponse<Collection<Player>> getPlayers(GetPlayers query) throws IOException;

    /**
     * TODO
     * @param query
     * @param callback
     */
    void getPlayers(GetPlayers query, HttpCallback<GraphQLResponse<Collection<Player>>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void invalidateTokenMetadata(InvalidateTokenMetadata mutation, HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> mintToken(MintToken mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void mintToken(MintToken mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> releaseReserve(ReleaseReserve mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void releaseReserve(ReleaseReserve mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setMeltFee(SetMeltFee mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void setMeltFee(SetMeltFee mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setTransferable(SetTransferable mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void setTransferable(SetTransferable mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setTransferFee(SetTransferFee mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void setTransferFee(SetTransferFee mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setUri(SetUri mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void setUri(SetUri mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> setWhitelisted(SetWhitelisted mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void setWhitelisted(SetWhitelisted mutation, HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void unlinkWallet(UnlinkWallet mutation, HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * TODO
     * @param mutation
     * @return
     * @throws IOException
     */
    GraphQLResponse<Request> updateName(UpdateName mutation) throws IOException;

    /**
     * TODO
     * @param mutation
     * @param callback
     */
    void updateName(UpdateName mutation, HttpCallback<GraphQLResponse<Request>> callback);

}
