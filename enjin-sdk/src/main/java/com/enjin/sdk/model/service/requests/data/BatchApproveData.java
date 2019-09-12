package com.enjin.sdk.model.service.requests.data;

import java.util.List;

import com.enjin.sdk.service.requests.RequestsService;
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
    private Integer operatorId;

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
