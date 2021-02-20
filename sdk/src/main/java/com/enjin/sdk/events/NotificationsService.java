package com.enjin.sdk.events;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Platform;

/**
 * Notification service interface for subscribing to and registering for events from the Enjin Cloud.
 */
public interface NotificationsService {

    /**
     * Starts this service.
     */
    void start();

    /**
     * Starts this service with the provided platform details.
     *
     * @param platform the platform
     */
    void start(Platform platform);

    /**
     * Checks if this service is connected to the platform.
     *
     * @return true if connected, else false
     */
    boolean isConnected();

    /**
     * Shuts down this service.
     */
    void shutdown();

    /**
     * Registers a notification listener and provides the registration object used for it.
     *
     * @param listener the listener
     * @return the registration
     */
    NotificationListenerRegistration registerListener(NotificationListener listener);

    /**
     * Registers a notification listener with an event matcher and provides the registration object used for it.
     *
     * @param listener the listener
     * @param matcher the event matcher
     * @return the registration
     */
    NotificationListenerRegistration registerListenerWithMatcher(NotificationListener listener,
                                                                 EventMatcher matcher);

    /**
     * Adds a notification listener with event types to allow and provides the registration object used for it.
     *
     * @param listener the listener
     * @param types the events to listen for
     * @return the registration
     */
    NotificationListenerRegistration registerListenerIncludingTypes(NotificationListener listener,
                                                                    EventType... types);

    /**
     * Adds a notification listener with event types to ignore and provides the registration object used for it.
     *
     * @param listener the listener
     * @param types the events to ignore
     * @return the registration
     */
    NotificationListenerRegistration registerListenerExcludingTypes(NotificationListener listener,
                                                                    EventType... types);

    /**
     * Unregisters a notification listener.
     *
     * @param listener the listener
     */
    void unregisterListener(NotificationListener listener);

    /**
     * Opens a channel for the specified project, allowing listeners to receive events for that project.
     *
     * @param project the project ID
     */
    void subscribeToProject(int project);

    /**
     * Closes a channel for the specified project, preventing listeners from receiving events for that project.
     *
     * @param project the project ID
     */
    void unsubscribeToProject(int project);

    /**
     * Determines if the channel is open for the specified project.
     *
     * @param project the project ID
     * @return true if open, else false
     */
    boolean isSubscribedToProject(int project);

    /**
     * Opens a channel for the specified player, allowing listeners to receive events for that identity.
     *
     * @param project the ID of the project the player is on
     * @param player the player ID
     */
    void subscribeToPlayer(int project, String player);

    /**
     * Closes a channel for the specified player, preventing listeners from receiving events for that identity.
     *
     * @param project the ID of the project the player is on
     * @param player the player ID
     */
    void unsubscribeToPlayer(int project, String player);

    /**
     * Determines if the channel is open for the specified player.
     *
     * @param project the ID of the project the player is on
     * @param player the player ID
     * @return true if open, else false
     */
    boolean isSubscribedToPlayer(int project, String player);

    /**
     * Opens a channel for the specified asset, allowing listeners to receive events for that asset.
     *
     * @param asset the asset ID
     */
    void subscribeToAsset(String asset);

    /**
     * Closes a channel for the specified asset, preventing listeners from receiving events for that asset.
     *
     * @param asset the asset ID
     */
    void unsubscribeToAsset(String asset);

    /**
     * Determines if the channel is open for the specified asset.
     *
     * @param asset the asset ID
     * @return true if open, else false
     */
    boolean isSubscribedToAsset(String asset);

    /**
     * Opens a channel for the specified wallet address, allowing listeners to receive events for that wallet.
     *
     * @param wallet the address
     */
    void subscribeToWallet(String wallet);

    /**
     * Closes a channel for the specified wallet address, preventing listeners from receiving events for that wallet.
     *
     * @param wallet the address
     */
    void unsubscribeToWallet(String wallet);

    /**
     * Determines if the channel is open for the specified wallet address.
     *
     * @param wallet the address
     * @return true if open, else false
     */
    boolean isSubscribedToWallet(String wallet);

}
