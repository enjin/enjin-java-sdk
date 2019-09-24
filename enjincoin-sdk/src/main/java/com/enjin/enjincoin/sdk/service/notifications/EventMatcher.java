package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationEvent;

/**
 * Matches events.
 *
 * @author Evan Lindsay
 */
public interface EventMatcher {

    /**
     * Method to check events to see if they match.
     *
     * @param event the event to match.
     *
     * @return true if matched, else false.
     */
    boolean matches(NotificationEvent event);
}
