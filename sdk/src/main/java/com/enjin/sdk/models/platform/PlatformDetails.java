package com.enjin.sdk.models.platform;

import com.enjin.sdk.services.platform.PlatformService;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain information regarding the trusted platfrom, blockchain, and any
 * other configurations details that are to fully utilize the capabilities of
 * the trusted platform.
 *
 * @author Evan Lindsay
 * @see PlatformService
 * @see NotificationDetails
 */
@Getter
@ToString
public class PlatformDetails {

    /**
     * -- GETTER --
     * Returns the name of the Trusted Platform.
     *
     * @return the Trusted Platform name.
     */
    private String name;

    /**
     * -- GETTER --
     * Returns the Trusted Platform id.
     *
     * @return the Trusted Platform id.
     */
    private Integer id;

    /**
     * -- GETTER --
     * Returns the blockchain network the Trusted Platform operates on.
     *
     * @return the Trusted Platform network.
     */
    private String network;

    /**
     * -- GETTER --
     * Returns the network block height.
     *
     * @return the network block height.
     */
    private Integer blockHeight;

    /**
     * -- GETTER --
     * Returns the notification details.
     *
     * @return the Trusted Platform notification details.
     */
    private NotificationDetails notifications;

}
