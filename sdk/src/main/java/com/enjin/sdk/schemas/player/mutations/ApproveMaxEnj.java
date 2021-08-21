package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for approving the crypto items contract to spend the maximum amount of ENJ.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class ApproveMaxEnj
        extends GraphQLRequest<ApproveMaxEnj>
        implements TransactionFragmentArguments<ApproveMaxEnj> {

    /**
     * Sole constructor.
     */
    public ApproveMaxEnj() {
        super("enjin.sdk.player.ApproveMaxEnj");
    }

}
