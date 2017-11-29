package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.config.Notification;

public interface ThirdPartyNotificationService {

    /**
     * Method to initialize the notification service.
     * @param notification
     * @return
     */
    boolean initializeNotificationService(Notification notification);
}
