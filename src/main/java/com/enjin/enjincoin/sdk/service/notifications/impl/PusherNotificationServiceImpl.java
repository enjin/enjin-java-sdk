package com.enjin.enjincoin.sdk.service.notifications.impl;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationEvent;
import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;
import com.enjin.enjincoin.sdk.model.service.platform.NotificationDetails;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;
import com.enjin.enjincoin.sdk.model.service.platform.SdkDetails;
import com.enjin.enjincoin.sdk.service.notifications.ChannelEvent;
import com.enjin.enjincoin.sdk.service.notifications.NotificationListenerRegistration;
import com.enjin.enjincoin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.java_commons.CollectionUtils;
import com.enjin.java_commons.ExceptionUtils;
import com.enjin.java_commons.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PusherNotificationServiceImpl implements ThirdPartyNotificationService {

    private static final Logger LOGGER           = Logger.getLogger(PusherNotificationServiceImpl.class.getName());
    private static final Long   ACTIVITY_TIMEOUT = 4000L;

    private Gson                                   gson                              = new GsonBuilder().create();
    private int                                    appId;
    private Pusher                                 pusher;
    private Channel                                channel;
    private List<NotificationListenerRegistration> notificationListenerRegistrations = new ArrayList<>();
    private PlatformDetails                        platformDetails;
    private PusherListener                         pusherListener;
    private Map<String, Channel>                   identityChannels                  = new HashMap<>();

    public PusherNotificationServiceImpl(PlatformDetails platformDetails, int appId) {
        this.platformDetails = platformDetails;
        this.appId = appId;
        this.pusherListener = new PusherListener(this);
    }

    @Override
    public boolean init() {
        boolean initializeResult = false;

        if (this.platformDetails.getNotifications() == null) {
            LOGGER.warning("notificationDetails are null");
            return initializeResult;
        }

        NotificationDetails notificationDetails = this.platformDetails.getNotifications();
        if (notificationDetails.getSdk() == null || notificationDetails.getSdk().getOptions() == null) {
            LOGGER.warning("the sdk details or the options are null");
            return initializeResult;
        }

        SdkDetails sdkDetails      = notificationDetails.getSdk();
        String     appKey          = sdkDetails.getKey();
        String     cluster         = sdkDetails.getOptions().getCluster();
        String     appChannel      = getAppChannel();
        boolean    encrypted       = sdkDetails.getOptions().getEncrypted();
        Long       activityTimeout = ACTIVITY_TIMEOUT;

        if (StringUtils.isEmpty(appKey) || StringUtils.isEmpty(cluster)) {
            LOGGER.warning("appId, appKey, appSecret or cluster is null or empty");
            return initializeResult;
        }

        if (StringUtils.isEmpty(appChannel)) {
            LOGGER.warning("appChannel is null or empty");
            return initializeResult;
        }

        shutdown();

        // Create a new Pusher instance
        PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setActivityTimeout(activityTimeout)
                .setEncrypted(encrypted);
        this.pusher = new Pusher(appKey, options);

        //Connect to pusher
        this.pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
                LOGGER.fine(String.format("State changed to %s from %s ",
                                          change.getCurrentState(),
                                          change.getPreviousState()));
            }

            @Override
            public void onError(String message, String code, Exception exception) {
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s",
                                             ExceptionUtils.throwableToString(exception)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        this.channel = this.pusher.subscribe(appChannel);
        bind(this.channel);

        initializeResult = true;
        return initializeResult;
    }

    private String getAppChannel() {
        return String.format("enjin.server.%s.%s.%s",
                             this.platformDetails.getNetwork().toLowerCase(),
                             this.platformDetails.getId(),
                             this.appId);
    }

    private String getIdentityChannel(BigInteger identityId) {
        return String.format("enjin.server.%s.%s.identity.%s",
                             this.platformDetails.getNetwork().toLowerCase(),
                             this.platformDetails.getId(),
                             identityId
        );
    }

    @Override
    public void shutdown() {
        if (this.pusher != null) {
            this.pusher.disconnect();
        }
    }

    protected void fireNotification(String sourceData, String channel, String eventType) {

        if (CollectionUtils.isEmpty(this.notificationListenerRegistrations)) {
            LOGGER.warning("No listeners are currently registered");
            return;
        }

        JsonElement      dataElement      = gson.fromJson(sourceData, JsonElement.class);
        NotificationType notificationType = NotificationType.UNKNOWN_EVENT;

        if (dataElement == null || !dataElement.isJsonObject()
                || !dataElement.getAsJsonObject().has("event_type")) {
            return;
        }

        JsonObject  dataObject       = dataElement.getAsJsonObject();
        JsonElement eventTypeElement = dataObject.get("event_type");
        String      eventTypeString  = eventTypeElement.getAsString();
        for (NotificationType type : NotificationType.values()) {
            if (type.getEventType().equalsIgnoreCase(eventTypeString)) {
                notificationType = type;
                break;
            }
        }

        if (notificationType == NotificationType.UNKNOWN_EVENT) {
            LOGGER.warning(String.format("UNKNOWN_EVENT NotificationType %s returned for the eventType of %s",
                                         eventTypeString, eventType));
            return;
        }

        NotificationEvent notificationEvent = NotificationEvent.builder()
                                                               .type(notificationType)
                                                               .channel(channel)
                                                               .data(sourceData)
                                                               .build();

        for (NotificationListenerRegistration registration : this.notificationListenerRegistrations) {
            if (registration.getEventMatcher().matches(notificationEvent)) {
                registration.getListener().notificationReceived(notificationEvent);
            }
        }

    }

    @Override
    public synchronized void setNotificationListeners(List<NotificationListenerRegistration> argNotificationListeners) {
        this.notificationListenerRegistrations = argNotificationListeners;
    }

    @Override
    public void listenForLink(BigInteger identityId) {
        String channel = getIdentityChannel(identityId);
        System.out.println("Listening for link on " + channel);

        if (identityChannels.containsKey(channel)) {
            unbind(identityChannels.remove(channel));
        }

        Channel ch = this.pusher.subscribe(channel);
        identityChannels.put(channel, ch);
        bind(ch);
    }

    @Override
    public void stopListeningForLink(BigInteger identityId) {
        String channel = getIdentityChannel(identityId);

        if (identityChannels.containsKey(channel)) {
            unbind(identityChannels.remove(channel));
        }

        pusher.unsubscribe(channel);
    }

    @Override
    public boolean isListeningForLink(BigInteger identityId) {
        String channel = getIdentityChannel(identityId);
        return identityChannels.containsKey(channel);
    }

    private void bind(Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            LOGGER.info(String.format("Event Channel Bound: %s", channelEvent.getKey()));
            channel.bind(channelEvent.getKey(), this.pusherListener);
        }
    }

    private void unbind(Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            LOGGER.info(String.format("Event Channel Unbound: %s", channelEvent.getKey()));
            channel.unbind(channelEvent.getKey(), this.pusherListener);
        }
    }
}
