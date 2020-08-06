package com.enjin.sdk.models;

/**
 * TODO
 */
public class TokenSort {

    private TokenField field;
    private SortDirection direction;

    /**
     * TODO
     * @param field
     * @return
     */
    public TokenSort field(TokenField field) {
        this.field = field;
        return this;
    }

    /**
     * TODO
     * @param direction
     * @return
     */
    public TokenSort direction(SortDirection direction) {
        this.direction = direction;
        return this;
    }

}
