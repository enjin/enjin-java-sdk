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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Notifications;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.events.EventListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.events.channels.ProjectChannel;
import com.enjin.sdk.events.channels.PlayerChannel;
import com.enjin.sdk.events.channels.AssetChannel;
import com.enjin.sdk.events.channels.WalletChannel;
import static com.enjin.sdk.utils.FutureUtil.failedFuture;
import com.enjin.sdk.utils.LogLevel;
import com.enjin.sdk.utils.LoggerProvider;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import lombok.Getter;
import lombok.NonNull;

/**
 * Implementation class of {@link IEventService} utilizing Pusher channel events.
 *
 * @see IEventListener
 */
public class PusherEventService implements IEventService {

    /**
     * The list of listener registrations.
     */
    protected List<EventListenerRegistration> listeners = new ArrayList<>();

    /**
     * -- GETTER --
     *
     * @return the logger provider
     */
    @Getter
    private final LoggerProvider loggerProvider;
    private final Map<String, Channel> subscribed = new HashMap<>();
    private Platform platform;
    private Pusher pusher;

    // Listeners
    private final PusherEventListener pusherEventListener;
    private PusherConnectionEventListener pusherConnectionListener;
    private IConnectionEventListener connectionEventListener;

    // Mutexes
    private final Object subscribedMutex = new Object();

    private PusherEventService(@NonNull Platform platform, LoggerProvider loggerProvider) {
        this.loggerProvider = loggerProvider;
        this.platform = platform;
        this.pusherEventListener = new PusherEventListener(this);
    }

