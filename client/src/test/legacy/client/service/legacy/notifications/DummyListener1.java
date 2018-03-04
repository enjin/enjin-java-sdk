package io.enjincoin.sdk.client.service.legacy.notifications;

import io.enjincoin.sdk.client.annotations.notifications.EventFilter;
import io.enjincoin.sdk.client.enums.NotificationType;
import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;

@EventFilter(value = {NotificationType.BALANCE_MELTED}, allow = true)
public class DummyListener1 implements NotificationListener {

    @Override
    public void notificationReceived(NotificationEvent event) {

    }

}
