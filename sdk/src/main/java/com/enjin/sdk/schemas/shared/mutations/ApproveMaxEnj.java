package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for approving the crypto items contract to spend the maximum amount of ENJ.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class ApproveMaxEnj
        extends GraphQLRequest<ApproveMaxEnj>
        implements TransactionRequestArguments<ApproveMaxEnj> {

    /**
     * Sole constructor.
     */
    public ApproveMaxEnj() {
        super("enjin.sdk.shared.ApproveMaxEnj");
    }

}
