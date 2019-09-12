package com.enjin.sdk.model.service.platform;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain settings for the sdk notification driver.
 *
 * @author Evan Lindsay
 * @see SdkDetails
 */
@ToString
@Getter
public class SdkOptions {

    /**
     * The cluster to use.
     *
     * @return the cluster
     */
    private String cluster;

    /**
     * Returns whether the notification service is encrypted.
     *
     * @return true if encrypted, else false
     */
    private Boolean encrypted;

}
