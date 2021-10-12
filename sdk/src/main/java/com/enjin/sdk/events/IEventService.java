/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.events;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Platform;

import java.util.concurrent.Future;

/**
 * Interface for an event service for subscribing to and registering for events from the Enjin Cloud.
 */
public interface IEventService {

    /**
     * Starts this service.
     *
     * @return the future for this operation
     */
    Future<Void> start();

    /**
     * Starts this service with the provided platform details.
     *
     * @param platform the platform
     * @return the future for this operation
     */
    Future<Void> start(Platform platform);

    /**
     * Starts this service with the provided connection listener.
     *
     * @param listener the listener
     * @return the future for this operation
     */
    Future<Void> start(IConnectionEventListener listener);

    /**
     * Starts this service with the provided platform details and connection listener.
     *
     * @param platform the platform
     * @param listener the listener
     * @return the future for this operation
     */
    Future<Void> start(Platform platform, IConnectionEventListener listener);

    /**
     * Checks if this service is connected to the platform.
     *
     * @return true if connected, else false
     */
    boolean isConnected();

    /**
     * Shuts down this service.
     *
     * @return the future for this operation
     */
    Future<Void> shutdown();

    /**
     * Registers a event listener and provides the registration object used for it.
     *
     * @param listener the listener
     * @return the registration
     */
    EventListenerRegistration registerListener(IEventListener listener);

    /**
     * Registers a event listener with an event matcher and provides the registration object used for it.
     *
     * @param listener the listener
     * @param matcher the event matcher
     * @return the registration
     */
    EventListenerRegistration registerListenerWithMatcher(IEventListener listener,
                                                          IEventMatcher matcher);

    /**
     * Registers a event listener with event types to allow and provides the registration object used for it.
     *
     * @param listener the listener
     * @param types the events to listen for
     * @return the registration
     */
    EventListenerRegistration registerListenerIncludingTypes(IEventListener listener,
                                                             EventType... types);

    /**
     * Registers a event listener with event types to ignore and provides the registration object used for it.
     *
     * @param listener the listener
     * @param types the events to ignore
     * @return the registration
     */
    EventListenerRegistration registerListenerExcludingTypes(IEventListener listener,
                                                             EventType... types);

    /**
     * Unregisters a event listener.
     *
     * @param listener the listener
     */
    void unregisterListener(IEventListener listener);

    /**
     * Opens a channel for the specified project, allowing listeners to receive events for that project.
     *
     * @param project the project's UUID
     */
    void subscribeToProject(String project);

    /**
     * Closes a channel for the specified project, preventing listeners from receiving events for that project.
     *
     * @param project the project's UUID
     */
    void unsubscribeToProject(String project);

    /**
     * Determines if the channel is open for the specified project.
     *
     * @param project the project's UUID
     * @return true if open, else false
     */
    boolean isSubscribedToProject(String project);

    /**
     * Opens a channel for the specified player, allowing listeners to receive events for that player.
     *
     * @param project the UUID of the project the player is on
     * @param player the player ID
     */
    void subscribeToPlayer(String project, String player);

    /**
     * Closes a channel for the specified player, preventing listeners from receiving events for that player.
     *
     * @param project the UUID of the project the player is on
     * @param player the player ID
     */
    void unsubscribeToPlayer(String project, String player);

    /**
     * Determines if the channel is open for the specified player.
     *
     * @param project the UUID of the project the player is on
     * @param player the player ID
     * @return true if open, else false
     */
    boolean isSubscribedToPlayer(String project, String player);

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
