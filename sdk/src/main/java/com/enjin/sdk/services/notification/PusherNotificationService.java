package com.enjin.sdk.services.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Notifications;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.services.notification.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.services.notification.subscriptions.AppChannel;
import com.enjin.sdk.services.notification.subscriptions.PlayerChannel;
import com.enjin.sdk.services.notification.subscriptions.TokenChannel;
import com.enjin.sdk.services.notification.subscriptions.WalletChannel;
import com.enjin.sdk.utils.LoggerProvider;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import lombok.Getter;
import lombok.NonNull;

/**
 * Implementation class of {@link NotificationsService} for Pusher events.
 *
 * @see NotificationsService
 * @see PusherEvent
 * @see PusherEventListener
 */
public class PusherNotificationService implements NotificationsService {

    /**
     * The list of registered listeners.
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
        this(new LoggerProvider(Logger.getGlobal()), platform);
    }

    /**
     * Constructs the notification service using the platform details and logger provider.
     *
     * @param loggerProvider  the logger provider
     * @param platform the platform
     */
    public PusherNotificationService(@NonNull LoggerProvider loggerProvider, @NonNull Platform platform) {
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
                loggerProvider.log(Level.SEVERE, "Unable to connect to pusher service.", e);
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
                                                                        EventMatcher eventMatcher) {
        return register(configureListener(listener).withMatcher(eventMatcher));
    }

    @Override
    public NotificationListenerRegistration registerListenerIncludingTypes(@NonNull NotificationListener listener,
                                                                           EventType... allowed) {
        return register(configureListener(listener).withAllowedEvents(allowed));
    }

    @Override
    public NotificationListenerRegistration registerListenerExcludingTypes(@NonNull NotificationListener listener,
                                                                           EventType... ignored) {
        return register(configureListener(listener).withIgnoredEvents(ignored));
    }

    /**
     * Configures a notification listener.
     *
     * @param listener the listener
     * @return         the listener configuration
     */
    protected RegistrationListenerConfiguration configureListener(@NonNull NotificationListener listener) {
        return NotificationListenerRegistration.configure(listener);
    }

    /**
     * Registers a notification listener.
     *
     * @param configuration the listener configuration
     * @return              the registration wrapper, or null if registration failed
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
    public void subscribeToApp(int appId) {
        subscribe(new AppChannel(platform, appId).channel());
    }

    @Override
    public void unsubscribeToApp(int appId) {
        unsubscribe(new AppChannel(platform, appId).channel());
    }

    @Override
    public boolean isSubscribedToApp(int appId) {
        return subscribed.containsKey(new AppChannel(platform, appId).channel());
    }

    @Override
    public void subscribeToPlayer(int appId, int playerId) {
        subscribe(new PlayerChannel(platform, appId, playerId).channel());
    }

    @Override
    public void unsubscribeToPlayer(int appId, int playerId) {
        unsubscribe(new PlayerChannel(platform, appId, playerId).channel());
    }

    @Override
    public boolean isSubscribedToPlayer(int appId, int playerId) {
        return subscribed.containsKey(new PlayerChannel(platform, appId, playerId).channel());
    }

    @Override
    public void subscribeToToken(String tokenId) {
        subscribe(new TokenChannel(platform, tokenId).channel());
    }

    @Override
    public void unsubscribeToToken(String tokenId) {
        unsubscribe(new TokenChannel(platform, tokenId).channel());
    }

    @Override
    public boolean isSubscribedToToken(String tokenId) {
        return subscribed.containsKey(new TokenChannel(platform, tokenId).channel());
    }

    @Override
    public void subscribeToWallet(String ethAddress) {
        subscribe(new WalletChannel(platform, ethAddress).channel());
    }

    @Override
    public void unsubscribeToWallet(String ethAddress) {
        unsubscribe(new WalletChannel(platform, ethAddress).channel());
    }

    @Override
    public boolean isSubscribedToWallet(String ethAddress) {
        return subscribed.containsKey(new WalletChannel(platform, ethAddress).channel());
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

        Channel pusherChannel = subscribed.remove(channel);
        unbind(pusherChannel);
        pusher.unsubscribe(channel);
    }

    private void bind(@NonNull Channel channel) {
        for (EventType event : EventType.filterByChannelTypes(channel.getName()))
            channel.bind(event.getEventType(), listener);
    }

    private void unbind(@NonNull Channel channel) {
        for (EventType channelEvent : EventType.filterByChannelTypes(channel.getName()))
            channel.unbind(channelEvent.getEventType(), listener);
    }

}
