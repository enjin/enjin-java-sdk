package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for allowing an operator complete control of all tokens owned by the caller.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class SetApprovalForAll
        extends GraphQLRequest<SetApprovalForAll>
        implements TransactionRequestArguments<SetApprovalForAll> {

    /**
     * Sole constructor.
     */
    public SetApprovalForAll() {
        super("enjin.sdk.shared.SetApprovalForAll");
    }

    /**
     * Sets the wallet address of the operator.
     *
     * @param operatorAddress the address
     * @return this request for chaining
     */
    public SetApprovalForAll operatorAddress(String operatorAddress) {
        return set("operatorAddress", operatorAddress);
    }

    /**
     * Sets the approval state.
     *
     * @param approved the approval
     * @return this request for chaining
     */
    public SetApprovalForAll approved(Boolean approved) {
        return set("approved", approved);
    }

}
