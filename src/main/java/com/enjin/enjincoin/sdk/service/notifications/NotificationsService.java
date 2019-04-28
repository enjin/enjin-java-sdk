package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;
import com.enjin.enjincoin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;

import java.math.BigInteger;

/**
 * A notification service interface.
 *
 * @author Evan Lindsay
 */
public interface NotificationsService extends AsynchronousNotificationsService {

    /**
     * Starts the notification service.
     *
     * @return true if started, else false.
     */
    boolean start();

    /**
     * Restarts the notification service.
     *
     * @return true if started, else false.
     */
    boolean restart();

    /**
     * Shuts down the notification service.
     */
    void shutdown();

    /**
     * Configures a notification listener.
     *
     * @param listener the listener to configure.
     *
     * @return the listener configuration.
     */
    RegistrationListenerConfiguration configureListener(NotificationListener listener);

    /**
     * Adds a notification listener.
     *
     * @param listener the listener to add.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration addNotificationListener(NotificationListener listener);

    /**
     * Adds a notification listener with an event matcher.
     *
     * @param listener     the listener to add.
     * @param eventMatcher the event matcher to use.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration addNotificationListener(NotificationListener listener, EventMatcher eventMatcher);

    /**
     * Adds a notification listener with an array of types to allow.
     *
     * @param listener the listener to add.
     * @param allowed  the events to listen for.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration addAllowedTypesNotificationListener(NotificationListener listener,
                                                                         NotificationType... allowed);

    /**
     * Adds a notification listener with an array of types to ignore.
     *
     * @param listener the listener to add.
     * @param ignored  the events to ignore.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration addIgnoredTypesNotificationListener(NotificationListener listener,
                                                                         NotificationType... ignored);

    /**
     * Removes a listener.
     *
     * @param listener the listener to remove.
     */
    void removeNotificationListener(NotificationListener listener);

    /**
     * Adds a notification listener registration.
     *
     * @param registration the registration to add.
     */
    void addNotificationListenerRegistration(NotificationListenerRegistration registration);

    /**
     * Removes a notification listener registration.
     *
     * @param registration the registration to remove.
     */
    void removeNotificationListenerRegistration(NotificationListenerRegistration registration);

    /**
     * Opens a channel for the specified identity id, allowing listeners
     * to receive link events for that identity.
     *
     * @param identityId the identity id.
     */
    void listenForLink(BigInteger identityId);

    /**
     * Closes a channel for the specified identity id, preventing listeners
     * from receiving link events for that identity.
     *
     * @param identityId the identity id.
     */
    void stopListeningForLink(BigInteger identityId);

    /**
     * Returns whether or not a channel is open for the specified identity id.
     *
     * @param identityId the identity id.
     *
     * @return true if listening, else false.
     */
    boolean isListeningForLink(BigInteger identityId);

}
