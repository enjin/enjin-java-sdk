package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Add Log request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class AddLogData {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The token index.
     *
     * @param tokenIndex the token index.
     * @return the builder.
     */
    @SerializedName("token_index")
    private String tokenIndex;

    /**
     * The message data.
     *
     * @param data the message data.
     * @return the builder
     */
    private String data;

}
