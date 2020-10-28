package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models a melt input for melt requests.
 *
 * @see com.enjin.sdk.schemas.shared.mutations.MeltToken
 */
@EqualsAndHashCode
public class Melt {

    private String tokenId;
    private String tokenIndex;
    private String value;

    /**
     * Sets the token (item) ID to melt.
     *
     * @param tokenId the ID
     * @return this input for chaining
     */
    public Melt tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * Sets the token (item) index of a non-fungible item to melt.
     *
     * @param tokenIndex the index
     * @return this input for chaining
     */
    public Melt tokenIndex(String tokenIndex) {
        this.tokenIndex = tokenIndex;
        return this;
    }

    /**
     * Sets the number of items to melt.
     *
     * @param value the amount
     * @return this input for chaining
     */
    public Melt value(String value) {
        this.value = value;
        return this;
    }

}
