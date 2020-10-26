package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a token variant.
 *
 * @see Token
 */
@EqualsAndHashCode
@Getter
public final class TokenVariant {

    /**
     * -- Getter --
     * @return the ID of this variant
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the token ID this variant belongs to
     */
    private String tokenId;

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
