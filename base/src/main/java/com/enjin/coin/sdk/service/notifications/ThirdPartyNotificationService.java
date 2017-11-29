package com.enjin.coin.sdk.service.notifications;

import java.util.List;

import com.enjin.coin.sdk.config.Notification;

public interface ThirdPartyNotificationService {

    /**
     * Method to initialize the notification service.
     * @param notification
     * @return
     */
    boolean initializeNotificationService(Notification notification);

    /**
     * Method to set the notification listeners
     * @param notificationListeners
     */
    void setNotificationListeners(List<NotificationListener> notificationListeners);
}
