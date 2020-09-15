package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for setting the melt fee of an item.
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
     * Sets the token (item) ID.
     *
     * @param tokenId the ID
     * @return this request for chaining
     */
    public SetMeltFee tokenId(String tokenId) {
        return set("tokenId", tokenId);
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return  this request for chaining
     */
    public SetMeltFee tokenIndex(String tokenIndex) {
        return set("tokenIndex", tokenIndex);
    }

    /**
     * Sets the new melt fee for the item.
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
