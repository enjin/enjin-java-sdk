package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class ApproveMaxEnj
        extends GraphQLRequest<ApproveMaxEnj>
        implements TransactionFragmentArguments<ApproveMaxEnj>,
        TransactionRequestArguments<ApproveMaxEnj> {

    /**
     * TODO
     */
    public ApproveMaxEnj() {
        super("enjin.sdk.shared.ApproveMaxEnj");
    }

}
