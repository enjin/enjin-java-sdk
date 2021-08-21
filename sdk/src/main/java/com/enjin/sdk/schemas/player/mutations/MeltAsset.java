package com.enjin.sdk.schemas.player.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Melt;
import com.enjin.sdk.schemas.shared.arguments.TransactionFragmentArguments;

/**
 * Request for melting a asset.
 *
 * @see com.enjin.sdk.schemas.player.IPlayerSchema
 */
public class MeltAsset
        extends GraphQLRequest<MeltAsset>
        implements TransactionFragmentArguments<MeltAsset> {

    /**
     * Sole constructor.
     */
    public MeltAsset() {
        super("enjin.sdk.player.MeltAsset");
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
