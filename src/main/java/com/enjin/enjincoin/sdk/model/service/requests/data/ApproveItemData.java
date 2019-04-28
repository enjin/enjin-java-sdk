package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.math.BigInteger;

/**
 * A data model for the Approve Item request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class ApproveItemData {

    /**
     * The ethereum address of the operator.
     *
     * -- SETTER --
     * @param operator the ethereum address.
     * @return the builder.
     */
    private String operator;

    /**
     * The identity id of the operator.
     *
     * -- SETTER --
     * @param operatorId the identity id.
     * @return the builder.
     */
    @SerializedName("operator_id")
    private BigInteger operatorId;

    /**
     * The token id.
     *
     * -- SETTER --
     * @param tokenId the token id.
     * @return the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The token index.
     *
     * -- SETTER --
     * @param tokenIndex the token index.
     * @return the builder.
     */
    @SerializedName("token_index")
    private String tokenIndex;

    /**
     * The current approved value prior to this transaction.
     *
     * -- SETTER --
     * @param currentValue the current approved value.
     * @return the builder.
     */
    @SerializedName("current_value")
    private Integer currentValue;

    /**
     * The amount to be approved.
     *
     * -- SETTER --
     * @param value the amount to approve.
     * @return the builder.
     */
    private Integer value;

}
