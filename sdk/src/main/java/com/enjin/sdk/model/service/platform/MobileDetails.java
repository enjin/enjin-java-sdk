package com.enjin.sdk.model.service.platform;

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
     * The type of mobile notifications.
     *
     * @return the mobile notification type.
     */
    private String type;

}
