package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationEvent;

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
