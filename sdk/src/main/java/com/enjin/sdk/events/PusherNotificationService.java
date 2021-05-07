package com.enjin.sdk.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @return the logger provider
     */
    @Getter
    private final LoggerProvider loggerProvider;
    private Platform platform;
    private Pusher pusher;
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
     * @param platform the platform
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

        this.pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
            }

            @Override
            public void onError(String message, String code, Exception e) {
                if (loggerProvider != null)
                    loggerProvider.log(LogLevel.SEVERE, "Unable to connect to pusher service.", e);
            }
        }, ConnectionState.ALL);
    }

    @Override
    public void start(Platform platform) {
        this.platform = platform;
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
     * @return the listener configuration
     */
    protected RegistrationListenerConfiguration configureListener(@NonNull NotificationListener listener) {
        return NotificationListenerRegistration.configure(listener);
    }

    /**
     * Registers a notification listener.
     *
     * @param configuration the listener configuration
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

    @Override
    public void subscribeToProject(int project) {
        subscribe(new ProjectChannel(platform, project).channel());
    }

    @Override
    public void unsubscribeToProject(int project) {
        unsubscribe(new ProjectChannel(platform, project).channel());
    }

    @Override
    public boolean isSubscribedToProject(int project) {
        return subscribed.containsKey(new ProjectChannel(platform, project).channel());
    }

    @Override
    public void subscribeToPlayer(int project, String player) {
        subscribe(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public void unsubscribeToPlayer(int project, String player) {
        unsubscribe(new PlayerChannel(platform, project, player).channel());
    }

    @Override
    public boolean isSubscribedToPlayer(int project, String player) {
        return subscribed.containsKey(new PlayerChannel(platform, project, player).channel());
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
        return subscribed.containsKey(new AssetChannel(platform, asset).channel());
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
        return subscribed.containsKey(new WalletChannel(platform, wallet).channel());
    }

    private void subscribe(@NonNull String channel) {
        if (pusher == null || subscribed.containsKey(channel))
            return;

        Channel pusherChannel = pusher.subscribe(channel);
        subscribed.put(channel, pusherChannel);
        bind(pusherChannel);
    }

    private void unsubscribe(@NonNull String channel) {
        if (pusher == null || !subscribed.containsKey(channel))
            return;

        subscribed.remove(channel);
        pusher.unsubscribe(channel);
    }

    private void bind(@NonNull Channel channel) {
        for (EventType event : EventType.filterByChannelTypes(channel.getName()))
            channel.bind(event.getKey(), listener);
    }

}
