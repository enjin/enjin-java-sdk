package com.enjin.sdk.events;

import com.enjin.sdk.models.NotificationEvent;

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
