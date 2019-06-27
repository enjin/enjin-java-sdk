package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;
import com.enjin.enjincoin.sdk.model.service.platform.NotificationDetails;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;
import com.enjin.enjincoin.sdk.model.service.platform.SdkDetails;
import com.enjin.enjincoin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.enjincoin.sdk.service.notifications.subscriptions.AppChannel;
import com.enjin.enjincoin.sdk.service.notifications.subscriptions.IdentityChannel;
import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.StringUtils;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class PusherNotificationService implements NotificationsService {

    private static final String DRIVER = "pusher";

    protected List<NotificationListenerRegistration> listeners = new ArrayList<>();
    private   boolean                                started   = false;
    private   PlatformDetails                        platformDetails;
    private   Pusher                                 pusher;
    private   PusherEventListener                    listener;

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
                String  driver    = sdkDetails.getDriver();
                String  appKey    = sdkDetails.getKey();
                String  cluster   = sdkDetails.getOptions().getCluster();
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
                            ConnectionState current  = change.getCurrentState();

                            PusherNotificationService.log.debug(String.format("State changed from %s to %s.",
                                                                              previous,
                                                                              current));

                            if (current == ConnectionState.CONNECTED) {
                                started = true;
                            } else {
                                started = false;
                            }
                        }

                        @Override
                        public void onError(String message, String code, Exception e) {
                            PusherNotificationService.log.error("Unable to connect to pusher service.", e);
                        }
                    }, ConnectionState.ALL);
                }
            }
        }
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    @Override
    public void start(PlatformDetails details) {
        platformDetails = details;
        start();
    }

    @Override
    public void shutdown() {
        if (!ObjectUtils.isNull(pusher)) {
            pusher.disconnect();
        }
    }

    @Override
    public NotificationListenerRegistration registerListenerWithMatcher(@NonNull NotificationListener listener) {
        return register(NotificationListenerRegistration.configure(listener));
    }

    @Override
    public NotificationListenerRegistration registerListenerWithMatcher(@NonNull NotificationListener listener, EventMatcher eventMatcher) {
        return register(configureListener(listener).withMatcher(eventMatcher));
    }

    @Override
    public NotificationListenerRegistration registerListenerIncludingTypes(@NonNull NotificationListener listener, NotificationType... allowed) {
        return register(configureListener(listener).withAllowedEvents(allowed));
    }

    @Override
    public NotificationListenerRegistration registerListenerExcludingTypes(@NonNull NotificationListener listener, NotificationType... ignored) {
        return register(configureListener(listener).withIgnoredEvents(ignored));
    }

    protected RegistrationListenerConfiguration configureListener(@NonNull NotificationListener listener) {
        return NotificationListenerRegistration.configure(listener);
    }


    protected NotificationListenerRegistration register(@NonNull RegistrationListenerConfiguration configuration) {
        NotificationListenerRegistration registration = this.listeners.stream()
                                                                      .filter(r -> r.getListener().equals(configuration.listener))
                                                                      .findFirst()
                                                                      .orElse(null);

        if (registration == null) {
            registration = configuration.create();
            listeners.add(registration);
        }

        return registration;
    }

    @Override
    public void unregisterListener(@NonNull NotificationListener listener) {
        this.listeners.removeIf(r -> r.getListener().equals(listener));
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
        if (!ObjectUtils.isNull(pusher)) {
            if (!subscribed.containsKey(channel)) {
                Channel pChan = pusher.subscribe(channel);
                subscribed.put(channel, pChan);
                bind(pChan);
            }
        }
    }

    private void unsubscribe(@NonNull String channel) {
        if (!ObjectUtils.isNull(pusher)) {
            if (subscribed.containsKey(channel)) {
                Channel pChan = subscribed.remove(channel);
                unbind(pChan);
                pusher.unsubscribe(channel);
            }
        }
    }

    private void bind(@NonNull Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            PusherNotificationService.log.debug(String.format("Event Channel Bound: %s", channelEvent.getKey()));
            channel.bind(channelEvent.getKey(), this.listener);
        }
    }

    private void unbind(@NonNull Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            PusherNotificationService.log.debug(String.format("Event Channel Unbound: %s", channelEvent.getKey()));
            channel.unbind(channelEvent.getKey(), this.listener);
        }
    }

}
