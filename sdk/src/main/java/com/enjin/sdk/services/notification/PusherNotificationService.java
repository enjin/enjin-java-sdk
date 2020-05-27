package com.enjin.sdk.services.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.enjin.sdk.models.notification.EventType;
import com.enjin.sdk.models.platform.NotificationDetails;
import com.enjin.sdk.models.platform.PlatformDetails;
import com.enjin.sdk.models.platform.PusherDetails;
import com.enjin.sdk.services.notification.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.services.notification.subscriptions.AppChannel;
import com.enjin.sdk.services.notification.subscriptions.IdentityChannel;
import com.enjin.sdk.services.notification.subscriptions.TokenChannel;
import com.enjin.sdk.services.notification.subscriptions.UserChannel;
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
     * Returns the logger provider.
     *
     * @return the logger provider
     */
    @Getter
    private LoggerProvider loggerProvider;
    private PlatformDetails platformDetails;
    private Pusher pusher;
    private PusherEventListener listener;

    private Map<String, Channel> subscribed = new HashMap<>();

    /**
     * Constructs the notification service using the platform details.
     *
     * @param platformDetails the platform details
     */
    public PusherNotificationService(@NonNull PlatformDetails platformDetails) {
        this(new LoggerProvider(Logger.getGlobal()), platformDetails);
    }

    /**
     * Constructs the notification service using the platform details and logger provider.
     *
     * @param loggerProvider  the logger provider
     * @param platformDetails the platform details
     */
    public PusherNotificationService(@NonNull LoggerProvider loggerProvider, @NonNull PlatformDetails platformDetails) {
        this.loggerProvider = loggerProvider;
        this.platformDetails = platformDetails;
    }

    @Override
    public void start() {
        shutdown();

        NotificationDetails notificationDetails = platformDetails.getNotifications();

        if (notificationDetails != null) {
            PusherDetails pusherDetails = notificationDetails.getPusher();
            if (pusherDetails != null) {
                String appKey = pusherDetails.getKey();
                String cluster = pusherDetails.getOptions().getCluster();
                boolean encrypted = pusherDetails.getOptions().getEncrypted();

                if (appKey != null && !appKey.isEmpty() && cluster != null && !cluster.isEmpty()) {
                    PusherOptions options = new PusherOptions()
                            .setCluster(cluster)
                            .setEncrypted(encrypted);
                    pusher = new Pusher(appKey, options);
                    listener = new PusherEventListener(this);

                    pusher.connect(new ConnectionEventListener() {
                        @Override
                        public void onConnectionStateChange(ConnectionStateChange change) {
                            ConnectionState previous = change.getPreviousState();
                            ConnectionState current = change.getCurrentState();
                        }

                        @Override
                        public void onError(String message, String code, Exception e) {
                            loggerProvider.log(Level.SEVERE, "Unable to connect to pusher service.", e);
                        }
                    }, ConnectionState.ALL);
                }
            }
        }
    }

    @Override
    public void start(PlatformDetails details) {
        platformDetails = details;
        start();
    }

    @Override
    public boolean isConnected() {
        return pusher != null && pusher.getConnection().getState() == ConnectionState.CONNECTED;
    }

    @Override
    public void shutdown() {
        if (pusher != null) {
            pusher.disconnect();
        }
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
        NotificationListenerRegistration registration = null;

        for (int i = 0; i < this.listeners.size(); i++) {
            NotificationListenerRegistration reg = this.listeners.get(i);
            if (reg.getListener().equals(configuration.listener)) {
                registration = reg;
                break;
            }
        }

        if (registration == null) {
            registration = configuration.create();
            listeners.add(registration);
        }

        return registration;
    }

    @Override
    public void unregisterListener(@NonNull NotificationListener listener) {
        for (int i = 0; i < this.listeners.size(); i++) {
            NotificationListenerRegistration reg = this.listeners.get(i);
            if (reg.getListener().equals(listener)) {
                this.listeners.remove(i);
                break;
            }
        }
    }

    @Override
    public void subscribeToApp(int appId) {
        subscribe(new AppChannel(platformDetails, appId).channel());
    }

    @Override
    public void unsubscribeToApp(int appId) {
        unsubscribe(new AppChannel(platformDetails, appId).channel());
    }

    @Override
    public boolean isSubscribedToApp(int appId) {
        return subscribed.containsKey(new AppChannel(platformDetails, appId).channel());
    }

    @Override
    public void subscribeToUser(int userId) {
        subscribe(new UserChannel(platformDetails, userId).channel());
    }

    @Override
    public void unsubscribeToUser(int userId) {
        unsubscribe(new UserChannel(platformDetails, userId).channel());
    }

    @Override
    public boolean isSubscribedToUser(int userId) {
        return subscribed.containsKey(new UserChannel(platformDetails, userId).channel());
    }

    @Override
    public void subscribeToIdentity(int identityId) {
        subscribe(new IdentityChannel(platformDetails, identityId).channel());
    }

    @Override
    public void unsubscribeToIdentity(int identityId) {
        unsubscribe(new IdentityChannel(platformDetails, identityId).channel());
    }

    @Override
    public boolean isSubscribedToIdentity(int identityId) {
        return subscribed.containsKey(new IdentityChannel(platformDetails, identityId).channel());
    }

    @Override
    public void subscribeToToken(String tokenId) {
        subscribe(new TokenChannel(platformDetails, tokenId).channel());
    }

    @Override
    public void unsubscribeToToken(String tokenId) {
        unsubscribe(new TokenChannel(platformDetails, tokenId).channel());
    }

    @Override
    public boolean isSubscribedToToken(String tokenId) {
        return subscribed.containsKey(new TokenChannel(platformDetails, tokenId).channel());
    }

    @Override
    public void subscribeToWallet(String ethAddress) {
        subscribe(new WalletChannel(platformDetails, ethAddress).channel());
    }

    @Override
    public void unsubscribeToWallet(String ethAddress) {
        unsubscribe(new WalletChannel(platformDetails, ethAddress).channel());
    }

    @Override
    public boolean isSubscribedToWallet(String ethAddress) {
        return subscribed.containsKey(new WalletChannel(platformDetails, ethAddress).channel());
    }

    private void subscribe(@NonNull String channel) {
        if (pusher == null)
            return;

        if (subscribed.containsKey(channel))
            return;

        Channel pusherChannel = pusher.subscribe(channel);
        subscribed.put(channel, pusherChannel);
        bind(pusherChannel);
    }

    private void unsubscribe(@NonNull String channel) {
        if (pusher == null)
            return;

        if (!subscribed.containsKey(channel))
            return;

        Channel pusherChannel = subscribed.remove(channel);
        unbind(pusherChannel);
        pusher.unsubscribe(channel);
    }

    private void bind(@NonNull Channel channel) {
        for (EventType event : EventType.filterByChannelTypes(channel.getName())) {
            channel.bind(event.getEventType(), this.listener);
        }
    }

    private void unbind(@NonNull Channel channel) {
        for (EventType channelEvent : EventType.filterByChannelTypes(channel.getName())) {
            channel.unbind(channelEvent.getEventType(), this.listener);
        }
    }

}
