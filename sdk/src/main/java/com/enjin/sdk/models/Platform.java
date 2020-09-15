package com.enjin.sdk.models;

import lombok.Getter;

/**
 * Models data about the platform.
 */
@Getter
public class Platform {

    /**
     * -- Getter --
     * @return the platform ID
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the platform name
     */
    private String name;

    /**
     * -- Getter --
     * @return the current Ethereum network this platform is using
     */
    private String network;

    /**
     * -- Getter --
     * @return the smart contracts used by this platform
     */
    private Contracts contracts;

    /**
     * -- Getter --
     * @return the platform notification drivers
     */
    private Notifications notifications;

}
