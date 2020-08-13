package com.enjin.sdk.models;

/**
 * TODO
 */
public class MintInput {

    private String to;
    private String value;

    /**
     * TODO
     * @param ethAddress
     * @return
     */
    public MintInput to(String ethAddress) {
        to = ethAddress;
        return this;
    }

    /**
     * TODO
     * @param value
     * @return
     */
    public MintInput value(String value) {
        this.value = value;
        return this;
    }

}
