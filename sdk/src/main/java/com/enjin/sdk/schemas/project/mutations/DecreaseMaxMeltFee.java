package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for setting an asset's max melt fee to a lower value.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class DecreaseMaxMeltFee
        extends GraphQLRequest<DecreaseMaxMeltFee>
        implements ProjectTransactionRequestArguments<DecreaseMaxMeltFee> {

    /**
     * Sole constructor.
     */
    public DecreaseMaxMeltFee() {
        super("enjin.sdk.project.DecreaseMaxMeltFee");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public DecreaseMaxMeltFee assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the new max melt fee for the asset.
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
