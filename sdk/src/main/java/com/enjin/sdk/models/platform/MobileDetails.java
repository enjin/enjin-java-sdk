package com.enjin.sdk.models.platform;

import lombok.Getter;
import lombok.ToString;

/**
 * Will contain details regarding the mobile notification type and settings.
 *
 * @author Evan Lindsay
 * @see NotificationDetails
 */
@ToString
@Getter
public class MobileDetails {

    /**
     * -- GETTER --
     * Returns the type of mobile notification.
     *
     * @return the mobile notification type.
     */
    private String type;

}
