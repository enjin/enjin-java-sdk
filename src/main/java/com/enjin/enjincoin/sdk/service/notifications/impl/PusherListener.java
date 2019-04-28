package com.enjin.enjincoin.sdk.service.notifications.impl;

import com.pusher.client.channel.SubscriptionEventListener;

public class PusherListener implements SubscriptionEventListener {

    private PusherNotificationServiceImpl pusherService;

    public PusherListener(PusherNotificationServiceImpl pusherService) {
        this.pusherService = pusherService;
    }

    @Override
    public void onEvent(String channelName, String eventName, String data) {
        this.pusherService.fireNotification(data, channelName, eventName);
    }

}
