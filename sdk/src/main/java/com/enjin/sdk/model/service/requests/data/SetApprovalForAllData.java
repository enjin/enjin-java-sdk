package com.enjin.sdk.model.service.requests.data;

import com.enjin.sdk.service.requests.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Set Approval For All request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SetApprovalForAllData {

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
     * Whether to be approved or not.
     *
     * -- SETTER --
     *
     * @param approved whether approved or not.
     * @return the builder.
     */
    private Boolean approved;

}
