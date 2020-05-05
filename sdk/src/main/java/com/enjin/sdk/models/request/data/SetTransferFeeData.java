package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Set Transfer Fee request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SetTransferFeeData {

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
     * The new transfer fee amount.
     *
     * @param transferFee the new fee amount.
     * @return the builder.
     */
    private String transferFee;

}
