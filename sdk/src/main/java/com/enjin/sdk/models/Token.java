package com.enjin.sdk.models;

import lombok.Getter;

import java.util.List;

/**
 * Models a item on the platform.
 */
@Getter
public class Token {

    /**
     * -- Getter --
     * @return the base ID of this item
     */
    private String id;

    /**
     * -- Getter --
     * @return the name of this item
     */
    private String name;

    /**
     * -- Getter --
     * @return the state data of this item
     */
    private TokenStateData stateData;

    /**
     * -- Getter --
     * @return the config data of this item
     */
    private TokenConfigData configData;

    /**
     * -- Getter --
     * @return the token variant mode
     */
    private TokenVariantMode variantMode;

    /**
     * -- Getter --
     * @return the token variants of this item
     */
    private List<TokenVariant> variants;

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
