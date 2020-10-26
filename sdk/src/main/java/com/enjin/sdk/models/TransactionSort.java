package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models sorting input for transactions.
 */
@EqualsAndHashCode
public class TransactionSort {

    private TransactionField field;
    private SortDirection direction;

    /**
     * Sets the field to sort by.
     *
     * @param field the field
     * @return this input for chaining
     */
    public TransactionSort field(TransactionField field) {
        this.field = field;
        return this;
    }

    /**
     * Sets the direction to sort by.
     *
     * @param direction the direction
     * @return this input for chaining
     */
    public TransactionSort direction(SortDirection direction) {
        this.direction = direction;
        return this;
    }

}
