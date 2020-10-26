package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models sorting input for tokens (items).
 */
@EqualsAndHashCode
public class TokenSort {

    private TokenField field;
    private SortDirection direction;

    /**
     * Sets the field to sort by.
     *
     * @param field the field
     * @return this input for chaining
     */
    public TokenSort field(TokenField field) {
        this.field = field;
        return this;
    }

    /**
     * Sets the direction to sort by.
     *
     * @param direction the direction
     * @return this input for chaining
     */
    public TokenSort direction(SortDirection direction) {
        this.direction = direction;
        return this;
    }

}
