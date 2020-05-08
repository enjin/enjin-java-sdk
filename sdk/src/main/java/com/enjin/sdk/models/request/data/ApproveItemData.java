package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Approve Item request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class ApproveItemData {

    /**
     * The Ethereum address of the operator.
     *
     * @param operator the Ethereum address.
     * @return the builder.
     */
    private String operator;

    /**
     * The identity id of the operator.
     *
     * @param operatorId the identity id.
     * @return the builder.
     */
    @SerializedName("operator_id")
    private Integer operatorId;

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
