package com.enjin.sdk.models.platform;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain the mobile and sdk notification details.
 *
 * @author Evan Lindsay
 * @see PlatformDetails
 * @see MobileDetails
 * @see PusherDetails
 */
@ToString
@Getter
public class NotificationDetails {

    /**
     * -- GETTER --
     * Returns the sdk notification details.
     *
     * @return the sdk details.
     */
    private PusherDetails pusher;

    /**
     * -- GETTER --
     * Returns the mobile notification details.
     *
     * @return the mobile details.
     */
    private MobileDetails mobile;


}
