package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.MintInput;
import com.enjin.sdk.schemas.shared.arguments.TransactionRequestArguments;

import java.util.List;

/**
 * Request for minting a asset.
 *
 * @see com.enjin.sdk.schemas.project.ProjectSchema
 */
public class MintAsset
        extends GraphQLRequest<MintAsset>
        implements TransactionRequestArguments<MintAsset> {

    /**
     * Sole constructor.
     */
    public MintAsset() {
        super("enjin.sdk.project.MintAsset");
    }

    /**
     * Sets the asset ID.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public MintAsset assetId(String assetId) {
        return set("assetId", assetId);
    }

    /**
     * Sets the mints to be performed.
     *
     * @param mints the mints
     * @return this request for chaining
     */
    public MintAsset mints(List<MintInput> mints) {
        return set("mints", mints);
    }

}
