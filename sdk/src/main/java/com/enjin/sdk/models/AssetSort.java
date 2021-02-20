package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models sorting input for assets.
 */
@EqualsAndHashCode
public class AssetSort {

    private AssetField field;
    private SortDirection direction;

    /**
     * Sets the field to sort by.
     *
     * @param field the field
     * @return this input for chaining
     */
    public AssetSort field(AssetField field) {
        this.field = field;
        return this;
    }

    /**
     * Sets the direction to sort by.
     *
     * @param direction the direction
     * @return this input for chaining
     */
    public AssetSort direction(SortDirection direction) {
        this.direction = direction;
        return this;
    }

}
