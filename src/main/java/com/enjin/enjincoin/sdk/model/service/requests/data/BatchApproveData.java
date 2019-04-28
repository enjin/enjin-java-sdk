package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.math.BigInteger;
import java.util.List;

/**
 * A data model for the Batch Approve request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class BatchApproveData {

    /**
     * The ethereum address of the operator.
     *
     * -- SETTER --
     *
     * @param operator the ethereum address.
     * @return the builder.
     */
    private String operator;

    /**
     * The identity id of the operator.
     *
     * -- SETTER --
     *
     * @param operatorId the identity id.
     * @return the builder.
     */
    @SerializedName("operator_id")
    private BigInteger operatorId;

    /**
     * The different items that the operator is permitted to transfer.
     *
     * -- SETTER --
     *
     * @param approve list of items.
     * @return the builder.
     */
    private List<ApproveItemDescData> approve;

}
