package com.enjin.sdk.events;

import com.enjin.sdk.models.EventType;
import lombok.Getter;

/**
 * Registration wrapper for notification listeners that extracts any metadata
 * from the notification listener that may be used in event handling.
 *
 * @author Evan Lindsay
 * @see NotificationListener
 * @see NotificationsService
 */
public class NotificationListenerRegistration {

    /**
     * A matcher that matches all events.
     */
    public static final EventMatcher ALLOW_ALL_MATCHER = event -> true;

    /**
     * -- GETTER --
     * @return the listener
     */
    @Getter
    private final NotificationListener listener;
    /**
     * -- GETTER --
     * @return the matcher
     */
    @Getter
    private EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

    /**
     * Constructs the registration for the specified listener.
     *
     * @param listener the listener
     */
    protected NotificationListenerRegistration(NotificationListener listener) {
        this.listener = listener;
    }

    /**
     * Constructs the registration for the specified listener with the specified event matcher.
     *
     * @param listener the listener.
     * @param matcher the event matcher.
     */
    protected NotificationListenerRegistration(NotificationListener listener, EventMatcher matcher) {
        this(listener);
        this.eventMatcher = matcher;
    }

    /**
     * Creates a new registration configuration for the provided listener.
     *
     * @param listener the listener to configure
     * @return the configuration
     */
    @SuppressWarnings("rawtypes")
    public static RegistrationListenerConfiguration configure(NotificationListener listener) {
        return new RegistrationListenerConfiguration(listener);
    }

    /**
     * A registration configuration for listeners.
     *
     * @param <T> the configuration
     * @author Evan Lindsay
     */
    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        /**
         * The notification listener of the configuration.
         */
        protected NotificationListener listener;

        /**
         * The event matcher of the configuration.
         */
        protected EventMatcher eventMatcher = ALLOW_ALL_MATCHER;

        /**
         * Sole constructor.
         *
         * @param listener the listener
         */
        protected RegistrationListenerConfiguration(NotificationListener listener) {
            this.listener = listener;
            this.detectAndApplyListenerAnnotations();
        }

        /**
         * Assigns the specified event matcher to the configuration. If the specified event matcher
         * is null then the default event matcher that allows all event will be assigned.
         *
         * @param eventMatcher the event matcher
         * @return this configuration for chaining
         */
        @SuppressWarnings("unchecked")
        public T withMatcher(EventMatcher eventMatcher) {
            this.eventMatcher = eventMatcher == null ? ALLOW_ALL_MATCHER : eventMatcher;
            return (T) this;
        }

        /**
         * Creates and assigns an event matcher that will allow the specified event types.
         *
         * @param types the types to allow
         * @return this configuration for chaining
         */
        public T withAllowedEvents(final EventType... types) {
            return this.withMatcher(types == null
                                            ? null
                                            : (EventMatcher) event -> event.getType().in(types));
        }

        /**
         * Creates and assigns an event matcher that will ignore the specified event types.
         *
         * @param types the types to ignore
         * @return this configuration for chaining
         */
        public T withIgnoredEvents(final EventType... types) {
            return this.withMatcher(types == null
                                            ? null
                                            : (EventMatcher) event -> !event.getType().in(types));
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
