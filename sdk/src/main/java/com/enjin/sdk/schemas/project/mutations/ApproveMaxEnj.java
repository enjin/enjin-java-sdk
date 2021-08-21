package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for approving the crypto items contract to spend the maximum amount of ENJ.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class ApproveMaxEnj
        extends GraphQLRequest<ApproveMaxEnj>
        implements ProjectTransactionRequestArguments<ApproveMaxEnj> {

    /**
     * Sole constructor.
     */
    public ApproveMaxEnj() {
        super("enjin.sdk.project.ApproveMaxEnj");
    }

}
