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
     * @param matcher the event matcher to use.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListenerWithMatcher(NotificationListener listener,
                                                                 EventMatcher matcher);

    /**
     * Adds a notification listener with an array of types to allow.
     *
     * @param listener the listener to add.
     * @param types  the events to listen for.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListenerIncludingTypes(NotificationListener listener,
                                                                    EventType... types);

    /**
     * Adds a notification listener with an array of types to ignore.
     *
     * @param listener the listener to add.
     * @param types  the events to ignore.
     *
     * @return the listener registration.
     */
    NotificationListenerRegistration registerListenerExcludingTypes(NotificationListener listener,
                                                                    EventType... types);

    /**
     * Removes a notification listener registration.
     *
     * @param registration the registration to remove.
     */
    void unregisterListener(NotificationListener registration);

    /**
     * Opens a channel for the specified application, allowing listeners to receive events for that application.
     *
     * @param app the app id.
     */
    void subscribeToApp(int app);

    /**
     * Closes a channel for the specified application, preventing listeners from receiving events for that application.
     *
     * @param app the app id.
     */
    void unsubscribeToApp(int app);

    /**
     * Returns whether or not a channel is open for the specified application.
     *
     * @param app the app id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToApp(int app);

    /**
     * Opens a channel for the specified player, allowing listeners to receive events for that identity.
     *  @param app the app id.
     * @param player the player id.
     */
    void subscribeToPlayer(int app, String player);

    /**
     * Closes a channel for the specified player, preventing listeners from receiving events for that identity.
     *  @param app the app id.
     * @param player the player id.
     */
    void unsubscribeToPlayer(int app, String player);

    /**
     * Returns whether or not a channel is open for the specified player.
     *
     * @param app the app id.
     * @param player the player id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToPlayer(int app, String player);

    /**
     * Opens a channel for the specified token, allowing listeners to receive events for that token.
     *
     * @param token the token id.
     */
    void subscribeToToken(String token);

    /**
     * Closes a channel for the specified token, preventing listeners from receiving events for that token.
     *
     * @param token the token id.
     */
    void unsubscribeToToken(String token);

    /**
     * Returns whether or not a channel is open for the specified token.
     *
     * @param token the token id.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToToken(String token);

    /**
     * Opens a channel for the specified wallet, allowing listeners to receive events for that wallet.
     *
     * @param wallet the wallet's address.
     */
    void subscribeToWallet(String wallet);

    /**
     * Closes a channel for the specified wallet, preventing listeners from receiving events for that wallet.
     *
     * @param wallet the wallet's address.
     */
    void unsubscribeToWallet(String wallet);

    /**
     * Returns whether or not a channel is open for the specified wallet.
     *
     * @param wallet the wallet's address.
     *
     * @return true if listening, else false.
     */
    boolean isSubscribedToWallet(String wallet);

}
