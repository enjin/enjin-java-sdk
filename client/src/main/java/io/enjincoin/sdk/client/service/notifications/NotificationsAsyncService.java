package io.enjincoin.sdk.client.service.notifications;

import io.enjincoin.sdk.client.enums.NotificationType;
import io.enjincoin.sdk.client.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;

import java.util.concurrent.CompletableFuture;

/**
 *
 *<p>NotificationsService - Asynchronous.</p>
 *
 */
public interface NotificationsAsyncService extends NotificationsService {

    /**
     * Method to initialize the notifications service.
     *
     * @param auth to use
     * @return boolean
     */
    CompletableFuture<Boolean> initNotificationsServiceAsync(String auth);

    /**
     * Method to re-initialize the notifications service.
     *
     * @return boolean
     */
    CompletableFuture<Boolean> reInitNotificationsServiceAsync();

    /**
     * Method to configure a listener.
     *
     * @param listener notificationListener to configure
     * @return RegistrationListenerConfiguration
     */
    @SuppressWarnings("rawtypes")
    CompletableFuture<RegistrationListenerConfiguration> configureListenerAsync(NotificationListener listener);

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @return NotificationListenerRegistration
     */
    CompletableFuture<NotificationListenerRegistration> addNotificationListenerAsync(NotificationListener listener);

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @param eventMatcher to match against
     * @return NotificationListenerRegistration
     */
    CompletableFuture<NotificationListenerRegistration> addNotificationListenerAsync(NotificationListener listener, EventMatcher eventMatcher);

    /**
     * Method to configure a listener for allowed types.
     *
     * @param listener to configure
     * @param allowed types
     * @return NotificationListenerRegistration
     */
    CompletableFuture<NotificationListenerRegistration> addAllowedTypesNotificationListenerAsync(NotificationListener listener, NotificationType... allowed);

    /**
     * Method to configure a listener for ignore types.
     *
     * @param listener to configure
     * @param ignored types
     * @return NotificationListenerRegistration
     */
    CompletableFuture<NotificationListenerRegistration> addIgnoredTypesNotificationListenerAsync(NotificationListener listener, NotificationType... ignored);

    /**
     * Method to remove a notification listener.
     *
     * @param listener the listener to remove
     */
    void removeNotificationListenerAsync(NotificationListener listener);

    /**
     * Method to register a notificationListener.
     *
     * @param registration to add
     */
    void addNotificationListenerRegistrationAsync(NotificationListenerRegistration registration);

    /**
     * Method to remove a notificationListener.
     *
     * @param registration to remove
     */
    void removeNotificationListenerRegistrationAsync(NotificationListenerRegistration registration);
}
