package com.enjin.enjincoin.sdk.service.notifications.impl;

import com.pusher.client.channel.SubscriptionEventListener;

import java.util.logging.Logger;

public class PusherListener implements SubscriptionEventListener {

    private static final Logger LOGGER = Logger.getLogger(PusherListener.class.getName());

    private PusherNotificationServiceImpl pusherService;

    public PusherListener(PusherNotificationServiceImpl pusherService) {
        this.pusherService = pusherService;
    }

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        LOGGER.info(String.format("Received event %s on channel %s with results %s ",
                                  eventName,
                                  channelName,
                                  data));
        this.pusherService.fireNotification(data, channelName, eventName);
    }

}
