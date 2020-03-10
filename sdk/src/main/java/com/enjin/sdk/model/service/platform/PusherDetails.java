package com.enjin.sdk.model.service.platform;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * Will contain details regarding the sdk notification type and settings.
 *
 * @author Evan Lindsay
 * @see NotificationDetails
 * @see PusherOptions
 */
@ToString
@Getter
public class PusherDetails {

    /**
     * The auth key.
     *
     * @return the auth key.
     */
    private String key;

    private Map<String, String> channels;

    private String namespace;

    /**
     * The sdk notification options.
     *
     * @return the sdk notification options.
     */
    private PusherOptions options;

}