    @Override
    public Future<Void> start() {
        shutdown();

        Notifications notifications = platform.getNotifications();
        if (notifications == null)
            return failedFuture(new IllegalStateException("Platform has null data for 'notifications'."));

        com.enjin.sdk.models.Pusher pusher = notifications.getPusher();
        if (pusher == null)
            return failedFuture(new IllegalStateException("Platform has null data for 'pusher'."));

        String key = pusher.getKey();
        String cluster = pusher.getOptions().getCluster();
        boolean encrypted = pusher.getOptions().getEncrypted();
        if (key == null || key.isEmpty() || cluster == null || cluster.isEmpty())
            return failedFuture(new IllegalStateException("Platform has null data for 'key', 'cluster', or 'encrypted'."));

        PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setUseTLS(encrypted);
        this.pusher = new Pusher(key, options);

        // Set up Pusher connection event listener
        pusherConnectionListener = new PusherConnectionEventListener();

        this.pusher.connect(new com.pusher.client.connection.ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
                pusherConnectionListener.onConnectionStateChange(change);

                if (connectionEventListener == null)
                    return;

                switch (change.getCurrentState()) {
                    case CONNECTED:
                        connectionEventListener.onConnect();
                        break;
                    case DISCONNECTED:
                        connectionEventListener.onDisconnect();
                        break;
                }
            }

            @Override
            public void onError(String message, String code, Exception e) {
                Exception newException = new Exception(String.format("msg: %s; code: %s", message, code), e);

                pusherConnectionListener.onError(message, code, newException);

                if (loggerProvider != null)
                    loggerProvider.log(LogLevel.ERROR, "Error on Pusher client: ", newException);
                if (connectionEventListener != null)
                    connectionEventListener.onError(newException);
            }
        }, ConnectionState.ALL);

        resubscribeToAll();

        return pusherConnectionListener.getConnectFuture();
    }

    @Override
    public Future<Void> start(Platform platform) {
        this.platform = platform;
        return start();
    }

    @Override
    public Future<Void> start(IConnectionEventListener listener) {
        connectionEventListener = listener;
        return start();
    }

    @Override
    public Future<Void> start(Platform platform, IConnectionEventListener listener) {
        this.platform = platform;
        connectionEventListener = listener;
        return start();
    }

    @Override
    public boolean isConnected() {
        return pusher != null && pusher.getConnection().getState() == ConnectionState.CONNECTED;
    }

    @Override
    public Future<Void> shutdown() {
        if (pusher == null)
            return failedFuture(new IllegalStateException("Event service has not been started."));

        pusher.disconnect();
        return pusherConnectionListener.getDisconnectFuture();
    }

    @Override
    public EventListenerRegistration registerListener(@NonNull IEventListener listener) {
        return register(EventListenerRegistration.configure(listener));
    }

    @Override
    public EventListenerRegistration registerListenerWithMatcher(@NonNull IEventListener listener,
                                                                 IEventMatcher matcher) {
        return register(configureListener(listener).withMatcher(matcher));
    }

    @Override
    public EventListenerRegistration registerListenerIncludingTypes(@NonNull IEventListener listener,
                                                                    EventType... types) {
        return register(configureListener(listener).withAllowedEvents(types));
    }

    @Override
    public EventListenerRegistration registerListenerExcludingTypes(@NonNull IEventListener listener,
                                                                    EventType... types) {
        return register(configureListener(listener).withIgnoredEvents(types));
    }

    /**
     * Configures a notification listener.
     *
     * @param listener the listener
     *
     * @return the listener configuration
     */
    protected RegistrationListenerConfiguration configureListener(@NonNull IEventListener listener) {
        return EventListenerRegistration.configure(listener);
    }

    /**
     * Registers a notification listener.
     *
     * @param configuration the listener configuration
     *
     * @return the registration wrapper, or null if registration failed
     */
    protected EventListenerRegistration register(@NonNull RegistrationListenerConfiguration configuration) {
        for (EventListenerRegistration reg : listeners) {
            if (reg.getListener().equals(configuration.listener))
                return reg;
        }

        EventListenerRegistration registration = configuration.create();
        listeners.add(registration);

        return registration;
    }

    @Override
    public void unregisterListener(@NonNull IEventListener listener) {
        for (int i = 0; i < listeners.size(); i++) {
            EventListenerRegistration reg = listeners.get(i);
            if (reg.getListener().equals(listener)) {
                listeners.remove(i);
                return;
            }
        }
    }

    @Override
    public void subscribeToProject(String project) {
        subscribe(new ProjectChannel(platform, project).channel());
    }

    @Override
    public void unsubscribeToProject(String project) {
        unsubscribe(new ProjectChannel(platform, project).channel());
    }

    @Override
    public boolean isSubscribedToProject(String project) {
        return isSubscribed(new ProjectChannel(platform, project).channel());
    }

    @Override
    public void subscribeToPlayer(String project, String player) {
        subscribe(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public void unsubscribeToPlayer(String project, String player) {
        unsubscribe(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public boolean isSubscribedToPlayer(String project, String player) {
        return isSubscribed(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public void subscribeToAsset(String asset) {
        subscribe(new AssetChannel(platform, asset).channel());
    }

    @Override
    public void unsubscribeToAsset(String asset) {
        unsubscribe(new AssetChannel(platform, asset).channel());
    }

    @Override
    public boolean isSubscribedToAsset(String asset) {
        return isSubscribed(new AssetChannel(platform, asset).channel());
    }

    @Override
    public void subscribeToWallet(String wallet) {
        subscribe(new WalletChannel(platform, wallet).channel());
    }

    @Override
    public void unsubscribeToWallet(String wallet) {
        unsubscribe(new WalletChannel(platform, wallet).channel());
    }

    @Override
    public boolean isSubscribedToWallet(String wallet) {
        return isSubscribed(new WalletChannel(platform, wallet).channel());
    }

    private void subscribe(@NonNull String channel) {
        if (pusher == null)
            return;

        Channel pusherChannel;

        synchronized (subscribedMutex) {
            if (subscribed.containsKey(channel))
                return;

            pusherChannel = pusher.subscribe(channel);

            subscribed.put(channel, pusherChannel);
        }

        bind(pusherChannel);
    }

    private void resubscribeToAll() {
        Set<String> channels;

        synchronized (subscribedMutex) {
            channels = new HashSet<>(subscribed.keySet());
            subscribed.clear();
        }

        for (String channel : channels) {
            subscribe(channel);
        }
    }

    private void unsubscribe(@NonNull String channel) {
        if (pusher == null)
            return;

        synchronized (subscribedMutex) {
            if (!subscribed.containsKey(channel))
                return;

            subscribed.remove(channel);
        }

        pusher.unsubscribe(channel);
    }

    private boolean isSubscribed(@NonNull String channel) {
        synchronized (subscribedMutex) {
            return subscribed.containsKey(channel);
        }
    }

    private void bind(@NonNull Channel channel) {
        for (EventType event : EventType.filterByChannelTypes(channel.getName()))
            channel.bind(event.getKey(), pusherEventListener);
    }

    /**
     * Creates a builder for this class.
     *
     * @return The builder.
     */
    public static PusherEventServiceBuilder builder() {
        return new PusherEventServiceBuilder();
    }

    /**
     * Builder class for {@link PusherEventService}.
     */
    public static class PusherEventServiceBuilder {

        private LoggerProvider loggerProvider;
        private Platform platform;

        private PusherEventServiceBuilder() {
        }

        /**
         * Builds the service.
         *
         * @return The service.
         *
         * @throws IllegalStateException Thrown if platform is a null value at the time this method is called.
         */
        public PusherEventService build() throws IllegalStateException {
            if (platform == null)
                throw new IllegalStateException(String.format("Cannot build %s with null platform",
                                                              PusherEventService.class.getName()));

            return new PusherEventService(platform, loggerProvider);
        }

        /**
         * Sets the logger provider for the service to use.
         *
         * @param loggerProvider The logger provider.
         *
         * @return This builder for chaining.
         */
        public PusherEventServiceBuilder loggerProvider(LoggerProvider loggerProvider) {
            this.loggerProvider = loggerProvider;
            return this;
        }

        /**
         * Sets the platform data the service will be using.
         *
         * @param platform The platform.
         *
         * @return This builder for chaining.
         */
        public PusherEventServiceBuilder platform(Platform platform) {
            this.platform = platform;
            return this;
        }

    }

}
