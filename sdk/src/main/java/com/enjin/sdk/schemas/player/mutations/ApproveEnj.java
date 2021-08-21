package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for approving the crypto items contract to spend ENJ.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class ApproveEnj
        extends GraphQLRequest<ApproveEnj>
        implements TransactionFragmentArguments<ApproveEnj> {

    /**
     * Sole constructor.
     */
    public ApproveEnj() {
        super("enjin.sdk.player.ApproveEnj");
    }

    /**
     * Sets the amount of ENJ to approve.
     * <br>
     * <p>
     *     The value is in Wei as 10^18 (e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the value
     * @return this request for chaining
     */
    public ApproveEnj value(String value) {
        return set("value", value);
    }

}
