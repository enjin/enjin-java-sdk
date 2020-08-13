package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class ResetEnjApproval
        extends GraphQLRequest<ResetEnjApproval>
        implements TransactionRequestArguments<ResetEnjApproval> {

    /**
     * TODO
     */
    public ResetEnjApproval() {
        super("enjin.sdk.shared.ResetEnjApproval");
    }

}
