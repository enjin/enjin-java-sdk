package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;

/**
 * <p>
 * NotificationsService - Synchronous.
 * </p>
 */
public interface NotificationsService {

    /**
     * Method to initialize the notifications service.
     *
     * @return boolean
     */
    boolean initNotificationsService();

    /**
     * Method to configure a listener.
     *
     * @param listener notificationListener to configure
     * @return RegistrationListenerConfiguration
     */
    @SuppressWarnings("rawtypes")
    RegistrationListenerConfiguration configureListener(NotificationListener listener);

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @return NotificationListenerRegistration
     */
    NotificationListenerRegistration addNotificationListener(NotificationListener listener);

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @param eventMatcher to match against
     * @return NotificationListenerRegistration
     */
    NotificationListenerRegistration addNotificationListener(NotificationListener listener, EventMatcher eventMatcher);

    /**
     * Method to configure a listener for allowed types.
     *
     * @param listener to configure
     * @param allowed types
     * @return NotificationListenerRegistration
     */
    NotificationListenerRegistration addAllowedTypesNotificationListener(NotificationListener listener, NotificationType... allowed);

    /**
     * Method to configure a listener for ignore types.
     *
     * @param listener to configure
     * @param ignored types
     * @return NotificationListenerRegistration
     */
    NotificationListenerRegistration addIgnoredTypesNotificationListener(NotificationListener listener, NotificationType... ignored);

    /**
     * Method to remove a notification listener.
     *
     * @param listener the listener to remove
     */
    void removeNotificationListener(NotificationListener listener);

    /**
     * Method to register a notificationListener.
     *
     * @param registration to add
     */
    void addNotificationListenerRegistration(NotificationListenerRegistration registration);

    /**
     * Method to remove a notificationListener.
     *
     * @param registration to remove
     */
    void removeNotificationListenerRegistration(NotificationListenerRegistration registration);
}
