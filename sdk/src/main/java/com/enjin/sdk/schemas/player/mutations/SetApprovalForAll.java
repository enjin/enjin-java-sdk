package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for allowing an operator complete control of all assets owned by the caller.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class SetApprovalForAll
        extends GraphQLRequest<SetApprovalForAll>
        implements TransactionFragmentArguments<SetApprovalForAll> {

    /**
     * Sole constructor.
     */
    public SetApprovalForAll() {
        super("enjin.sdk.player.SetApprovalForAll");
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
