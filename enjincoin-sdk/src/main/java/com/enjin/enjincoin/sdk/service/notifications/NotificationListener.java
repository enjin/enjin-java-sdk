package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationEvent;

/**
 * Notification event listener.
 *
 * @author Evan Lindsay
 */
public interface NotificationListener {

    /**
     * Called when an event is received.
     *
     * @param event the event received.
     */
    void notificationReceived(NotificationEvent event);
}
