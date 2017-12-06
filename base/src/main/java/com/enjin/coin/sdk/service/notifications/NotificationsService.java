package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;

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

    @SuppressWarnings("rawtypes")
    RegistrationListenerConfiguration configureListener(NotificationListener listener);

    /**
     * Method to add a notification listener.
     * @param listener the listener to add
     */
    NotificationListenerRegistration addNotificationListener(NotificationListener listener);

    NotificationListenerRegistration addNotificationListener(NotificationListener listener, EventMatcher eventMatcher);

    NotificationListenerRegistration addAllowedTypesNotificationListener(NotificationListener listener, NotificationType... allowed);

    NotificationListenerRegistration addIgnoredTypesNotificationListener(NotificationListener listener, NotificationType... ignored);

    /**
     * Method to remove a notification listener.
     * @param listener the listener to remove
     */
    void removeNotificationListener(NotificationListener listener);

    void addNotificationListenerRegistration(NotificationListenerRegistration registration);

    void removeNotificationListenerRegistration(NotificationListenerRegistration registration);
}
