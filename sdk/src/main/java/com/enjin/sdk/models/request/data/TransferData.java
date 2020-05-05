package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
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

    /**
     * Source of the funds.
     *
     * @param from the source
     * @return     the builder
     */
    private String from;

    /**
     * Source of the funds.
     *
     * @param fromId the source id
     * @return       the builder
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * Destination of the funds.
     *
     * @param to the destination
     * @return   the builder
     */
    private String to;

    /**
     * Destination of the funds.
     *
     * @param toId the destination id
     * @return     the builder
     */
    @SerializedName("to_id")
    private Integer toId;

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
     * The amount of the token.
     *
     * @param value the amount.
     * @return the builder.
     */
    private String value;

}
