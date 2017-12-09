package com.enjin.coin.sdk.service.notifications.impl;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.EventMatcher;
import com.enjin.coin.sdk.service.notifications.NotificationListener;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.coin.sdk.service.notifications.NotificationsAsyncService;

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
    public CompletableFuture<Boolean> initNotificationsServiceAsync(String auth) {
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
    public CompletableFuture<RegistrationListenerConfiguration> configureListenerAsync(NotificationListener listener) {
        return CompletableFuture.supplyAsync(() -> configureListener(listener), getExecutorService());
    }

    /**
     * Method to add a notification listener.
     *
     * @param listener the listener to add
     * @return NotificationListenerRegistration
     */
    @Override
    public CompletableFuture<NotificationListenerRegistration> addNotificationListenerAsync(NotificationListener listener) {
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
    public CompletableFuture<NotificationListenerRegistration> addNotificationListenerAsync(NotificationListener listener, EventMatcher eventMatcher) {
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
    public CompletableFuture<NotificationListenerRegistration> addAllowedTypesNotificationListenerAsync(NotificationListener listener, NotificationType... allowed){
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
    public CompletableFuture<NotificationListenerRegistration> addIgnoredTypesNotificationListenerAsync(NotificationListener listener, NotificationType... ignored) {
        return CompletableFuture.supplyAsync(() -> addIgnoredTypesNotificationListener(listener, ignored), getExecutorService());
    }

    /**
     * Method to remove a notification listener.
     *
     * @param listener the listener to remove
     */
    @Override
    public void removeNotificationListenerAsync(NotificationListener listener) {
        removeNotificationListenerAsync(listener);
    }

    /**
     * Method to register a notificationListener.
     *
     * @param registration to add
     */
    @Override
    public void addNotificationListenerRegistrationAsync(NotificationListenerRegistration registration) {
        addNotificationListenerRegistration(registration);
    }

    /**
     * Method to remove a notificationListener.
     *
     * @param registration to remove
     */
    @Override
    public void removeNotificationListenerRegistrationAsync(NotificationListenerRegistration registration) {
        removeNotificationListenerRegistration(registration);
    }

}
