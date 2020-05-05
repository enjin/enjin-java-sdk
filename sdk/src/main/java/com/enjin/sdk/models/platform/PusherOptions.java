package com.enjin.sdk.models.platform;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain settings for the sdk notification driver.
 *
 * @author Evan Lindsay
 * @see PusherDetails
 */
@ToString
@Getter
public class PusherOptions {

    /**
     * -- GETTER --
     * Returns the cluster to use.
     *
     * @return the cluster
     */
    private String cluster;

    /**
     * -- GETTER --
     * Returns whether the notification service is encrypted.
     *
     * @return true if encrypted, else false
     */
    private Boolean encrypted;

}
