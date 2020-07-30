package com.enjin.sdk.schemas.shared.fragments;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * TODO
 */
@Getter
public final class TokenVariant {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer id;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String tokenId;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private JsonObject variantMetadata;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private Integer usageCount;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String createdAt;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private String updatedAt;

}
