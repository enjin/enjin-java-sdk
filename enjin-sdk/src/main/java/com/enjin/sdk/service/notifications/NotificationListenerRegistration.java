package com.enjin.sdk.service.notifications;

import com.enjin.sdk.model.service.notifications.NotificationEvent;
import com.enjin.sdk.model.service.notifications.NotificationType;

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
    public static final EventMatcher ALLOW_ALL_MATCHER = new EventMatcher() {
        @Override
        public boolean matches(NotificationEvent event) {
            return true;
        }
    };

    private NotificationListener listener;
    private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

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
     * Creates a new listener configuration for the provided notification service.
     *
     * @param listener the listener to configure.
     *
     * @return RegistrationListenerConfiguration
     */
    @SuppressWarnings("rawtypes")
    public static RegistrationListenerConfiguration configure(NotificationListener listener) {
        return new RegistrationListenerConfiguration(listener);
    }

    /**
     * A registration configuration for listeners.
     *
     * @param <T> the configuration.
     *
     * @author Evan Lindsay
     */
    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        protected NotificationListener listener;
        protected EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

        protected RegistrationListenerConfiguration(NotificationListener listener) {
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
        public T withAllowedEvents(final NotificationType... types) {
            return this.withMatcher(types == null ? null : new EventMatcher() {
                @Override
                public boolean matches(NotificationEvent event) {
                    return event.getType().in(types);
                }
            });
        }

        /**
         * Creates an event matcher that will ignore the specified event types.
         *
         * @param types the types to ignore.
         *
         * @return the configuration.
         */
        public T withIgnoredEvents(final NotificationType... types) {
            return this.withMatcher(types == null ? null : new EventMatcher() {
                @Override
                public boolean matches(NotificationEvent event) {
                    return !event.getType().in(types);
                }
            });
        }

        /**
         * Creates new instance of notification listener with the configured listener and event matcher.
         *
         * @return a new instance if listener is not null, else null
         */
        public NotificationListenerRegistration create() {
            NotificationListenerRegistration registration = null;

            if (this.listener != null) {
                registration = new NotificationListenerRegistration(this.listener, this.eventMatcher);
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

}
