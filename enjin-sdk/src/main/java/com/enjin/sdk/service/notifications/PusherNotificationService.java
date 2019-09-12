package com.enjin.sdk.service.notifications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.enjin.sdk.model.service.notifications.NotificationType;
import com.enjin.sdk.model.service.platform.NotificationDetails;
import com.enjin.sdk.model.service.platform.PlatformDetails;
import com.enjin.sdk.model.service.platform.SdkDetails;
import com.enjin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.service.notifications.subscriptions.AppChannel;
import com.enjin.sdk.service.notifications.subscriptions.IdentityChannel;
import com.enjin.sdk.service.notifications.subscriptions.UserChannel;
import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.StringUtils;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import lombok.NonNull;
import lombok.extern.java.Log;

@Log
public class PusherNotificationService implements NotificationsService {

    private static final String DRIVER = "pusher";

    protected List<NotificationListenerRegistration> listeners = new ArrayList<>();
    private PlatformDetails platformDetails;
    private Pusher pusher;
    private PusherEventListener listener;

    private Map<String, Channel> subscribed = new HashMap<>();

    public PusherNotificationService(@NonNull PlatformDetails platformDetails) {
        this.platformDetails = platformDetails;
    }

    @Override
    public void start() {
        shutdown();

        NotificationDetails notificationDetails = platformDetails.getNotifications();

        if (notificationDetails != null) {
            SdkDetails sdkDetails = notificationDetails.getSdk();
            if (sdkDetails != null) {
                String driver = sdkDetails.getDriver();
                String appKey = sdkDetails.getKey();
                String cluster = sdkDetails.getOptions().getCluster();
                boolean encrypted = sdkDetails.getOptions().getEncrypted();

                if (DRIVER.equalsIgnoreCase(driver) && !StringUtils.isEmpty(appKey) && !StringUtils.isEmpty(cluster)) {
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

                            PusherNotificationService.log.fine(String.format("State changed from %s to %s.",
                                                                             previous,
                                                                             current));
                        }

                        @Override
                        public void onError(String message, String code, Exception e) {
                            PusherNotificationService.log.log(Level.SEVERE, "Unable to connect to pusher service.", e);
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
        if (!ObjectUtils.isNull(pusher)) {
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
                                                                           NotificationType... allowed) {
        return register(configureListener(listener).withAllowedEvents(allowed));
    }

    @Override
    public NotificationListenerRegistration registerListenerExcludingTypes(@NonNull NotificationListener listener,
                                                                           NotificationType... ignored) {
        return register(configureListener(listener).withIgnoredEvents(ignored));
    }

    protected RegistrationListenerConfiguration configureListener(@NonNull NotificationListener listener) {
        return NotificationListenerRegistration.configure(listener);
    }


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
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            PusherNotificationService.log.fine(String.format("Event Channel Bound: %s", channelEvent.getKey()));
            channel.bind(channelEvent.getKey(), this.listener);
        }
    }

    private void unbind(@NonNull Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            PusherNotificationService.log.fine(String.format("Event Channel Unbound: %s", channelEvent.getKey()));
            channel.unbind(channelEvent.getKey(), this.listener);
        }
    }

    public static Logger logger() {
        return log;
    }

}
