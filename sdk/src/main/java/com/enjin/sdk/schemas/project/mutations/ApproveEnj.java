package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for approving the crypto items contract to spend ENJ.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class ApproveEnj
        extends GraphQLRequest<ApproveEnj>
        implements ProjectTransactionRequestArguments<ApproveEnj> {

    /**
     * Sole constructor.
     */
    public ApproveEnj() {
        super("enjin.sdk.project.ApproveEnj");
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
