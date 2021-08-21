package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.project.arguments.ProjectTransactionRequestArguments;

/**
 * Request to set the metadata URI of an asset.
 *
 * @see com.enjin.sdk.schemas.project.IProjectSchema
 */
public class SetUri
        extends GraphQLRequest<SetUri>
        implements ProjectTransactionRequestArguments<SetUri> {

    /**
     * Sole constructor.
     */
    public SetUri() {
        super("enjin.sdk.project.SetUri");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public SetUri assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param assetIndex the index
     * @return this request for chaining
     */
    public SetUri assetIndex(String assetIndex) {
        return set("assetIndex", assetIndex);
    }

    /**
     * Sets the new URI for the asset's metadata.
     *
     * @param uri the new URI
     * @return this request for chaining
     */
    public SetUri uri(String uri) {
        return set("uri", uri);
    }

}
