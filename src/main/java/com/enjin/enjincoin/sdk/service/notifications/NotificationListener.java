package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.service.notifications.vo.NotificationEvent;

/**
 * <p>Listener for listening to notifications.</p>
 */
public interface NotificationListener {

    /**
     * Method called when a notification event is received.
     *
     * @param event the event that just occured
     */
    void notificationReceived(NotificationEvent event);
}
