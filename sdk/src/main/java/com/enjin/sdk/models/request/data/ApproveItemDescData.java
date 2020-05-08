package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model that defines the different items an operator
 * is allowed to transfer in a Batch Approve request.
 *
 * @author Evan Lindsay
 * @see BatchApproveData
 * @see RequestsService
 */
@Builder
public class ApproveItemDescData {

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
     * The current approved value prior to this transaction.
     *
     * @param currentValue the current approved value.
     * @return the builder.
     */
    @SerializedName("current_value")
    private Integer currentValue;

    /**
     * The amount to be approved.
     *
     * @param value the amount to approve.
     * @return the builder.
     */
    private Integer value;

}
