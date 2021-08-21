package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.Melt;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for melting a asset.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class MeltAsset
        extends GraphQLRequest<MeltAsset>
        implements ProjectTransactionRequestArguments<MeltAsset> {

    /**
     * Sole constructor.
     */
    public MeltAsset() {
        super("enjin.sdk.project.MeltAsset");
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
