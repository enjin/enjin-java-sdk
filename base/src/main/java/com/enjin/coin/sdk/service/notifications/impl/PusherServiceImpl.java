package com.enjin.coin.sdk.service.notifications.impl;

import java.util.logging.Logger;

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
        Pusher pusher = new Pusher(appKey, options);

        pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange change) {
                LOGGER.info("State changed to " + change.getCurrentState() + " from " + change.getPreviousState());
            }

            @Override
            public void onError(String message, String code, Exception e) {
                LOGGER.info("There was a problem connecting!");
            }
        }, ConnectionState.ALL);


        // Subscribe to a channel
        Channel channel = pusher.subscribe(appChannel);

        String eventType = "my-event";
        // Bind to listen for events called "my-event" sent to "my-channel"
        channel.bind("my-event", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channel, String event, String data) {
                LOGGER.info("Received eventType:" + eventType + "  with data: " + data);
            }
        });

        // Disconnect from the service (or become disconnected my network conditions)
       // pusher.disconnect();

        // Reconnect, with all channel subscriptions and event bindings automatically recreated
        //pusher.connect();
        // The state change listener is notified when the connection has been re-established,
        // the subscription to "my-channel" and binding on "my-event" still exist.

        int a = 1;
        int b = 0;
        while(a > b) {

        }

        initializeResult = true;
        return initializeResult;
    }


}
