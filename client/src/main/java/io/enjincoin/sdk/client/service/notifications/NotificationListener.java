package io.enjincoin.sdk.client.service.notifications;

import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;

/**
 * <p>Listener for listening to notifications.</p>
 *
 */
public interface NotificationListener {

    /**
     * Method called when a notification event is received.
     * @param event the event that just occured
     */
    void notificationReceived(NotificationEvent event);
}
