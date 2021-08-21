package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models transfer input when making requests.
 *
 * @see com.enjin.sdk.schemas.player.mutations.AdvancedSendAsset
 * @see com.enjin.sdk.schemas.project.mutations.AdvancedSendAsset
 */
@EqualsAndHashCode
public class Transfers {

    private String from;
    private String to;
    private String assetId;
    private String assetIndex;
    private String value;

    /**
     * Sets the source of the funds.
     *
     * @param address the source
     *
     * @return this input for chaining
     */
    public Transfers from(String address) {
        from = address;
        return this;
    }

    /**
     * Sets the destination of the funds.
     *
     * @param address the destination
     *
     * @return this input for chaining
     */
    public Transfers to(String address) {
        to = address;
        return this;
    }

    /**
     * Sets the asset ID to transfer.
     * <br>
     * <p>
     * If null or omitted then ENJ will be traded instead.
     * </p>
     *
     * @param id the ID
     *
     * @return this input for chaining
     */
    public Transfers assetId(String id) {
        assetId = id;
        return this;
    }

    /**
     * Sets the index for non-fungible assets.
     *
     * @param index the index
     *
     * @return this input for chaining
     */
    public Transfers assetIndex(String index) {
        assetIndex = index;
        return this;
    }

    /**
     * Sets the number of assets to transfer.
     * <br>
     * <p>
     * If transferring ENJ, the value is the amount to send in Wei (10^18 e.g. 1 ENJ = 1000000000000000000).
     * </p>
     *
     * @param value the amount
     *
     * @return this input for chaining
     */
    public Transfers value(String value) {
        this.value = value;
        return this;
    }

}
