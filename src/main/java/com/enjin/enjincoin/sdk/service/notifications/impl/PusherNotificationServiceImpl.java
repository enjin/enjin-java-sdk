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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Service to implement methods that interact with the pusher library.</p>
 */
public class PusherNotificationServiceImpl implements ThirdPartyNotificationService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PusherNotificationServiceImpl.class.getName());

    private static final Long ACTIVITY_TIMEOUT = 4000L;

    private Gson gson = new GsonBuilder().create();

    private int appId;

    /**
     * Local pusher variable.
     **/
    private Pusher pusher;

    /**
     * Local channel variable .
     **/
    private Channel channel;

    /**
     * Local variable holding all the notification listener registrations.
     */
    private List<NotificationListenerRegistration> notificationListenerRegistrations = new ArrayList<>();

    /**
     * Local notification details method.
     */
    private PlatformDetails platformDetails;

    private PusherListener pusherListener;

    private Map<String, Channel> identityChannels = new HashMap<>();

    /**
     * Class constructor.
     *
     * @param platformDetails to use
     * @param appId           to use
     */
    public PusherNotificationServiceImpl(final PlatformDetails platformDetails, final int appId) {
        this.platformDetails = platformDetails;
        this.appId = appId;
        this.pusherListener = new PusherListener(this);
    }

    /**
     * Method to initialize the notification service.
     *
     * @return boolean
     */
    @Override
    public boolean init() {
        boolean initializeResult = false;

        if (this.platformDetails.getNotifications() == null) {
            LOGGER.warning("notificationDetails are null");
            return initializeResult;
        }

        final NotificationDetails notificationDetails = this.platformDetails.getNotifications();
        if (notificationDetails.getSdk() == null || notificationDetails.getSdk().getOptions() == null) {
            LOGGER.warning("the sdk details or the options are null");
            return initializeResult;
        }

        final SdkDetails sdkDetails = notificationDetails.getSdk();
        final String     appKey     = sdkDetails.getKey();
        final String     cluster    = sdkDetails.getOptions().getCluster();
        final String     appChannel = getAppChannel();
        final boolean    encrypted  = sdkDetails.getOptions().getEncrypted();
        System.out.println("appChannel:" + appChannel);
        final Long activityTimeout = ACTIVITY_TIMEOUT;

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
        final PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setActivityTimeout(activityTimeout)
                .setEncrypted(encrypted);
        this.pusher = new Pusher(appKey, options);

        //Connect to pusher
        this.pusher.connect(new ConnectionEventListener() {
            /**
             * Method call on connection state change.
             * @param change
             */
            @Override
            public void onConnectionStateChange(final ConnectionStateChange change) {
                LOGGER.fine(String.format("State changed to %s from %s ",
                                          change.getCurrentState(),
                                          change.getPreviousState()));
            }

            /**
             * Method call on connection error
             * @param message
             * @param code
             * @param exception
             */
            @Override
            public void onError(final String message, final String code, final Exception exception) {
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s",
                                             ExceptionUtils.throwableToString(exception)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        this.channel = this.pusher.subscribe(appChannel);

        //Convert an enum to an array of strings
        //String[] eventTypes = Arrays.stream(NotificationTypeEnum.values()).map(NotificationTypeEnum::name).toArray(String[]::new);

        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            LOGGER.info(String.format("Event Channel Bound: %s", channelEvent.getKey()));
            this.channel.bind(channelEvent.getKey(), (channel, event, data) -> {
                LOGGER.info(String.format("Received eventType %s, event %s with results %s ",
                                          channelEvent.getKey(),
                                          event,
                                          data));
                PusherNotificationServiceImpl.this.fireNotification(data, channel, event);
            });
        }

        initializeResult = true;
        return initializeResult;
    }

    private String getAppChannel() {
        return String.format("enjin.server.%s.%s.%s",
                             this.platformDetails.getNetwork().toLowerCase(),
                             this.platformDetails.getId(),
                             this.appId);
    }

    private String getIdentityChannel(int identityId) {
        return String.format("enjin.server.%s.%s.%s.%s",
                             this.platformDetails.getNetwork().toLowerCase(),
                             this.platformDetails.getId(),
                             this.appId,
                             identityId
        );
    }

    @Override
    public void shutdown() {
        if (this.pusher != null) {
            this.pusher.disconnect();
        }
    }

    /**
     * Method to fire a notification.
     *
     * @param sourceData the sourceData received from the notification
     * @param channel    the channel the notification was received from
     * @param eventType  the type of event we received
     */
    protected void fireNotification(final String sourceData, final String channel, final String eventType) {

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

        final NotificationEvent notificationEvent = NotificationEvent.builder()
                                                                     .type(notificationType)
                                                                     .channel(channel)
                                                                     .sourceData(sourceData)
                                                                     .build();

        for (final NotificationListenerRegistration registration : this.notificationListenerRegistrations) {
            if (registration.getEventMatcher().matches(notificationEvent)) {
                registration.getListener().notificationReceived(notificationEvent);
            }
        }

    }

    /**
     * Method to set the notification listeners.
     *
     * @param argNotificationListeners - list of listeners to set as the new listeners
     */
    @Override
    public synchronized void setNotificationListeners(final List<NotificationListenerRegistration> argNotificationListeners) {
        this.notificationListenerRegistrations = argNotificationListeners;
    }

    @Override
    public void listenForLink(int identityId) {
        String channel = getIdentityChannel(identityId);

        if (identityChannels.containsKey(channel)) {
            unbind(identityChannels.remove(channel));
        }

        Channel ch = this.pusher.subscribe(channel);
        identityChannels.put(channel, ch);
        bind(ch);
    }

    @Override
    public void stopListeningForLink(int identityId) {
        String channel = getIdentityChannel(identityId);

        if (identityChannels.containsKey(channel)) {
            unbind(identityChannels.remove(channel));
        }

        pusher.unsubscribe(channel);
    }

    @Override
    public boolean isListeningForLink(int identityId) {
        String channel = getIdentityChannel(identityId);
        return identityChannels.containsKey(channel);
    }

    private void bind(Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            channel.bind(channelEvent.getKey(), this.pusherListener);
        }
    }

    private void unbind(Channel channel) {
        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            channel.unbind(channelEvent.getKey(), this.pusherListener);
        }
    }
}
