package com.enjin.sdk.models;

import lombok.Getter;

/**
 * Models the supply models used by the platform.
 */
@Getter
public class SupplyModels {

    /**
     * -- Getter --
     * @return the fixed model
     */
    private String fixed;

    /**
     * -- Getter --
     * @return the settable model
     */
    private String settable;

    /**
     * -- Getter --
     * @return the infinite model
     */
    private String infinite;

    /**
     * -- Getter --
     * @return the collapsing model
     */
    private String collapsing;

    /**
     * -- Getter --
     * @return the annual value model
     */
    private String annualValue;

    /**
     * -- Getter --
     * @return the annual percentage model
     */
    private String annualPercentage;

}
