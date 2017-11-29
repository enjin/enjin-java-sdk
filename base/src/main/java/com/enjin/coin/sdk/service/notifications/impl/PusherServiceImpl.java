package com.enjin.coin.sdk.service.notifications.impl;

import java.util.logging.Logger;

import com.enjin.coin.sdk.enums.NotificationTypeEnum;
import com.enjin.coin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.coin.sdk.util.StringUtils;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
public class PusherServiceImpl implements ThirdPartyNotificationService{

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(PusherServiceImpl .class.getName());

    private Pusher pusher;
    private Channel channel;
    /**
     * Method to initialize the notification service.
     * @param appId
     * @param appKey
     * @param appSecret
     * @param cluster
     * @param appChannel
     * @param activityTimeout
     * @return
     */
    @Override
    public boolean initializeNotificationService(String appId, String appKey, String appSecret, String cluster, String appChannel, Long activityTimeout) {
        boolean initializeResult = false;
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret) || StringUtils.isEmpty(cluster)) {
            LOGGER.warning("appId, appKey, appSecret or cluster is null or empty");
            return initializeResult;
        }

        if (StringUtils.isEmpty(appChannel) || activityTimeout == null) {
            LOGGER.warning("appChannel is null or empty or the activityTimeout is null");
            return initializeResult;
        }

        // Create a new Pusher instance
        PusherOptions options = new PusherOptions().setCluster(cluster).setActivityTimeout(activityTimeout);
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

        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            String eventType = notificationTypeEnum.getEventType();

            // Bind to listen for events called "my-event" sent to "my-channel"
            channel.bind(eventType, new SubscriptionEventListener() {
                @Override
                public void onEvent(String channel, String event, String data) {
                    LOGGER.info(String.format("Received eventType %s with data %s ", eventType, data));
                }
            });
        }

        int a = 1;
        int b = 0;
        while (a > b) {

        }
        initializeResult = true;
        return initializeResult;
    }


}
