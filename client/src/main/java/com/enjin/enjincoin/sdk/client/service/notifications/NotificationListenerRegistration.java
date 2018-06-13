package com.enjin.enjincoin.sdk.client.service.notifications;

import com.enjin.enjincoin.sdk.client.annotation.EventFilter;
import com.enjin.enjincoin.sdk.client.enums.NotificationType;

/**
 * Registration wrapper for notification listeners that extracts any metadata
 * from the notification listener that may be used in event handling.
 */
public class NotificationListenerRegistration {

    /**
     * All All Matchers Event.
     **/
    public static final EventMatcher ALLOW_ALL_MATCHER = event -> true;
    /**
     * All No Matchers Event.
     **/
    public static final EventMatcher ALLOW_NONE_MATCHER = event -> false;

    /**
     * Notification Listener.
     **/
    private NotificationListener listener;
    /**
     * Event Matcher.
     **/
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
     * @param listener     to use
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
        return this.listener;
    }

    /**
     * Method to get the event matcher.
     *
     * @return EventMatcher
     */
    public EventMatcher getEventMatcher() {
        return this.eventMatcher;
    }

    /**
     * Configuration class for the registration listener.
     *
     * @param <T> class type
     */
    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        /**
         * Notification Service.
         **/
        private NotificationsService service;
        /**
         * Notification Listener.
         **/
        private NotificationListener listener;

        /**
         * Event Matcher.
         **/
        private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

        /**
         * Class Constructor.
         *
         * @param service  to use
         * @param listener to use
         */
        protected RegistrationListenerConfiguration(final NotificationsService service, final NotificationListener listener) {
            this.service = service;
            this.listener = listener;
            this.detectAndApplyListenerAnnotations();
        }

        /**
         * Method to match against an event matcher.
         *
         * @param eventMatcher to check
         *
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
         *
         * @return T
         */
        public T withAllowedEvents(final NotificationType... types) {
            return this.withMatcher(types == null ? null : event -> event.getNotificationType().in(types));
        }

        /**
         * Method to check if the notification type is ignored.
         *
         * @param types to check
         *
         * @return T
         */
        public T withIgnoredEvents(final NotificationType... types) {
            return this.withMatcher(types == null ? null : event -> !event.getNotificationType().in(types));
        }

        /**
         * Method to register a NotificationListener.
         *
         * @return NotificationListenerRegistration
         */
        public NotificationListenerRegistration register() {
            NotificationListenerRegistration registration = null;
            if (this.service != null && this.listener != null) {
                registration = new NotificationListenerRegistration(this.listener, this.eventMatcher);
                this.service.addNotificationListenerRegistration(registration);
            }
            return registration;
        }

        /**
         * Method to apply listener annotations.
         */
        private void detectAndApplyListenerAnnotations() {
            if (this.listener != null) {
                final Class<?> clazz = this.listener.getClass();
                if (clazz.isAnnotationPresent(EventFilter.class)) {
                    final EventFilter filter = clazz.getAnnotation(EventFilter.class);
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
     * Method to configure a RegistrationListener.
     *
     * @param service  to use
     * @param listener to use
     *
     * @return RegistrationListenerConfiguration
     */
    @SuppressWarnings("rawtypes")
    public static RegistrationListenerConfiguration<?> configure(final NotificationsService service, final NotificationListener listener) {
        return new RegistrationListenerConfiguration(service, listener);
    }

}
