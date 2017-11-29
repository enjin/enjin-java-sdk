package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.vo.notifications.NotificationEvent;

/**
 * <p>Listener for listening to notifications.</p>
 *
 */
public interface NotificationListener {

    /**
     * Method called when a notification event is received.
     * @param notificationEvent
     */
    public void notificationReceived(NotificationEvent notificationEvent);
}
