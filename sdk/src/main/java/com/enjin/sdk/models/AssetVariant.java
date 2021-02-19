package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a asset variant.
 *
 * @see Asset
 */
@EqualsAndHashCode
@Getter
public final class AssetVariant {

    /**
     * -- Getter --
     * @return the ID of this variant
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the asset ID this variant belongs to
     */
    private String assetId;

    /**
     * -- Getter --
     * @return the metadata for this variant
     */
    private JsonObject variantMetadata;

    /**
     * -- Getter --
     * @return the usage count
     */
    private Integer usageCount;

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
