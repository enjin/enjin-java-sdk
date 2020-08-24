package com.enjin.sdk.events;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Platform;

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
     * @param platform the platform.
     */
    void start(Platform platform);

    /**
     * Checks if the service is connected to the platform.
     *
     * @return true if connected, else false.
     */
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

    /**
     * Opens a channel for the specified application, allowing listeners to receive events for that application.
     *
     * @param appId the app id.
     */
    void subscribeToApp(int appId);

    /**
     * Closes a channel for the specified application, preventing listeners from receiving events for that application.
     *
     * @param appId the app id.
     */
    void unsubscribeToApp(int appId);

    /**
     * Returns whether or not a channel is open for the specified application.
     *
     * @param appId the app id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToApp(int appId);

    /**
     * Opens a channel for the specified player, allowing listeners to receive events for that identity.
     *  @param appId the app id.
     * @param playerId the player id.
     */
    void subscribeToPlayer(int appId, String playerId);

    /**
     * Closes a channel for the specified player, preventing listeners from receiving events for that identity.
     *  @param appId the app id.
     * @param playerId the player id.
     */
    void unsubscribeToPlayer(int appId, String playerId);

    /**
     * Returns whether or not a channel is open for the specified player.
     *
     * @param appId the app id.
     * @param playerId the player id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToPlayer(int appId, String playerId);

    /**
     * Opens a channel for the specified token, allowing listeners to receive events for that token.
     *
     * @param tokenId the token id.
     */
    void subscribeToToken(String tokenId);

    /**
     * Closes a channel for the specified token, preventing listeners from receiving events for that token.
     *
     * @param tokenId the token id.
     */
    void unsubscribeToToken(String tokenId);

    /**
     * Returns whether or not a channel is open for the specified token.
     *
     * @param tokenId the token id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToToken(String tokenId);

    /**
     * Opens a channel for the specified wallet, allowing listeners to receive events for that wallet.
     *
     * @param ethAddress the Ethereum address.
     */
    void subscribeToWallet(String ethAddress);

    /**
     * Closes a channel for the specified wallet, preventing listeners from receiving events for that wallet.
     *
     * @param ethAddress the Ethereum address.
     */
    void unsubscribeToWallet(String ethAddress);

    /**
     * Returns whether or not a channel is open for the specified wallet.
     *
     * @param ethAddress the Ethereum address.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToWallet(String ethAddress);

}
