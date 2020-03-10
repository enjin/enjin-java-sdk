package com.enjin.sdk.model.service.requests.data;

import com.enjin.sdk.service.requests.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model that defines the different transfers to perform in
 * an Advanced Send Token request.
 *
 * @author Evan Lindsay
 * @see AdvancedSendTokenData
 * @see RequestsService
 */
@Builder
public class TransferData {

    private String from;

    @SerializedName("from_id")
    private Integer fromId;

    private String to;

    @SerializedName("to_id")
    private Integer toId;

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
     * The amount of the token.
     *
     * -- SETTER --
     *
     * @param value the amount.
     * @return the builder.
     */
    private String value;

}
