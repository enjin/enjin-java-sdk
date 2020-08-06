package com.enjin.sdk.models;

/**
 * TODO
 */
public class Trade {

    private String tokenId;
    private String tokenIndex;
    private String value;

    /**
     * TODO
     * @param tokenId
     * @return
     */
    public Trade tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * TODO
     * @param tokenIndex
     * @return
     */
    public Trade tokenIndex(String tokenIndex) {
        this.tokenIndex = tokenIndex;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public Trade value(String value) {
        this.value = value;
        return this;
    }

}
