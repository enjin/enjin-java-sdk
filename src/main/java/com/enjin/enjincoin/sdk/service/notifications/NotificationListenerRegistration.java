package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;

/**
 * Registration wrapper for notification listeners that extracts any metadata
 * from the notification listener that may be used in event handling.
 *
 * @author Evan Lindsay
 */
public class NotificationListenerRegistration {

    /**
     * A matcher that matches all events.
     **/
    public static final EventMatcher ALLOW_ALL_MATCHER = event -> true;

    private NotificationListener listener;
    private EventMatcher         eventMatcher = ALLOW_ALL_MATCHER;

    protected NotificationListenerRegistration(NotificationListener listener) {
        this.listener = listener;
    }

    protected NotificationListenerRegistration(NotificationListener listener, EventMatcher eventMatcher) {
        this(listener);
        this.eventMatcher = eventMatcher;
    }

    /**
     * Returns the listener that a registration was created for.
     *
     * @return the listener.
     */
    public NotificationListener getListener() {
        return this.listener;
    }

    /**
     * Returns the event matcher used for the listener.
     *
     * @return the listener.
     */
    public EventMatcher getEventMatcher() {
        return this.eventMatcher;
    }

    /**
     * A registration configuration for listeners.
     *
     * @param <T> the configuration.
     *
     * @author Evan Lindsay
     */
    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        private NotificationsService service;
        private NotificationListener listener;
        private EventMatcher         eventMatcher = ALLOW_ALL_MATCHER;

        protected RegistrationListenerConfiguration(NotificationsService service,
                                                    NotificationListener listener) {
            this.service = service;
            this.listener = listener;
            this.detectAndApplyListenerAnnotations();
        }

        /**
         * Assigns the specified event matcher to the configuration. If the specified event matcher
         * is null then the default event matcher that allows all event will be assigned.
         *
         * @param eventMatcher the event matcher
         *
         * @return the configuration.
         */
        @SuppressWarnings("unchecked")
        public T withMatcher(EventMatcher eventMatcher) {
            this.eventMatcher = eventMatcher == null ? ALLOW_ALL_MATCHER : eventMatcher;
            return (T) this;
        }

        /**
         * Creates an event matcher that will allow the specified event types.
         *
         * @param types the types to allow.
         *
         * @return the configuration.
         */
        public T withAllowedEvents(NotificationType... types) {
            return this.withMatcher(types == null ? null : event -> event.getType().in(types));
        }

        /**
         * Creates an event matcher that will ignore the specified event types.
         *
         * @param types the types to ignore.
         *
         * @return the configuration.
         */
        public T withIgnoredEvents(NotificationType... types) {
            return this.withMatcher(types == null ? null : event -> !event.getType().in(types));
        }

        /**
         * Creates a new listener registration and adds it to the notification service.
         *
         * @return the registration.
         */
        public NotificationListenerRegistration register() {
            NotificationListenerRegistration registration = null;
            if (this.service != null && this.listener != null) {
                registration = new NotificationListenerRegistration(this.listener, this.eventMatcher);
                this.service.addNotificationListenerRegistration(registration);
            }
            return registration;
        }

        private void detectAndApplyListenerAnnotations() {
            if (this.listener != null) {
                Class<?> clazz = this.listener.getClass();
                if (clazz.isAnnotationPresent(EventFilter.class)) {
                    EventFilter filter = clazz.getAnnotation(EventFilter.class);
                    if (filter.allow()) {
                        this.withAllowedEvents(filter.value());
                    } else {
                        this.withIgnoredEvents(filter.value());
                    }
                }
            }
        }
    }

    /**
     * Creates a new listener configuration for the provided notification service.
     *
     * @param service  the service the listener is being configured for.
     * @param listener the listener to configure.
     *
     * @return RegistrationListenerConfiguration
     */
    @SuppressWarnings("rawtypes")
    public static RegistrationListenerConfiguration<?> configure(NotificationsService service,
                                                                 NotificationListener listener) {
        return new RegistrationListenerConfiguration(service, listener);
    }

}
