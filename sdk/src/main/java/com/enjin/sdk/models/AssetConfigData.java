package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the configuration data of a {@link Asset}.
 */
@EqualsAndHashCode
@Getter
public class AssetConfigData {

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
     * @return the melt value for the asset
     */
    private String meltValue;

    /**
     * -- Getter --
     * @return the metadata URI for the asset
     */
    private String metadataURI;

    /**
     * -- Getter --
     * @return the transferable type
     */
    private AssetTransferable transferable;

    /**
     * -- Getter --
     * @return the fee settings for the asset
     */
    private AssetTransferFeeSettings transferFeeSettings;

}
