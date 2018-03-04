package io.enjincoin.sdk.client.service.legacy.notifications;

import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;

/**
 * Interface to define the methods to be implemented by any eventMatchers.
 */
public interface EventMatcher {

    /**
     * Method to match against any events.
     *
     * @param event to match
     *
     * @return boolean
     */
    boolean matches(NotificationEvent event);
}
