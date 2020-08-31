package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting an item's max melt fee to a lower value.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class DecreaseMaxMeltFee
        extends GraphQLRequest<DecreaseMaxMeltFee>
        implements TransactionRequestArguments<DecreaseMaxMeltFee> {

    /**
     * Sole constructor.
     */
    public DecreaseMaxMeltFee() {
        super("enjin.sdk.project.DecreaseMaxMeltFee");
    }

    /**
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public DecreaseMaxMeltFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this request for chaining
     */
    public DecreaseMaxMeltFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the new max melt fee for the item.
     * <br>
     * <p>
     *     The ratio is in the range 0-5000 to allow fractional ratios, e.g. 1 = 0.01%, 5000 = 50%, ect...
     * </p>
     *
     * @param maxMeltFee the new ratio
     * @return this request for chaining
     */
    public DecreaseMaxMeltFee maxMeltFee(int maxMeltFee) {
        return set("maxMeltFee", maxMeltFee);
    }

}
