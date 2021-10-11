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

import com.enjin.sdk.events.EventListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.NotificationEvent;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class IEventListenerRegistrationTest {

    @Test
    void configure_ConfigurationHasListener() {
        // Arrange
        final IEventListener expected = new Listener();

        // Act
        RegistrationListenerConfiguration configuration = EventListenerRegistration.configure(expected);
        IEventListener actual = configuration.listener;

        // Assert
        assertSame(expected, actual);
    }

    @Test
    void configure_AllowedEvents_ConfigurationAppliesEventFilter() {
        // Arrange
        final List<EventType> allowedTypes = Arrays.asList(AllowedFilteredListener.ALLOWED_EVENTS);
        final IEventListener filteredListener = new AllowedFilteredListener();

        // Act
        RegistrationListenerConfiguration configuration = EventListenerRegistration.configure(filteredListener);
        IEventMatcher matcher = configuration.eventMatcher;

        // Assert
        for (EventType type : EventType.values()) {
            NotificationEvent event = createNotificationEvent(type);
            boolean expected = allowedTypes.contains(type);
            boolean actual   = matcher.matches(event);
            assertEquals(expected, actual);
        }
    }

    @Test
    void configure_IgnoredEvents_ConfigurationAppliesEventFilter() {
        // Arrange
        final List<EventType> ignoredTypes = Arrays.asList(IgnoredFilteredListener.IGNORED_EVENTS);
        final IEventListener filteredListener = new IgnoredFilteredListener();

        // Act
        RegistrationListenerConfiguration configuration = EventListenerRegistration.configure(filteredListener);
        IEventMatcher matcher = configuration.eventMatcher;

        // Assert
        for (EventType type : EventType.values()) {
            NotificationEvent event = createNotificationEvent(type);
            boolean expected = ignoredTypes.contains(type);
            boolean actual   = matcher.matches(event);
            assertNotEquals(expected, actual);
        }
    }

    private static NotificationEvent createNotificationEvent(EventType type) {
        return new NotificationEvent(type, "", "");
    }

    private static class Listener implements IEventListener {

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

    @EventFilter(value = {EventType.PROJECT_CREATED, EventType.PROJECT_DELETED})
    private static class AllowedFilteredListener implements IEventListener {

        public static final EventType[] ALLOWED_EVENTS = {EventType.PROJECT_CREATED, EventType.PROJECT_DELETED};

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

    @EventFilter(allow = false, value = {EventType.PROJECT_CREATED, EventType.PROJECT_DELETED})
    private static class IgnoredFilteredListener implements IEventListener {

        public static final EventType[] IGNORED_EVENTS = {EventType.PROJECT_CREATED, EventType.PROJECT_DELETED};

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

}