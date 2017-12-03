package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.vo.notifications.NotificationEvent;

public interface EventMatcher {
    boolean matches(NotificationEvent event);
}
