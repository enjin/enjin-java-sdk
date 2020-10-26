package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a smart contract used by the platform.
 */
@EqualsAndHashCode
@Getter
public class Contracts {

    /**
     * -- Getter --
     * @return The ENJ contract address
     */
    private String enj;

    /**
     * -- Getter --
     * @return the crypto items contract address
     */
    private String cryptoItems;

    /**
     * -- Getter --
     * @return the platform registry contract address
     */
    private String platformRegistry;

    /**
     * -- Getter --
     * @return the supply models used by the platform
     */
    private SupplyModels supplyModels;

}
