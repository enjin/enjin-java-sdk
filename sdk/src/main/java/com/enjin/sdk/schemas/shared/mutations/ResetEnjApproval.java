package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for resetting the crypto items contract approval for ENJ.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class ResetEnjApproval
        extends GraphQLRequest<ResetEnjApproval>
        implements TransactionRequestArguments<ResetEnjApproval> {

    /**
     * Sole constructor.
     */
    public ResetEnjApproval() {
        super("enjin.sdk.shared.ResetEnjApproval");
    }

}
