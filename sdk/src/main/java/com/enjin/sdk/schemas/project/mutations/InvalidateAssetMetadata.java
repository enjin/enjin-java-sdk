package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;

/**
 * Request for invalidating the cached metadata of a asset on the platform.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class InvalidateAssetMetadata extends GraphQLRequest<InvalidateAssetMetadata> {

    /**
     * Sole constructor.
     */
    public InvalidateAssetMetadata() {
        super("enjin.sdk.project.InvalidateAssetMetadata");
    }

    /**
     * Sets the asset ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public InvalidateAssetMetadata id(String id) {
        return set("id", id);
    }

}
