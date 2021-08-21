package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for resetting the crypto items contract approval for ENJ.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class ResetEnjApproval
        extends GraphQLRequest<ResetEnjApproval>
        implements TransactionFragmentArguments<ResetEnjApproval> {

    /**
     * Sole constructor.
     */
    public ResetEnjApproval() {
        super("enjin.sdk.player.ResetEnjApproval");
    }

}
