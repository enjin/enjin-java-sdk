package com.enjin.coin.sdk.service.notifications.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.NotificationListener;
import com.enjin.coin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.coin.sdk.util.ListUtils;
import com.enjin.coin.sdk.util.StringUtils;
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
 * <p>Service to implement methods that interact with the pusher library
 *
 */
public class PusherNotificationServiceImpl implements ThirdPartyNotificationService{

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PusherNotificationServiceImpl .class.getName());

    /** Local pusher variable **/
    private Pusher pusher;

    /** Local channel variable **/
    private Channel channel;

    /**
     * Local variable holding all the notification listeners
     */
    private List<NotificationListener> _notificationListeners = new ArrayList<NotificationListener>();

    /**
     * Method to initialize the notification service.
     * @param notification
     * @return
     */
    @Override
    public boolean initializeNotificationService(Notification notification) {
        boolean initializeResult = false;

        if (notification == null) {
            LOGGER.warning("Notification config passed in is null");
            return initializeResult;
        }

        String appId         = notification.getAppId();
        String appKey        = notification.getAppKey();
        String appSecret     = notification.getAppSecret();
        String cluster       = notification.getCluster();
        String appChannel    = notification.getAppChannel();
        Long activityTimeout = notification.getActivityTimeout();

        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret) || StringUtils.isEmpty(cluster)) {
            LOGGER.warning("appId, appKey, appSecret or cluster is null or empty");
            return initializeResult;
        }

        if (StringUtils.isEmpty(appChannel) || activityTimeout == null) {
            LOGGER.warning("appChannel is null or empty or the activityTimeout is null");
            return initializeResult;
        }

        // Create a new Pusher instance
        PusherOptions options = new PusherOptions()
                .setCluster(cluster)
                .setActivityTimeout(activityTimeout);
        pusher = new Pusher(appKey, options);


        //Connect to pusher
        pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
                LOGGER.info(String.format("State changed to %s from %s ", change.getCurrentState(), change.getPreviousState()));
            }

            @Override
            public void onError(String message, String code, Exception e) {
                LOGGER.warning(String.format("There was a problem connecting!. Exception: %s", StringUtils.exceptionToString(e)));
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        channel = pusher.subscribe(appChannel);

        //Convert an enum to an array of strings
        //String[] eventTypes = Arrays.stream(NotificationTypeEnum.values()).map(NotificationTypeEnum::name).toArray(String[]::new);

        for (NotificationType notificationTypeEnum : NotificationType.values()) {
            String eventType = notificationTypeEnum.getEventType();

            // Bind to listen for events called "my-event" sent to "my-channel"
            channel.bind(eventType, new SubscriptionEventListener() {
                @Override
                public void onEvent(String channel, String event, String data) {
                    fireNotification(data, channel, event);
                    LOGGER.fine(String.format("Received eventType %s, event %s with data %s ", eventType, event, data));
                }
            });
        }

        initializeResult = true;
        return initializeResult;
    }

    /**
     * Method to fire a notification
     * @param sourceData
     * @param channel
     * @param eventType
     *
     */
    private void fireNotification(String sourceData, String channel, String eventType) {

        if (ListUtils.isEmpty(_notificationListeners)) {
            LOGGER.warning("No listeners are currently registered");
            return ;
        }

        NotificationType notificationTypeEnum = NotificationType.valueOf(eventType.toUpperCase());
        if (notificationTypeEnum == null) {
            LOGGER.warning(String.format("Failed to get NotificationType for the eventType of %s", eventType));
            return;
        }

        NotificationEvent notificationEvent = new NotificationEvent(sourceData, channel, notificationTypeEnum);
        for(NotificationListener notificationListener : _notificationListeners) {
           notificationListener.notificationReceived(notificationEvent);
        }

    }
    /**
     * Method to set the notification listeners
     * @param notificationListeners
     */
    @Override
    public synchronized void setNotificationListeners(List<NotificationListener> notificationListeners) {
        this._notificationListeners = notificationListeners;
    }
}
