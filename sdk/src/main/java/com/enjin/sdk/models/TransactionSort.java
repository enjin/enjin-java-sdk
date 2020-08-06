package com.enjin.sdk.models;

/**
 * TODO
 */
public class TransactionSort {

    private TransactionField field;
    private SortDirection direction;

    /**
     * TODO
     * @param field
     * @return
     */
    public TransactionSort field(TransactionField field) {
        this.field = field;
        return this;
    }

    /**
     * TODO
     * @param direction
     * @return
     */
    public TransactionSort direction(SortDirection direction) {
        this.direction = direction;
        return this;
    }

}
