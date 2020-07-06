package com.enjin.sdk.models.platform;

import com.enjin.sdk.services.platform.PlatformService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Models gas prices on the platform.
 * 
 * @see PlatformService
 */
@Getter
@ToString
@NoArgsConstructor
public class GasPrices {

    /**
     * -- GETTER --
     * Returns the recommended fast gas price in Gwei.
     * <p>
     *     Expected to be mined in less than two minutes.
     * </p>
     *
     * @return the recommended fast gas price
     */
    private Float fast;

    /**
     * -- GETTER --
     * Returns the recommended fastest gas price in Gwei.
     * <p>
     *     Expected to be mined in less than 30 seconds.
     * </p>
     *
     * @return the recommended fastest gas price
     */
    private Float fastest;

    /**
     * -- GETTER --
     * Returns the recommended safe gas price in Gwei.
     * <p>
     *     Expected to be mined in less than 30 minutes.
     * </p>
     *
     * @return the recommended safe gas price
     */
    private Float safeLow;

    /**
     * -- GETTER --
     * Returns the recommended average gas price in Gwei.
     * <p>
     *     Expected to be mined in less than five minutes.
     * </p>
     *
     * @return the recommended average gas price
     */
    private Float average;

}
