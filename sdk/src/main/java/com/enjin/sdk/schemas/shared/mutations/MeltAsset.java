package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Melt;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

/**
 * Request for melting a asset.
 *
 * @see com.enjin.sdk.schemas.shared.SharedSchema
 */
public class MeltAsset
        extends GraphQLRequest<MeltAsset>
        implements TransactionRequestArguments<MeltAsset> {

    /**
     * Sole constructor.
     */
    public MeltAsset() {
        super("enjin.sdk.shared.MeltAsset");
    }

    /**
     * Sets the melts to be performed.
     *
     * @param melts the melts
     * @return this request for chaining
     */
    public MeltAsset melts(Melt... melts) {
        return set("melts", melts);
    }

}
