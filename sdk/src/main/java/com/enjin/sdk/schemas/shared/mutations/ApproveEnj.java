package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * TODO
 */
public class ApproveEnj extends GraphQLRequest<ApproveEnj>
        implements TransactionFragmentArguments<ApproveEnj>,
        TransactionRequestArguments<ApproveEnj> {

    /**
     * TODO
     */
    public ApproveEnj() {
        super("enjin.sdk.shared.ApproveEnj");
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public ApproveEnj value(String value) {
        return set("value", value);
    }

}
