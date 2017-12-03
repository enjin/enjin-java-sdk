package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.annotations.notifications.EventFilter;
import com.enjin.coin.sdk.enums.NotificationType;

/**
 * Registration wrapper for notification listeners that extracts
 * any metadata from the notification listener that may be used
 * in event handling.
 */
public class NotificationListenerRegistration {

    public static final EventMatcher ALLOW_ALL_MATCHER = event -> true;
    public static final EventMatcher ALLOW_NONE_MATCHER = event -> false;

    private NotificationListener listener;
    private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

    protected NotificationListenerRegistration(NotificationListener listener) {
        this.listener = listener;
    }

    protected NotificationListenerRegistration(NotificationListener listener, EventMatcher eventMatcher) {
        this(listener);
        this.eventMatcher = eventMatcher;
    }

    public NotificationListener getListener() {
        return listener;
    }

    public EventMatcher getEventMatcher() {
        return eventMatcher;
    }

    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        private NotificationsService service;
        private NotificationListener listener;
        private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

        protected RegistrationListenerConfiguration(NotificationsService service, NotificationListener listener) {
            this.service = service;
            this.listener = listener;
            detectAndApplyListenerAnnotations();
        }

        public T withMatcher(EventMatcher eventMatcher) {
            this.eventMatcher = eventMatcher == null ? ALLOW_ALL_MATCHER : eventMatcher;
            return (T) this;
        }

        public T withAllowedEvents(NotificationType... types) {
            return withMatcher(types == null ? null : event -> event.getNotificationType().in(types));
        }

        public T withIgnoredEvents(NotificationType... types) {
            return withMatcher(types == null ? null : event -> !event.getNotificationType().in(types));
        }

        public NotificationListenerRegistration register() {
            NotificationListenerRegistration registration = null;
            if (this.service != null && this.listener != null) {
                registration = new NotificationListenerRegistration(listener, eventMatcher);
                this.service.addNotificationListenerRegistration(registration);
            }
            return registration;
        }

        private void detectAndApplyListenerAnnotations() {
            if (this.listener != null) {
                Class<?> clazz = this.listener.getClass();
                if (clazz.isAnnotationPresent(EventFilter.class)) {
                    EventFilter filter = clazz.getAnnotation(EventFilter.class);
                    if (filter.allow())
                        withAllowedEvents(filter.value());
                    else
                        withIgnoredEvents(filter.value());
                }
            }
        }
    }

    public static RegistrationListenerConfiguration configure(NotificationsService service, NotificationListener listener) {
        return new RegistrationListenerConfiguration(service, listener);
    }

}
