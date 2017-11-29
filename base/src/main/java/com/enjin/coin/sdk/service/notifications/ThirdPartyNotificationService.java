package com.enjin.coin.sdk.service.notifications;

import java.util.List;

public interface ThirdPartyNotificationService {

    /**
     * Method to initialize the notification service.

     * @return
     */
    boolean initializeNotificationService();

    /**
     * Method to set the notification listeners
     * @param notificationListeners
     */
    void setNotificationListeners(List<NotificationListener> notificationListeners);
}
