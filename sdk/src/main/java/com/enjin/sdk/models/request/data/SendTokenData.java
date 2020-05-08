package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Send Token request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SendTokenData {

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
     * The Ethereum address to send the token to.
     *
     * @param recipientAddress the Ethereum address.
     * @return the builder.
     */
    @SerializedName("recipient_address")
    private String recipientAddress;

    /**
     * The identity id linked to the wallet to send to.
     *
     * @param recipientIdentityId the identity id.
     * @return the builder.
     */
    @SerializedName("recipient_identity_id")
    private Integer recipientIdentityId;

    /**
     * The amount to send.
     *
     * @param value the amount to send.
     * @return the builder.
     */
    private Integer value;

}
