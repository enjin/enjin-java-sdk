package com.enjin.coin.sdk.service.notifications;

import java.util.List;

/**
 * <p>Interface for any third party notification systems such as pusher.</p>
 *
 */
public interface ThirdPartyNotificationService {

    /**
     * Method to initialize the notification service.
     * @return boolean
     */
    boolean initializeNotificationService();

    /**
     * Method to set the notification listeners.
     * @param notificationListeners the new list of listeners to set
     */
    void setNotificationListeners(List<NotificationListenerRegistration> notificationListeners);
}
