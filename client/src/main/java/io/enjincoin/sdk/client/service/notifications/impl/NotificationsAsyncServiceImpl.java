package io.enjincoin.sdk.client.service.notifications.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.enums.NotificationType;
import io.enjincoin.sdk.client.service.notifications.EventMatcher;
import io.enjincoin.sdk.client.service.notifications.NotificationListener;
import io.enjincoin.sdk.client.service.notifications.NotificationListenerRegistration;
import io.enjincoin.sdk.client.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;
import io.enjincoin.sdk.client.service.notifications.NotificationsAsyncService;

import java.util.concurrent.CompletableFuture;

/**
 *
 *<p>NotificationsService - Asynchronous.</p>
 *
 */
public class NotificationsAsyncServiceImpl extends NotificationsServiceImpl implements NotificationsAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public NotificationsAsyncServiceImpl(final Config config) {
        super(config);
    }



    /**
     * Method to initialize the notifications service.
     *
     * @param auth to use
     * @return boolean
     */
    @Override
    public CompletableFuture<Boolean> initNotificationsServiceAsync(final String auth) {
        return CompletableFuture.supplyAsync(() -> initNotificationsService(auth), getExecutorService());
    }

    /**
     * Method to re-initialize the notifications service.
     *
     * @return boolean
     */
    @Override
    public CompletableFuture<Boolean> reInitNotificationsServiceAsync() {
        return CompletableFuture.supplyAsync(() -> reInitNotificationsService(), getExecutorService());
    }

    /**
     * Method to configure a listener.
     *
     * @param listener notificationListener to configure
     * @return RegistrationListenerConfiguration
     */
    @Override
    @SuppressWarnings("rawtypes")
    public CompletableFuture<RegistrationListenerConfiguration> configureListenerAsync(final NotificationListener listener) {
        return CompletableFuture.supplyAsync(() -> configureListener(listener), getExecutorService());
    }

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @return NotificationListenerRegistration
     */
    @Override
    public CompletableFuture<NotificationListenerRegistration> addNotificationListenerAsync(final NotificationListener listener) {
        return CompletableFuture.supplyAsync(() -> addNotificationListener(listener), getExecutorService());
    }

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @param eventMatcher to match against
     * @return NotificationListenerRegistration
     */
    @Override
    public CompletableFuture<NotificationListenerRegistration> addNotificationListenerAsync(final NotificationListener listener,
            final EventMatcher eventMatcher) {
        return CompletableFuture.supplyAsync(() -> addNotificationListener(listener), getExecutorService());
    }

    /**
     * Method to configure a listener for allowed types.
     *
     * @param listener to configure
     * @param allowed types
     * @return NotificationListenerRegistration
     */
    @Override
    public CompletableFuture<NotificationListenerRegistration> addAllowedTypesNotificationListenerAsync(final NotificationListener listener,
            final NotificationType... allowed) {
        return CompletableFuture.supplyAsync(() -> addAllowedTypesNotificationListener(listener, allowed), getExecutorService());
    }

    /**
     * Method to configure a listener for ignore types.
     *
     * @param listener to configure
     * @param ignored types
     * @return NotificationListenerRegistration
     */
    @Override
    public CompletableFuture<NotificationListenerRegistration> addIgnoredTypesNotificationListenerAsync(final NotificationListener listener,
            final NotificationType... ignored) {
        return CompletableFuture.supplyAsync(() -> addIgnoredTypesNotificationListener(listener, ignored), getExecutorService());
    }

    /**
     * Method to remove a notification listener.
     *
     * @param listener the listener to remove
     */
    @Override
    public void removeNotificationListenerAsync(final NotificationListener listener) {
        CompletableFuture.runAsync(() -> removeNotificationListener(listener));
    }

    /**
     * Method to register a notificationListener.
     *
     * @param registration to add
     */
    @Override
    public void addNotificationListenerRegistrationAsync(final NotificationListenerRegistration registration) {
        CompletableFuture.runAsync(() -> addNotificationListenerRegistration(registration));
    }

    /**
     * Method to remove a notificationListener.
     *
     * @param registration to remove
     */
    @Override
    public void removeNotificationListenerRegistrationAsync(final NotificationListenerRegistration registration) {
        CompletableFuture.runAsync(() -> removeNotificationListenerRegistration(registration));
    }

}
