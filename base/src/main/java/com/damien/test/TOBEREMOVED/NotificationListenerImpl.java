package com.damien.test.TOBEREMOVED;

import com.enjin.coin.sdk.service.notifications.NotificationListener;
import com.enjin.coin.sdk.vo.notifications.NotificationEvent;

public class NotificationListenerImpl implements NotificationListener {

    @Override
    public void notificationReceived(NotificationEvent notificationEvent) {
        System.out.println("*******************************************************");
        System.out.println("******  Client Listener ******");
        System.out.format("Notification Received: channel: %s notificationEvent: %s source: %s\n\n", notificationEvent.getChannel(), notificationEvent.getNotificationType().toString(), notificationEvent.getSource().toString());
        System.out.println("*******************************************************");
    }

}
