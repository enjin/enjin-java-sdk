package com.enjin.sdk.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Notifications;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.events.NotificationListenerRegistration.RegistrationListenerConfiguration;
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
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import lombok.Getter;
import lombok.NonNull;

/**
 * Implementation class of {@link NotificationsService} utilizing Pusher channel events.
 *
 * @see NotificationListener
 */
public class PusherNotificationService implements NotificationsService {

    /**
     * The list of listener registrations.
     */
    protected List<NotificationListenerRegistration> listeners = new ArrayList<>();

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
    private ConnectionEventListener connectionEventListener;

    // Mutexes
    private final Object subscribedMutex = new Object();

    /**
     * Constructs the notification service using the platform details.
     *
     * @param platform the platform
     */
    public PusherNotificationService(@NonNull Platform platform) {
        this(platform, null);
    }

    /**
     * Constructs the notification service using the platform details and logger provider.
     *
     * @param platform       the platform
     * @param loggerProvider the logger provider
     */
    public PusherNotificationService(@NonNull Platform platform, LoggerProvider loggerProvider) {
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
        pusherConnectionListener.appendConnectAction(() -> {
            try {
                resubscribeToAll().get();
            } catch (Exception e) {
                throw new RuntimeException("Failed to resubscribe to all channels.", e);
            }
        });

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
                    loggerProvider.log(LogLevel.SEVERE, "Error on Pusher client: ", e);
                if (connectionEventListener != null)
                    connectionEventListener.onError(newException);
            }
        }, ConnectionState.ALL);

        return pusherConnectionListener.getConnectFuture();
    }

    @Override
    public Future<Void> start(Platform platform) {
        this.platform = platform;
        return start();
    }

    @Override
    public Future<Void> start(ConnectionEventListener listener) {
        connectionEventListener = listener;
        return start();
    }

    @Override
    public Future<Void> start(Platform platform, ConnectionEventListener listener) {
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
    public NotificationListenerRegistration registerListener(@NonNull NotificationListener listener) {
        return register(NotificationListenerRegistration.configure(listener));
    }

    @Override
    public NotificationListenerRegistration registerListenerWithMatcher(@NonNull NotificationListener listener,
                                                                        EventMatcher matcher) {
        return register(configureListener(listener).withMatcher(matcher));
    }

    @Override
    public NotificationListenerRegistration registerListenerIncludingTypes(@NonNull NotificationListener listener,
                                                                           EventType... types) {
        return register(configureListener(listener).withAllowedEvents(types));
    }

    @Override
    public NotificationListenerRegistration registerListenerExcludingTypes(@NonNull NotificationListener listener,
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
    protected RegistrationListenerConfiguration configureListener(@NonNull NotificationListener listener) {
        return NotificationListenerRegistration.configure(listener);
    }

    /**
     * Registers a notification listener.
     *
     * @param configuration the listener configuration
     *
     * @return the registration wrapper, or null if registration failed
     */
    protected NotificationListenerRegistration register(@NonNull RegistrationListenerConfiguration configuration) {
        for (NotificationListenerRegistration reg : listeners) {
            if (reg.getListener().equals(configuration.listener))
                return reg;
        }

        NotificationListenerRegistration registration = configuration.create();
        listeners.add(registration);

        return registration;
    }

    @Override
    public void unregisterListener(@NonNull NotificationListener listener) {
        for (int i = 0; i < listeners.size(); i++) {
            NotificationListenerRegistration reg = listeners.get(i);
            if (reg.getListener().equals(listener)) {
                listeners.remove(i);
                return;
            }
        }
    }

    /**
     * Opens a channel for the specified project, allowing listeners to receive events for that project.
     * <p>
     * The future returned by this method may never complete if this service does not successfully subscribe to the
     * requested channel.
     * </p>
     *
     * @param project the project ID
     *
     * @return the future for this operation
     */
    @Override
    public Future<Void> subscribeToProject(int project) {
        return subscribe(new ProjectChannel(platform, project).channel());
    }

    @Override
    public Future<Void> unsubscribeToProject(int project) {
        return unsubscribe(new ProjectChannel(platform, project).channel());
    }

    @Override
    public boolean isSubscribedToProject(int project) {
        return isSubscribed(new ProjectChannel(platform, project).channel());
    }

    /**
     * Opens a channel for the specified player, allowing listeners to receive events for that player.
     * <p>
     * The future returned by this method may never complete if this service does not successfully subscribe to the
     * requested channel.
     * </p>
     *
     * @param project the ID of the project the player is on
     * @param player  the player ID
     *
     * @return the future for this operation
     */
    @Override
    public Future<Void> subscribeToPlayer(int project, String player) {
        return subscribe(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public Future<Void> unsubscribeToPlayer(int project, String player) {
        return unsubscribe(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public boolean isSubscribedToPlayer(int project, String player) {
        return isSubscribed(new PlayerChannel(platform, project, player).channel());
    }

    /**
     * Opens a channel for the specified asset, allowing listeners to receive events for that asset.
     * <p>
     * The future returned by this method may never complete if this service does not successfully subscribe to the
     * requested channel.
     * </p>
     *
     * @param asset the asset ID
     *
     * @return the future for this operation
     */
    @Override
    public Future<Void> subscribeToAsset(String asset) {
        return subscribe(new AssetChannel(platform, asset).channel());
    }

    @Override
    public Future<Void> unsubscribeToAsset(String asset) {
        return unsubscribe(new AssetChannel(platform, asset).channel());
    }

    @Override
    public boolean isSubscribedToAsset(String asset) {
        return isSubscribed(new AssetChannel(platform, asset).channel());
    }

    /**
     * Opens a channel for the specified wallet address, allowing listeners to receive events for that wallet.
     * <p>
     * The future returned by this method may never complete if this service does not successfully subscribe to the
     * requested channel.
     * </p>
     *
     * @param wallet the address
     *
     * @return the future for this operation
     */
    @Override
    public Future<Void> subscribeToWallet(String wallet) {
        return subscribe(new WalletChannel(platform, wallet).channel());
    }

    @Override
    public Future<Void> unsubscribeToWallet(String wallet) {
        return unsubscribe(new WalletChannel(platform, wallet).channel());
    }

    @Override
    public boolean isSubscribedToWallet(String wallet) {
        return isSubscribed(new WalletChannel(platform, wallet).channel());
    }

    private Future<Void> subscribe(@NonNull String channel) {
        if (pusher == null)
            return failedFuture(new IllegalStateException("Event service has not been started."));

        CompletableFuture<Void> future = new CompletableFuture<>();

        Channel pusherChannel;

        synchronized (subscribedMutex) {
            if (subscribed.containsKey(channel))
                return CompletableFuture.completedFuture(null);

            pusherChannel = pusher.subscribe(channel, new ChannelEventListener() {
                @Override
                public void onSubscriptionSucceeded(String channelName) {
                    future.complete(null);
                }

                @Override
                public void onEvent(PusherEvent event) { }
            });

            subscribed.put(channel, pusherChannel);
        }

        bind(pusherChannel);

        return future;
    }

    private Future<Void> resubscribeToAll() {
        return CompletableFuture.runAsync(() -> {
            Set<String> channels;

            synchronized (subscribedMutex) {
                channels = new HashSet<>(subscribed.keySet());
                subscribed.clear();
            }

            for (String channel : channels) {
                try {
                    subscribe(channel).get(3000, TimeUnit.MILLISECONDS); // 3 second timeout
                } catch (Exception e) {
                    throw new RuntimeException(String.format("Failed to subscribe to channel %s.", channel), e);
                }
            }
        });
    }

    private Future<Void> unsubscribe(@NonNull String channel) {
        if (pusher == null)
            return failedFuture(new IllegalStateException("Event service has not been started."));

        return CompletableFuture.runAsync(() -> {
            synchronized (subscribedMutex) {
                if (!subscribed.containsKey(channel))
                    return;

                subscribed.remove(channel);
            }

            pusher.unsubscribe(channel);
        });
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

}
