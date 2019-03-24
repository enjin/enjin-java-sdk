package com.enjin.enjincoin.sdk.client.service.notifications.impl;

import com.enjin.enjincoin.sdk.client.enums.NotificationType;
import com.enjin.enjincoin.sdk.client.service.notifications.ChannelEvent;
import com.enjin.enjincoin.sdk.client.service.notifications.NotificationListenerRegistration;
import com.enjin.enjincoin.sdk.client.service.notifications.ThirdPartyNotificationService;
import com.enjin.enjincoin.sdk.client.service.notifications.vo.NotificationEvent;
import com.enjin.enjincoin.sdk.client.service.platform.vo.NotificationDetails;
import com.enjin.enjincoin.sdk.client.service.platform.vo.PlatformDetails;
import com.enjin.enjincoin.sdk.client.service.platform.vo.SdkDetails;
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
import java.util.List;
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

    /**
     * Class constructor.
     *
     * @param platformDetails to use
     * @param appId                to use
     */
    public PusherNotificationServiceImpl(final PlatformDetails platformDetails, final int appId) {
        this.platformDetails = platformDetails;
        this.appId = appId;
    }

    /**
     * Method to initialize the notification service.
     *
     * @return boolean
     */
    @Override
    public boolean init() {
        boolean initializeResult = false;

        if (this.platformDetails == null || this.platformDetails.getNotificationDetails() == null) {
            LOGGER.warning("platformDetails or notificationDetails are null");
            return initializeResult;
        }

        final NotificationDetails notificationDetails = this.platformDetails.getNotificationDetails();
        if (notificationDetails.getSdkDetails() == null || notificationDetails.getSdkDetails().getOptions() == null) {
            LOGGER.warning("the sdk details or the options are null");
            return initializeResult;
        }

        final SdkDetails sdkDetails = notificationDetails.getSdkDetails();
        final String appKey = sdkDetails.getKey();
        final String cluster = sdkDetails.getOptions().getCluster();
        final String appChannel = getAppChannel(platformDetails);
        final boolean encrypted = sdkDetails.getOptions().getEncrypted();
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
                LOGGER.fine(String.format("State changed to %s from %s ", change.getCurrentState(), change.getPreviousState()));
            }

            /**
             * Method call on connection error
             * @param message
             * @param code
             * @param exception
             */
            @Override
            public void onError(final String message, final String code, final Exception exception) {
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s", ExceptionUtils.throwableToString(exception)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        this.channel = this.pusher.subscribe(appChannel);

        //Convert an enum to an array of strings
        //String[] eventTypes = Arrays.stream(NotificationTypeEnum.values()).map(NotificationTypeEnum::name).toArray(String[]::new);

        for (ChannelEvent channelEvent : ChannelEvent.values()) {
            this.channel.bind(channelEvent.getKey(), (channel, event, data) -> {
                LOGGER.fine(String.format("Received eventType %s, event %s with data %s ", channelEvent.getKey(), event, data));
                PusherNotificationServiceImpl.this.fireNotification(data, channel, event);
            });
        }

        initializeResult = true;
        return initializeResult;
    }

    private String getAppChannel(final PlatformDetails platformDetails) {
        final String platformId = platformDetails.getId();

        return String.format("enjin.server.%s.%s", platformId, this.appId);
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
    private void fireNotification(final String sourceData, final String channel, final String eventType) {

        if (CollectionUtils.isEmpty(this.notificationListenerRegistrations)) {
            LOGGER.warning("No listeners are currently registered");
            return;
        }

        JsonElement dataElement = gson.fromJson(sourceData, JsonElement.class);
        NotificationType notificationType = NotificationType.UNKNOWN_EVENT;

        if (dataElement != null && dataElement.isJsonObject()) {
            JsonObject dataObject = dataElement.getAsJsonObject();
            if (dataObject.has("event_type")) {
                JsonElement eventTypeElement = dataObject.get("event_type");
                String eventTypeString = eventTypeElement.getAsString();
                for (NotificationType type : NotificationType.values()) {
                    if (type.getEventType().equalsIgnoreCase(eventTypeString)) {
                        notificationType = type;
                    }
                }
            }
        }

        if (notificationType == NotificationType.UNKNOWN_EVENT) {
            LOGGER.warning(String.format("UNKNOWN_EVENT NotificationType returned for the eventType of %s", eventType));
            return;
        }

        final NotificationEvent notificationEvent = new NotificationEvent(notificationType, channel, sourceData);

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
}
