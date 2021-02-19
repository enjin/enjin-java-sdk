package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Models a asset on the platform.
 */
@EqualsAndHashCode
@Getter
public class Asset {

    /**
     * -- Getter --
     * @return the base ID of this asset
     */
    private String id;

    /**
     * -- Getter --
     * @return the name of this asset
     */
    private String name;

    /**
     * -- Getter --
     * @return the state data of this asset
     */
    private AssetStateData stateData;

    /**
     * -- Getter --
     * @return the config data of this asset
     */
    private AssetConfigData configData;

    /**
     * -- Getter --
     * @return this asset's variant mode
     */
    private AssetVariantMode variantMode;

    /**
     * -- Getter --
     * @return this asset's variants
     */
    private List<AssetVariant> variants;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was created
     */
    private String createdAt;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was last updated
     */
    private String updatedAt;

}
