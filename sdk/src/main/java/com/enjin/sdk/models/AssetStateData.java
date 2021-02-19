package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the state data of a {@link Asset}.
 */
@EqualsAndHashCode
@Getter
public class AssetStateData {

    /**
     * -- Getter --
     * @return whether the asset is non-fungible
     */
    private Boolean nonFungible;

    /**
     * -- Getter --
     * @return the block number of the last update
     */
    private Integer blockHeight;

    /**
     * -- Getter --
     * @return the creator of the asset
     */
    private String creator;

    /**
     * -- Getter --
     * @return the first block the asset appeared in
     */
    private Integer firstBlock;

    /**
     * -- Getter --
     * @return the reserve of the asset
     */
    private String reserve;

    /**
     * -- Getter --
     * @return the supply model of the asset
     */
    private AssetSupplyModel supplyModel;

    /**
     * -- Getter --
     * @return the circulating supply of the asset
     */
    private String circulatingSupply;

    /**
     * -- Getter --
     * @return the number of assets available to mint
     */
    private String mintableSupply;

    /**
     * -- Getter --
     * @return the total supply of the asset
     */
    private String totalSupply;

}
