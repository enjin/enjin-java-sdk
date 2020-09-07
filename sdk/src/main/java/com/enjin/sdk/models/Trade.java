package com.enjin.sdk.models;

/**
 * Models a trade input for requests.
 *
 * @see com.enjin.sdk.schemas.shared.mutations.CreateTrade
 */
public class Trade {

    private String tokenId;
    private String tokenIndex;
    private String value;

    /**
     * Sets the token (item) ID to trade.
     * <br>
     * <p>
     *     If null or omitted then ENJ will be traded instead.
     * </p>
     *
     * @param tokenId the token ID
     * @return this input for chaining
     */
    public Trade tokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    /**
     * Sets the index for non-fungible items.
     *
     * @param tokenIndex the index
     * @return this input for chaining
     */
    public Trade tokenIndex(String tokenIndex) {
        this.tokenIndex = tokenIndex;
        return this;
    }

    /**
     * Sets the number of items to trade.
     * <br>
     * <p>
     *     If trading ENJ, the value is the amount to send in Wei (10^18 e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the amount
     * @return this input for chaining
     */
    public Trade value(String value) {
        this.value = value;
        return this;
    }

}
