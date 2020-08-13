package com.enjin.sdk.models;

/**
 * TODO
 */
public class Transfers {

    private String from;
    private String to;
    private String tokenId;
    private String tokenIndex;
    private String value;

    /**
     * TODO
     * @param address
     * @return
     */
    public Transfers from(String address) {
        from = address;
        return this;
    }

    /**
     * TODO
     * @param address
     * @return
     */
    public Transfers to(String address) {
        to = address;
        return this;
    }

    /**
     * TODO
     * @param id
     * @return
     */
    public Transfers tokenId(String id) {
        tokenId = id;
        return this;
    }

    /**
     * TODO
     * @param index
     * @return
     */
    public Transfers tokenIndex(String index) {
        tokenIndex = index;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public Transfers value(String value) {
        this.value = value;
        return this;
    }

}
