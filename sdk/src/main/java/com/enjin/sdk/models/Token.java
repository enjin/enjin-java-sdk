package com.enjin.sdk.models;

import lombok.Getter;

import java.util.Collection;

/**
 * Models a item on the platform.
 */
@Getter
public class Token {

    /**
     * -- Getter --
     * @return the base ID of this item
     */
    private String id;

    /**
     * -- Getter --
     * @return the name of this item
     */
    private String name;

    /**
     * -- Getter --
     * @return the block number of the last update
     */
    private Integer blockHeight;

    /**
     * -- Getter --
     * @return the creator of this item
     */
    private String creator;

    /**
     * -- Getter --
     * @return the first block this item appeared in
     */
    private Integer firstBlock;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     The ratio is in the range of 0-10000 to allow fractional ratios, e.g. 1 = 0.01%, 10000 = 100%, etc...
     * </p>
     *
     * @return the melt fee ratio
     */
    private Integer meltFeeRatio;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     The ratio is in the range of 0-10000 to allow fractional ratios, e.g. 1 = 0.01%, 10000 = 100%, etc...
     * </p>
     *
     * @return the max melt fee ratio
     */
    private Integer meltFeeMaxRatio;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Corresponds to this item's exchange rate.
     * </p>
     *
     * @return the melt value for this item
     */
    private String meltValue;

    /**
     * -- Getter --
     * @return the metadata URI for this item
     */
    private String metadataUri;

    /**
     * -- Getter --
     * @return whether this item is non-fungible
     */
    private Boolean nonfungible;

    /**
     * -- Getter --
     * @return the reserve of this item
     */
    private String reserve;

    /**
     * -- Getter --
     * @return the supply model of this item
     */
    private TokenSupplyModel supplyModel;

    /**
     * -- Getter --
     * @return the circulating supply of this item
     */
    private String circulatingSupply;

    /**
     * -- Getter --
     * @return the number of items available to mint
     */
    private String mintableSupply;

    /**
     * -- Getter --
     * @return the total supply of this item
     */
    private String totalSupply;

    /**
     * -- Getter --
     * @return the transferable type
     */
    private TokenTransferable transferable;

    /**
     * -- Getter --
     * @return the fee settings for this item
     */
    private TokenTransferFeeSettings transferFeeSettings;

    /**
     * -- Getter --
     * @return the token variant mode
     */
    private TokenVariantMode variantMode;

    /**
     * -- Getter --
     * @return the token variants of this item
     */
    private Collection<TokenVariant> variants;

}
