package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a gas prices object.
 */
@EqualsAndHashCode
@Getter
public class GasPrices {

    /**
     * -- Getter --
     * The recommended safe gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 30 minutes.
     * </p>
     *
     * @return the gas price
     */
    private float safeLow;

    /**
     * -- Getter --
     * The recommended average gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 5 minutes.
     * </p>
     *
     * @return the gas price
     */
    private float average;

    /**
     * -- Getter --
     * The recommended fast gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 2 minutes.
     * </p>
     *
     * @return the gas price
     */
    private float fast;

    /**
     * -- Getter --
     * The recommended fastest gas price in Gwei.
     * <br>
     * <p>
     *     Expected to be mined in less than 30 seconds.
     * </p>
     *
     * @return the gas price
     */
    private float fastest;

}
