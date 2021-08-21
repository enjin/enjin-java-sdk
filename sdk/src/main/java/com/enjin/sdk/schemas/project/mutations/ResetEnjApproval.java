package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for resetting the crypto items contract approval for ENJ.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class ResetEnjApproval
        extends GraphQLRequest<ResetEnjApproval>
        implements ProjectTransactionRequestArguments<ResetEnjApproval> {

    /**
     * Sole constructor.
     */
    public ResetEnjApproval() {
        super("enjin.sdk.project.ResetEnjApproval");
    }

}
