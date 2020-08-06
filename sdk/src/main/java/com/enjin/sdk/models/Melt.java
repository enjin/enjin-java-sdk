package com.enjin.sdk.models;

/**
 * TODO
 */
public class Melt {

    private String tokenId;
    private String tokenIndex;
    private String value;

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public Melt tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public Melt tokenIndex(String tokenIndex) {
        this.tokenIndex = tokenIndex;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public Melt value(String value) {
        this.value = value;
        return this;
    }

}
