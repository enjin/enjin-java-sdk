package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for setting an asset's max transfer fee to a lower value.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class DecreaseMaxTransferFee
        extends GraphQLRequest<DecreaseMaxTransferFee>
        implements ProjectTransactionRequestArguments<DecreaseMaxTransferFee> {

    /**
     * Sole constructor.
     */
    public DecreaseMaxTransferFee() {
        super("enjin.sdk.project.DecreaseMaxTransferFee");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public DecreaseMaxTransferFee assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the new max transfer fee in Wei.
     *
     * @param maxTransferFee the new fee
     * @return this request for chaining
     */
    public DecreaseMaxTransferFee maxTransferFee(Integer maxTransferFee) {
        return set("maxTransferFee", maxTransferFee);
    }

}
