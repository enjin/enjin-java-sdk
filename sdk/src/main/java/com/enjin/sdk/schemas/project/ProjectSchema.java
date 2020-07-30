package com.enjin.sdk.schemas.project;

import com.enjin.sdk.graphql.GraphQLResponse;
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
import com.enjin.sdk.schemas.shared.AccessToken;
import com.enjin.sdk.schemas.shared.SharedSchema;
import com.enjin.sdk.schemas.shared.fragments.Player;
import com.enjin.sdk.schemas.shared.fragments.Request;

import java.util.Collection;

/**
 * TODO
 */
public interface ProjectSchema extends SharedSchema {

    /**
     * TODO
     * @param query
     * @return
     */
    GraphQLResponse<AccessToken> authPlayer(AuthPlayer query);

    /**
     * TODO
     * @param query
     * @return
     */
    GraphQLResponse<AccessToken> authProject(AuthProject query);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<AccessToken> createPlayer(CreatePlayer mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> createToken(CreateToken mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> decreaseMaxMeltFee(DecreaseMaxMeltFee mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> decreaseMaxTransferFee(DecreaseMaxTransferFee mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Boolean> deletePlayer(DeletePlayer mutation);

    /**
     * TODO
     * @param query
     * @return
     */
    GraphQLResponse<Player> getPlayer(GetPlayer query);

    /**
     * TODO
     * @param query
     * @return
     */
    GraphQLResponse<Collection<Player>> getPlayers(GetPlayers query);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Boolean> invalidateTokenMetadata(InvalidateTokenMetadata mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> mintToken(MintToken mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> releaseReserve(ReleaseReserve mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> setMeltFee(SetMeltFee mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> setTransferable(SetTransferable mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> setTransferFee(SetTransferFee mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> setUri(SetUri mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> setWhitelisted(SetWhitelisted mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Boolean> unlinkWallet(UnlinkWallet mutation);

    /**
     * TODO
     * @param mutation
     * @return
     */
    GraphQLResponse<Request> updateName(UpdateName mutation);

}
