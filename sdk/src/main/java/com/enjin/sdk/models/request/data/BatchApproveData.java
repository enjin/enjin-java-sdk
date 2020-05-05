package com.enjin.sdk.models.request.data;

import java.util.List;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Batch Approve request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class BatchApproveData {

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
     * The different items that the operator is permitted to transfer.
     *
     * @param approve list of items.
     * @return the builder.
     */
    private List<ApproveItemDescData> approve;

}
