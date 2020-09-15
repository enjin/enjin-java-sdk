package com.enjin.sdk.events.channels;

/**
 * Interface for Enjin Cloud event channels.
 *
 * @see com.enjin.sdk.events.NotificationsService
 */
public interface Channel {

    /**
     * Returns the channel formatted as a string.
     *
     * @return the string
     */
    String channel();

}
