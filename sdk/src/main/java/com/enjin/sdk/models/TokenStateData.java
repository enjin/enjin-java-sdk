package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the state data of a {@link Token}.
 */
@EqualsAndHashCode
@Getter
public class TokenStateData {

    /**
     * -- Getter --
     * @return whether the item is non-fungible
     */
    private Boolean nonfungible;

    /**
     * -- Getter --
     * @return the block number of the last update
     */
    private Integer blockHeight;

    /**
     * -- Getter --
     * @return the creator of the item
     */
    private String creator;

    /**
     * -- Getter --
     * @return the first block the item appeared in
     */
    private Integer firstBlock;

    /**
     * -- Getter --
     * @return the reserve of the item
     */
    private String reserve;

    /**
     * -- Getter --
     * @return the supply model of the item
     */
    private TokenSupplyModel supplyModel;

    /**
     * -- Getter --
     * @return the circulating supply of the item
     */
    private String circulatingSupply;

    /**
     * -- Getter --
     * @return the number of items available to mint
     */
    private String mintableSupply;

    /**
     * -- Getter --
     * @return the total supply of the item
     */
    private String totalSupply;

}
