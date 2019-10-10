package com.enjin.sdk.model.service.platform;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain the mobile and sdk notification details.
 *
 * @author Evan Lindsay
 * @see PlatformDetails
 * @see MobileDetails
 * @see SdkDetails
 */
@ToString
@Getter
public class NotificationDetails {

    /**
     * The sdk notification details.
     *
     * @return the sdk details.
     */
    private SdkDetails sdk;

    /**
     * The mobile notification details.
     *
     * @return the mobile details.
     */
    private MobileDetails mobile;


}
