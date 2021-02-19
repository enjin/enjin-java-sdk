package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting an asset's max transfer fee to a lower value.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class DecreaseMaxTransferFee
        extends GraphQLRequest<DecreaseMaxTransferFee>
        implements TransactionRequestArguments<DecreaseMaxTransferFee> {

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
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     * @return this request for chaining
     */
    public DecreaseMaxTransferFee assetIndex(String assetIndex) {
        return set("assetIndex", assetIndex);
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
