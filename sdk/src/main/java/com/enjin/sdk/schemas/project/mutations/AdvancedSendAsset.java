package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Transfers;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for sending one or more assets in a single transaction.
 *
 * @see SendAsset
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class AdvancedSendAsset
        extends GraphQLRequest<AdvancedSendAsset>
        implements ProjectTransactionRequestArguments<AdvancedSendAsset> {

    /**
     * Sole constructor.
     */
    public AdvancedSendAsset() {
        super("enjin.sdk.project.AdvancedSendAsset");
    }

    /**
     * Sets the different transfers to perform.
     *
     * @param transfers the transfers
     * @return this request for chaining
     */
    public AdvancedSendAsset transfers(Transfers... transfers) {
        return set("transfers", transfers);
    }

    /**
     * Sets the data to forward with the transaction.
     *
     * @param data the data
     * @return this request for chaining
     */
    public AdvancedSendAsset data(String data) {
        return set("data", data);
    }

}
