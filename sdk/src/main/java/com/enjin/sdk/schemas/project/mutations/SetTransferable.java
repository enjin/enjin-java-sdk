package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.AssetTransferable;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request for setting if a asset may be transferred.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetTransferable
        extends GraphQLRequest<SetTransferable>
        implements ProjectTransactionRequestArguments<SetTransferable> {

    /**
     * Sole constructor.
     */
    public SetTransferable() {
        super("enjin.sdk.project.SetTransferable");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetTransferable assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     * @return this request for chaining
     */
    public SetTransferable assetIndex(String assetIndex) {
        return set("assetIndex", assetIndex);
    }

    /**
     * Sets the new transfer mode.
     *
     * @param transferable the new mode
     * @return this request for chaining
     */
    public SetTransferable transferable(AssetTransferable transferable) {
        return set("transferable", transferable);
    }

}
