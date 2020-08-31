package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting an item's max transfer fee to a lower value.
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
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public DecreaseMaxTransferFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public DecreaseMaxTransferFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
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
