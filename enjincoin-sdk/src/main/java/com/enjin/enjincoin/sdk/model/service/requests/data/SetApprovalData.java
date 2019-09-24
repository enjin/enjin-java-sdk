package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.List;

/**
 * A data model for the Set Approval request type.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class SetApprovalData {

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
     * The tokens to approve for.
     *
     * -- SETTER --
     *
     * @param tokens the tokens.
     * @return the builder.
     */
    private List<TokenIndexPairData> tokens;

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
