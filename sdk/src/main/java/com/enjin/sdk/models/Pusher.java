package com.enjin.sdk.models;

import lombok.Getter;

/**
 * Models Pusher settings for the platform.
 */
@Getter
public class Pusher {

    /**
     * -- Getter --
     * @return the key for the platform
     */
    private String key;

    /**
     * -- Getter --
     * @return the namespace the platform broadcasts on
     */
    private String namespace;

    /**
     * -- Getter --
     * @return the channels the platform broadcasts on
     */
    private PusherChannels channels;

    /**
     * -- Getter --
     * @return the Pusher options the platform uses
     */
    private PusherOptions options;

}
