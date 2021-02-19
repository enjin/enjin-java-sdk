package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Models transfer fee settings for an asset.
 *
 * @see Asset
 */
@EqualsAndHashCode
@Getter
@ToString
public class AssetTransferFeeSettings {

    /**
     * -- GETTER --
     * @return the transfer fee type
     */
    private AssetTransferFeeType type;

    /**
     * -- GETTER --
     * <br>
     * <p>
     *     Will either be the asset ID or "0" for ENJ.
     * </p>
     *
     * @return the asset ID
     */
    private String assetId;

    /**
     * -- GETTER --
     * @return the fee value in Wei
     */
    private String value;

}
