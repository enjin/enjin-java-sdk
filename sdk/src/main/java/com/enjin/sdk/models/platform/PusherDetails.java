package com.enjin.sdk.models.platform;

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
     * -- GETTER --
     * Returns the authentication key.
     *
     * @return the auth key.
     */
    private String key;

    /**
     * -- GETTER --
     * Returns the channels.
     *
     * @return the channels.
     */
    private Map<String, String> channels;

    /**
     * -- GETTER --
     * Returns the namespace.
     *
     * @return the namespace.
     */
    private String namespace;

    /**
     * -- GETTER --
     * Returns the sdk notification options.
     *
     * @return the notification options.
     */
    private PusherOptions options;

}
