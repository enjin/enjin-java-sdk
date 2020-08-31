package com.enjin.sdk.models;

/**
 * Models a mint input for mint requests.
 *
 * @see com.enjin.sdk.schemas.project.mutations.MintToken
 */
public class MintInput {

    private String to;
    private String value;

    /**
     * Sets the Ethereum address to mint to.
     *
     * @param ethAddress
     * @return this input for chaining
     */
    public MintInput to(String ethAddress) {
        to = ethAddress;
        return this;
    }

    /**
     * Sets the number of items to mint.
     *
     * @param value
     * @return this input for chaining
     */
    public MintInput value(String value) {
        this.value = value;
        return this;
    }

}
