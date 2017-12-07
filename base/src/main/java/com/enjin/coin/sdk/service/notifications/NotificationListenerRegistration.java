package com.enjin.coin.sdk.service.notifications;

import com.enjin.coin.sdk.annotations.notifications.EventFilter;
import com.enjin.coin.sdk.enums.NotificationType;

/**
 * Registration wrapper for notification listeners that extracts any metadata
 * from the notification listener that may be used in event handling.
 */
public class NotificationListenerRegistration {

    /** All All Matchers Event. **/
    public static final EventMatcher ALLOW_ALL_MATCHER = event -> true;
    /** All No Matchers Event. **/
    public static final EventMatcher ALLOW_NONE_MATCHER = event -> false;

    /** Notification Listener. **/
    private NotificationListener listener;
    /** Event Matcher. **/
    private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

    /**
     * Class constructor.
     *
     * @param listener to use
     */
    protected NotificationListenerRegistration(final NotificationListener listener) {
        this.listener = listener;
    }

    /**
     * Class constructor.
     *
     * @param listener to use
     * @param eventMatcher to match against
     */
    protected NotificationListenerRegistration(final NotificationListener listener, final EventMatcher eventMatcher) {
        this(listener);
        this.eventMatcher = eventMatcher;
    }

    /**
     * Method to get the listener.
     *
     * @return NotificationListener
     */
    public NotificationListener getListener() {
        return listener;
    }

    /**
     * Method to get the event matcher.
     *
     * @return EventMatcher
     */
    public EventMatcher getEventMatcher() {
        return eventMatcher;
    }

    /**
     * Configuration class for the registration listener.
     *
     * @param <T> class type
     */
    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        /** Notification Service. **/
        private NotificationsService service;
        /** Notification Listener. **/
        private NotificationListener listener;

        /** Event Matcher. **/
        private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

        /**
         * Class Constructor.
         *
         * @param service to use
         * @param listener to use
         */
        protected RegistrationListenerConfiguration(final NotificationsService service, final NotificationListener listener) {
            this.service = service;
            this.listener = listener;
            detectAndApplyListenerAnnotations();
        }

        /**
         * Method to match against an event matcher.
         *
         * @param eventMatcher to check
         * @return T
         */
        @SuppressWarnings("unchecked")
        public T withMatcher(final EventMatcher eventMatcher) {
            this.eventMatcher = eventMatcher == null ? ALLOW_ALL_MATCHER : eventMatcher;
            return (T) this;
        }

        /**
         * Method to check if the notification type is allowed.
         *
         * @param types to check
         * @return T
         */
        public T withAllowedEvents(final NotificationType... types) {
            return withMatcher(types == null ? null : event -> event.getNotificationType().in(types));
        }

        /**
         * Method to check if the notification type is ignored.
         *
         * @param types to check
         * @return T
         */
        public T withIgnoredEvents(final NotificationType... types) {
            return withMatcher(types == null ? null : event -> !event.getNotificationType().in(types));
        }

        /**
         * Method to register a NotificationListener.
         *
         * @return NotificationListenerRegistration
         */
        public NotificationListenerRegistration register() {
            NotificationListenerRegistration registration = null;
            if (this.service != null && this.listener != null) {
                registration = new NotificationListenerRegistration(listener, eventMatcher);
                this.service.addNotificationListenerRegistration(registration);
            }
            return registration;
        }

        /**
         * Method to apply listener annotations.
         */
        private void detectAndApplyListenerAnnotations() {
            if (this.listener != null) {
                Class<?> clazz = this.listener.getClass();
                if (clazz.isAnnotationPresent(EventFilter.class)) {
                    EventFilter filter = clazz.getAnnotation(EventFilter.class);
                    if (filter.allow()) {
                        withAllowedEvents(filter.value());
                    } else {
                        withIgnoredEvents(filter.value());
                    }
                }
            }
        }
    }

    /**
     * Method to configure a RegistrationListener.
     *
     * @param service to use
     * @param listener to use
     * @return RegistrationListenerConfiguration
     */
    @SuppressWarnings("rawtypes")
    public static RegistrationListenerConfiguration<?> configure(final NotificationsService service, final NotificationListener listener) {
        return new RegistrationListenerConfiguration(service, listener);
    }

}
