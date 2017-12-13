package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.annotations.notifications.EventFilter;
import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.vo.notifications.NotificationEvent;

@EventFilter(value = { NotificationType.BALANCE_MELTED }, allow=false)
public class DummyListener2 implements NotificationListener{

    @Override
    public void notificationReceived(NotificationEvent event) {

    }

}
