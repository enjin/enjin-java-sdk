package com.enjin.sdk.models.request.data;

import java.util.List;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Set Approval request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SetApprovalData {

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
     * The tokens to approve for.
     *
     * @param tokens the tokens.
     * @return the builder.
     */
    private List<TokenIndexPairData> tokens;

    /**
     * Whether to be approved or not.
     *
     * @param approved whether approved or not.
     * @return the builder.
     */
    private Boolean approved;

}
