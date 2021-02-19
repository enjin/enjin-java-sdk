package com.enjin.sdk.models;

import com.enjin.sdk.schemas.shared.mutations.MeltAsset;
import lombok.EqualsAndHashCode;

/**
 * Models a melt input for melt requests.
 *
 * @see MeltAsset
 */
@EqualsAndHashCode
public class Melt {

    private String assetId;
    private String assetIndex;
    private String value;

    /**
     * Sets the asset ID to melt.
     *
     * @param assetId the ID
     * @return this input for chaining
     */
    public Melt assetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    /**
     * Sets the index of a non-fungible asset to melt.
     *
     * @param assetIndex the index
     * @return this input for chaining
     */
    public Melt assetIndex(String assetIndex) {
        this.assetIndex = assetIndex;
        return this;
    }

    /**
     * Sets the number of assets to melt.
     *
     * @param value the amount
     * @return this input for chaining
     */
    public Melt value(String value) {
        this.value = value;
        return this;
    }

}
