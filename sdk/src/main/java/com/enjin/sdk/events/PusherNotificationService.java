package com.enjin.sdk.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Notifications;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.events.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.events.channels.ProjectChannel;
import com.enjin.sdk.events.channels.PlayerChannel;
import com.enjin.sdk.events.channels.AssetChannel;
import com.enjin.sdk.events.channels.WalletChannel;
import com.enjin.sdk.utils.LogLevel;
import com.enjin.sdk.utils.LoggerProvider;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.connection.ConnectionEventListener;
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
    private Platform platform;
    private Pusher pusher;
    private ConnectionEventListener connectionEventListener;
    private PusherEventListener listener;

    private final Map<String, Channel> subscribed = new HashMap<>();

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
    }

    @Override
    public void start() {
        shutdown();

        Notifications notifications = platform.getNotifications();
        if (notifications == null)
            return;

        com.enjin.sdk.models.Pusher pusher = notifications.getPusher();
        if (pusher == null)
            return;

        String key = pusher.getKey();
        String cluster = pusher.getOptions().getCluster();
        boolean encrypted = pusher.getOptions().getEncrypted();
        if (key == null || key.isEmpty() || cluster == null || cluster.isEmpty())
            return;

        PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setUseTLS(encrypted);
        this.pusher = new Pusher(key, options);
        listener = new PusherEventListener(this);

        this.pusher.connect(new com.pusher.client.connection.ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
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
                if (loggerProvider != null)
                    loggerProvider.log(LogLevel.SEVERE, "Error on Pusher client: ", e);
                if (connectionEventListener != null)
                    connectionEventListener.onError(new Exception(String.format("message: %s; code: %s", message, code), e));
            }
        }, ConnectionState.ALL);

        resubscribeToAll();
    }

    @Override
    public void start(Platform platform) {
        this.platform = platform;
        start();
    }

    @Override
    public void start(ConnectionEventListener listener) {
        connectionEventListener = listener;
        start();
    }

    @Override
    public void start(Platform platform, ConnectionEventListener listener) {
        this.platform = platform;
        connectionEventListener = listener;
        start();
    }

    @Override
    public boolean isConnected() {
        return pusher != null && pusher.getConnection().getState() == ConnectionState.CONNECTED;
    }

    @Override
    public void shutdown() {
        if (pusher != null)
            pusher.disconnect();
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
     *     The future returned by this method may never complete of this service does not successfully subscribe to the
     *     requested channel.
     * </p>
     *
     * @param project the project ID
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
     *     The future returned by this method may never complete of this service does not successfully subscribe to the
     *     requested channel.
     * </p>
     *
     * @param project the ID of the project the player is on
     * @param player the player ID
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
     *     The future returned by this method may never complete of this service does not successfully subscribe to the
     *     requested channel.
     * </p>
     *
     * @param asset the asset ID
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
     *     The future returned by this method may never complete of this service does not successfully subscribe to the
     *     requested channel.
     * </p>
     *
     * @param wallet the address
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

        synchronized (subscribed) {
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

    private void resubscribeToAll() {
        Set<String> channels = new HashSet<>(subscribed.keySet());
        subscribed.clear();

        for (String channel : channels) {
            subscribe(channel);
        }
    }

    private Future<Void> unsubscribe(@NonNull String channel) {
        if (pusher == null)
            return failedFuture(new IllegalStateException("Event service has not been started."));

        return CompletableFuture.supplyAsync(() -> {
            synchronized (subscribed) {
                if (!subscribed.containsKey(channel))
                    return null;

                subscribed.remove(channel);
            }

            pusher.unsubscribe(channel);

            return null;
        });
    }

    private boolean isSubscribed(@NonNull String channel) {
        synchronized (subscribed) {
            return subscribed.containsKey(channel);
        }
    }

    private void bind(@NonNull Channel channel) {
        for (EventType event : EventType.filterByChannelTypes(channel.getName()))
            channel.bind(event.getKey(), listener);
    }

    private static <T> Future<T> failedFuture(Throwable e) {
        CompletableFuture<T> future = new CompletableFuture<>();
        future.completeExceptionally(e);
        return future;
    }

}
