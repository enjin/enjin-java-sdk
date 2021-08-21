package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for releasing the reserve of an asset.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class ReleaseReserve
        extends GraphQLRequest<ReleaseReserve>
        implements ProjectTransactionRequestArguments<ReleaseReserve> {

    /**
     * Sole constructor.
     */
    public ReleaseReserve() {
        super("enjin.sdk.project.ReleaseReserve");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public ReleaseReserve assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the amount to release.
     *
     * @param value the amount
     * @return this request for chaining
     */
    public ReleaseReserve value(String value) {
        return set("value", value);
    }

}
