package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the notifications settings for the platform.
 */
@EqualsAndHashCode
@Getter
public class Notifications {

    /**
     * -- Getter --
     * @return the Pusher settings
     */
    private Pusher pusher;

}
