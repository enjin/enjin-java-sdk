package com.enjin.coin.sdk.service.notifications;

/**
 *
 *<p>NotificationsService - Synchronous.</p>
 *
 */
public interface NotificationsService {

    /**
     * Method to initialize the notifications service.

     * @return boolean
     */
    boolean initNotificationsService();

    /**
     * Method to add a notification listener.
     * @param notificationListener the listener to add
     */
    void addNotificationListener(NotificationListener notificationListener);

    /**
     * Method to remove a notification listener.
     * @param notificationListener the listener to remove
     */
    void removeNotificationListener(NotificationListener notificationListener);
}
