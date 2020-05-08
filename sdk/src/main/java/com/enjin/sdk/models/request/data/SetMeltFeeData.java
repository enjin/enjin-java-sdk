package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Set Melt Fee request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SetMeltFeeData {

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
     * The new melt fee amount.
     *
     * @param meltFee the new fee amount.
     * @return the builder.
     */
    private Integer meltFee;

}
