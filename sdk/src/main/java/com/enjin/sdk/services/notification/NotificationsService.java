package com.enjin.sdk.services.notification;

import com.enjin.sdk.models.notification.EventType;
import com.enjin.sdk.models.platform.PlatformDetails;

/**
 * A notification service interface.
 *
 * @author Evan Lindsay
 */
public interface NotificationsService {

    /**
     * Starts the notification service.
     */
    void start();

    /**
     * Starts the notification with the provided details.
     *
     * @param details the platform details.
     */
    void start(PlatformDetails details);

    boolean isConnected();

    /**
     * Shuts down the notification service.
     */
    void shutdown();

    /**
     * Adds a notification listener.
     *
     * @param listener the listener to add.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListener(NotificationListener listener);

    /**
     * Adds a notification listener with an event matcher.
     *
     * @param listener     the listener to add.
     * @param eventMatcher the event matcher to use.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListenerWithMatcher(NotificationListener listener,
                                                                 EventMatcher eventMatcher);

    /**
     * Adds a notification listener with an array of types to allow.
     *
     * @param listener the listener to add.
     * @param allowed  the events to listen for.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListenerIncludingTypes(NotificationListener listener,
                                                                    EventType... allowed);

    /**
     * Adds a notification listener with an array of types to ignore.
     *
     * @param listener the listener to add.
     * @param ignored  the events to ignore.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListenerExcludingTypes(NotificationListener listener,
                                                                    EventType... ignored);

    /**
     * Removes a notification listener registration.
     *
     * @param registration the registration to remove.
     */
    void unregisterListener(NotificationListener registration);

    void subscribeToApp(int appId);

    void unsubscribeToApp(int appId);

    boolean isSubscribedToApp(int appId);

    void subscribeToUser(int userId);

    void unsubscribeToUser(int userId);

    boolean isSubscribedToUser(int userId);

    /**
     * Opens a channel for the specified identity id, allowing listeners
     * to receive link events for that identity.
     *
     * @param identityId the identity id.
     */
    void subscribeToIdentity(int identityId);

    /**
     * Closes a channel for the specified identity id, preventing listeners
     * from receiving link events for that identity.
     *
     * @param identityId the identity id.
     */
    void unsubscribeToIdentity(int identityId);

    /**
     * Returns whether or not a channel is open for the specified identity id.
     *
     * @param identityId the identity id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToIdentity(int identityId);

    /**
     * Opens a channel for the specified token id, allowing listeners
     * to receive link events for that token.
     *
     * @param tokenId the token id.
     */
    void subscribeToToken(String tokenId);

    /**
     * Closes a channel for the specified token id, preventing listeners
     * from receiving link events for that token.
     *
     * @param tokenId the token id.
     */
    void unsubscribeToToken(String tokenId);

    /**
     * Returns whether or not a channel is open for the specified token id.
     *
     * @param tokenId the token id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToToken(String tokenId);

    /**
     * Opens a channel for the specified Ethereum address, allowing listeners
     * to receive link events for that address.
     *
     * @param ethAddress the Ethereum address.
     */
    void subscribeToWallet(String ethAddress);

    /**
     * Closes a channel for the specified Ethereum address, preventing listeners
     * from receiving link events for that address.
     *
     * @param ethAddress the Ethereum address.
     */
    void unsubscribeToWallet(String ethAddress);

    /**
     * Returns whether or not a channel is open for the specified Ethereum address.
     *
     * @param ethAddress the Ethereum address.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToWallet(String ethAddress);

}
