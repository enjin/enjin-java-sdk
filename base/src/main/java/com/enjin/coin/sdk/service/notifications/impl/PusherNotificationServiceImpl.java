package com.enjin.coin.sdk.service.notifications.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration;
import com.enjin.coin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.coin.sdk.util.ListUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.notifications.ImmutableNotificationEvent;
import com.enjin.coin.sdk.vo.notifications.NotificationEvent;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

/**
 *
 * <p>Service to implement methods that interact with the pusher library.</p>
 *
 */
public class PusherNotificationServiceImpl implements ThirdPartyNotificationService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PusherNotificationServiceImpl .class.getName());

    /** Local pusher variable. **/
    private Pusher pusher;

    /** Local channel variable .**/
    private Channel channel;

    /**
     * Local variable holding all the notification listener registrations.
     */
    private List<NotificationListenerRegistration> notificationListenerRegistrations = new ArrayList<>();

    /**
     * Local notificationConfig variable.
     */
    private Notification notificationConfig;

    /**
     * Class constructor.
     * @param notificationConfig the config for the notifications
     */
    public PusherNotificationServiceImpl(final Notification notificationConfig) {
        this.notificationConfig = notificationConfig;
    }

    /**
     * Method to initialize the notification service.
     * @return boolean
     */
    @Override
    public boolean initializeNotificationService() {
        boolean initializeResult = false;

        //String appId         = notificationConfig.getAppId();
        String appKey        = notificationConfig.getAppKey();
        //String appSecret     = notificationConfig.getAppSecret();
        String cluster       = notificationConfig.getCluster();
        String appChannel    = notificationConfig.getAppChannel();
        Long activityTimeout = notificationConfig.getActivityTimeout();

        if (StringUtils.isEmpty(appKey) || StringUtils.isEmpty(cluster)) {
            LOGGER.warning("appId, appKey, appSecret or cluster is null or empty");
            return initializeResult;
        }

        if (StringUtils.isEmpty(appChannel)) {
            LOGGER.warning("appChannel is null or empty");
            return initializeResult;
        }

        // Create a new Pusher instance
        PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setActivityTimeout(activityTimeout);
        pusher = new Pusher(appKey, options);

        //Connect to pusher
        pusher.connect(new ConnectionEventListener() {
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
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s", StringUtils.exceptionToString(exception)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        channel = pusher.subscribe(appChannel);

        //Convert an enum to an array of strings
        //String[] eventTypes = Arrays.stream(NotificationTypeEnum.values()).map(NotificationTypeEnum::name).toArray(String[]::new);

        for (NotificationType notificationTypeEnum : NotificationType.values()) {
            String eventType = notificationTypeEnum.getEventType();

            // Bind to listen for events that match the eventType and appChannel
            channel.bind(eventType, new SubscriptionEventListener() {
                /**
                 * Method called on new events from the channel.
                 * @param channel
                 * @param event
                 * @param data
                 */
                @Override
                public void onEvent(final String channel, final String event, final String data) {
                    fireNotification(data, channel, event);
                    LOGGER.fine(String.format("Received eventType %s, event %s with data %s ", eventType, event, data));
                }
            });
        }

        initializeResult = true;
        return initializeResult;
    }

    /**
     * Method to fire a notification.
     * @param sourceData the sourceData received from the notification
     * @param channel the channel the notification was received from
     * @param eventType the type of event we received
     */
    private void fireNotification(final String sourceData, final String channel, final String eventType) {

        if (ListUtils.isEmpty(notificationListenerRegistrations)) {
            LOGGER.warning("No listeners are currently registered");
            return;
        }

        NotificationType notificationTypeEnum = NotificationType.valueOfEnum(eventType.toUpperCase());
        if (notificationTypeEnum == null) {
            LOGGER.warning(String.format("Failed to get NotificationType for the eventType of %s", eventType));
            return;
        }

        NotificationEvent notificationEvent = ImmutableNotificationEvent.builder()
                .setSourceData(sourceData)
                .setChannel(channel)
                .setNotificationType(notificationTypeEnum)
                .build();

        for (NotificationListenerRegistration registration : notificationListenerRegistrations) {
            if (registration.getEventMatcher().matches(notificationEvent)) {
                registration.getListener().notificationReceived(notificationEvent);
            }
        }

    }
    /**
     * Method to set the notification listeners.
     * @param argNotificationListeners - list of listeners to set as the new listeners
     */
    @Override
    public synchronized void setNotificationListeners(final List<NotificationListenerRegistration> argNotificationListeners) {
        this.notificationListenerRegistrations = argNotificationListeners;
    }
}
