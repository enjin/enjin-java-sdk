package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting the melt fee of an asset.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class SetMeltFee
        extends GraphQLRequest<SetMeltFee>
        implements TransactionRequestArguments<SetMeltFee> {

    /**
     * Sole constructor.
     */
    public SetMeltFee() {
        super("enjin.sdk.project.SetMeltFee");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetMeltFee assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     * @return this request for chaining
     */
    public SetMeltFee assetIndex(String assetIndex) {
        return set("assetIndex", assetIndex);
    }

    /**
     * Sets the new melt fee for the asset.
     * <br>
     * <p>
     *     The ratio is in the range 0-5000 to allow fractional ratios, e.g. 1 = 0.01%, 5000 = 50%, ect...
     * </p>
     *
     * @param meltFee the new ratio
     * @return this request for chaining
     */
    public SetMeltFee meltFee(Integer meltFee) {
        return set("meltFee", meltFee);
    }

}
