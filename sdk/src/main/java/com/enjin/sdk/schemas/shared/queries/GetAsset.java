package com.enjin.sdk.schemas.shared.queries;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.arguments.AssetFragmentArguments;

/**
 * Request for getting a asset on the platform.
 *
 * @see com.enjin.sdk.models.Asset
 * @see com.enjin.sdk.schemas.shared.ISharedSchema
 */
public class GetAsset
        extends GraphQLRequest<GetAsset>
        implements AssetFragmentArguments<GetAsset> {

    /**
     * Sole constructor.
     */
    public GetAsset() {
        super("enjin.sdk.shared.GetAsset");
    }

    /**
     * Sets the asset ID.
     *
     * @param id the ID
     * @return this request for chaining
     */
    public GetAsset id(String id) {
        return set("id", id);
    }

}
