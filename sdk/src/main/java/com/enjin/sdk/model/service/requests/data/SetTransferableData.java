package com.enjin.sdk.model.service.requests.data;

import com.enjin.sdk.model.service.tokens.TokenTransferable;
import com.enjin.sdk.service.requests.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Set Transferable request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SetTransferableData {

    /**
     * The token id.
     *
     * -- SETTER --
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The token index.
     *
     * -- SETTER --
     *
     * @param tokenIndex the token index.
     * @return the builder.
     */
    @SerializedName("token_index")
    private String tokenIndex;

    /**
     * The transferable type.
     *
     * -- SETTER --
     *
     * @param transferable the type.
     * @return the builder.
     */
    private TokenTransferable transferable;

}
