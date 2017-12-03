package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.annotations.notifications.EventFilter;

/**
 * Registration wrapper for notification listeners that extracts
 * any metadata from the notification listener that may be used
 * in event handling.
 */
public class NotificationListenerRegistration {

    private NotificationListener listener;
    private EventFilter filter;

    public NotificationListenerRegistration(NotificationListener listener) {
        this.listener = listener;
        init();
    }

    private void init() {
        if (this.listener.getClass().isAnnotationPresent(EventFilter.class)) {
            this.filter = this.listener.getClass().getAnnotation(EventFilter.class);
        }
    }

    public NotificationListener getListener() {
        return listener;
    }

    public EventFilter getFilter() {
        return filter;
    }

    public boolean hasFilter() {
        return filter != null;
    }
}
