/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.events;

import com.enjin.sdk.models.EventType;
import lombok.Getter;

/**
 * Registration wrapper for a {@link IEventListener} that extracts any metadata from the notification listener that may
 * be used in event handling.
 *
 * @see IEventListener
 * @see IEventService
 */
public class EventListenerRegistration {

    /**
     * A matcher that matches all events.
     */
    public static final IEventMatcher ALLOW_ALL_MATCHER = event -> true;

    /**
     * -- GETTER --
     *
     * @return the listener
     */
    @Getter
    private final IEventListener listener;

    /**
     * -- GETTER --
     *
     * @return the matcher
     */
    @Getter
    private IEventMatcher eventMatcher = ALLOW_ALL_MATCHER;

    /**
     * Constructs the registration for the specified listener.
     *
     * @param listener the listener
     */
    protected EventListenerRegistration(IEventListener listener) {
        this.listener = listener;
    }

    /**
     * Constructs the registration for the specified listener with the specified event matcher.
     *
     * @param listener the listener.
     * @param matcher  the event matcher.
     */
    protected EventListenerRegistration(IEventListener listener, IEventMatcher matcher) {
        this(listener);
        this.eventMatcher = matcher;
    }

    /**
     * Creates a new registration configuration for the provided listener.
     *
     * @param listener the listener to configure
     *
     * @return the configuration
     */
    @SuppressWarnings("rawtypes")
    public static RegistrationListenerConfiguration configure(IEventListener listener) {
        return new RegistrationListenerConfiguration(listener);
    }

    /**
     * A registration configuration for listeners.
     *
     * @param <T> the configuration
     */
    public static class RegistrationListenerConfiguration<T extends RegistrationListenerConfiguration<T>> {

        /**
         * The notification listener of the configuration.
         */
        protected IEventListener listener;

        /**
         * The event matcher of the configuration.
         */
        protected IEventMatcher eventMatcher = ALLOW_ALL_MATCHER;

        /**
         * Sole constructor.
         *
         * @param listener the listener
         */
        protected RegistrationListenerConfiguration(IEventListener listener) {
            this.listener = listener;
            this.detectAndApplyListenerAnnotations();
        }

        /**
         * Assigns the specified event matcher to the configuration. If the specified event matcher
         * is null then the default event matcher that allows all event will be assigned.
         *
         * @param eventMatcher the event matcher
         *
         * @return this configuration for chaining
         */
        @SuppressWarnings("unchecked")
        public T withMatcher(IEventMatcher eventMatcher) {
            this.eventMatcher = eventMatcher == null ? ALLOW_ALL_MATCHER : eventMatcher;
            return (T) this;
        }

        /**
         * Creates and assigns an event matcher that will allow the specified event types.
         *
         * @param types the types to allow
         *
         * @return this configuration for chaining
         */
        public T withAllowedEvents(final EventType... types) {
            return this.withMatcher(types == null ? null : event -> event.getType().in(types));
        }

        /**
         * Creates and assigns an event matcher that will ignore the specified event types.
         *
         * @param types the types to ignore
         *
         * @return this configuration for chaining
         */
        public T withIgnoredEvents(final EventType... types) {
            return this.withMatcher(types == null ? null : event -> !event.getType().in(types));
        }

        /**
         * Creates new instance of notification listener with the configured listener and event matcher.
         *
         * @return a new instance if listener is not null, else null
         */
        public EventListenerRegistration create() {
            EventListenerRegistration registration = null;

            if (this.listener != null) {
                registration = new EventListenerRegistration(this.listener, this.eventMatcher);
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
