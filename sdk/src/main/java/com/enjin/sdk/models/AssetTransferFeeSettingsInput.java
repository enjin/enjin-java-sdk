package com.enjin.sdk.models;

import com.enjin.sdk.schemas.project.mutations.CreateAsset;
import lombok.EqualsAndHashCode;

/**
 * Models input for the transfer fee settings used in GraphQL requests.
 *
 * @see CreateAsset
 */
@EqualsAndHashCode
public class AssetTransferFeeSettingsInput {

    private AssetTransferFeeType type;
    private String assetId;
    private String value;

    /**
     * Sets the transfer type for this input.
     *
     * @param type the type
     * @return this request for chaining
     */
    public AssetTransferFeeSettingsInput type(AssetTransferFeeType type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the asset ID for this input.
     *
     * @param assetId the ID
     * @return this request for chaining
     */
    public AssetTransferFeeSettingsInput assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Sets the value in Wei for this input.
     *
     * @param value the value
     * @return this request for chaining
     */
    public AssetTransferFeeSettingsInput value(String value) {
        this.value = value;
        return this;
    }

}
