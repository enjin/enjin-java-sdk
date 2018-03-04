package io.enjincoin.sdk.client.enums;

import io.enjincoin.sdk.client.annotations.notifications.EventFilter;
import io.enjincoin.sdk.client.service.legacy.notifications.NotificationListener;
import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;

@EventFilter(value = NotificationType.IDENTITY_CREATED)
public class NotificationTypeTestHelper implements NotificationListener {

    @Override
    public void notificationReceived(NotificationEvent event) {
        // Do Nothing
    }

}
