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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RegistrationListenerConfigurationTest {

    @Test
    void create_CreatedRegistrationHasListener() {
        // Arrange
        final IEventListener expected = new Listener();
        final RegistrationListenerConfiguration configuration = EventListenerRegistration.configure(expected);

        // Act
        IEventListener actual = configuration.create()
                                             .getListener();

        // Assert
        assertSame(expected, actual);
    }

    @Test
    void create_DefaultMatcher_CreatedRegistrationHasNonNullMatcher() {
        // Arrange
        final RegistrationListenerConfiguration configuration = defaultRegistrationListenerConfiguration();

        // Act
        IEventMatcher actual = configuration.create()
                                            .getEventMatcher();

        // Assert
        assertNotNull(actual);
    }

    @Test
    void withMatcher_CreatedRegistrationHasMatcher() {
        // Arrange
        final IEventMatcher expected = event -> true;
        final RegistrationListenerConfiguration configuration = defaultRegistrationListenerConfiguration();

        // Act
        IEventMatcher actual = configuration.withMatcher(expected)
                                            .create()
                                            .getEventMatcher();

        // Assert
        assertSame(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void withAllowedEvents_CreatedRegistrationAllowsEvents(EventType allowedType) {
        // Arrange
        final RegistrationListenerConfiguration configuration = defaultRegistrationListenerConfiguration();

        // Act
        IEventMatcher matcher = configuration.withAllowedEvents(allowedType)
                                             .create()
                                             .getEventMatcher();

        // Assert
        for (EventType type : EventType.values()) {
            NotificationEvent event = createNotificationEvent(type);
            boolean expected = type == allowedType;
            boolean actual   = matcher.matches(event);
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @EnumSource
    void withIgnoredEvents_CreatedRegistrationIgnoresEvents(EventType ignoredType) {
        // Arrange
        final RegistrationListenerConfiguration configuration = defaultRegistrationListenerConfiguration();

        // Act
        IEventMatcher matcher = configuration.withIgnoredEvents(ignoredType)
                                             .create()
                                             .getEventMatcher();

        // Assert
        for (EventType type : EventType.values()) {
            NotificationEvent event = createNotificationEvent(type);
            boolean expected = type == ignoredType;
            boolean actual   = matcher.matches(event);
            assertNotEquals(expected, actual);
        }
    }

    private static NotificationEvent createNotificationEvent(EventType type) {
        return new NotificationEvent(type, "", "");
    }

    private static RegistrationListenerConfiguration defaultRegistrationListenerConfiguration() {
        return EventListenerRegistration.configure(new Listener());
    }

    private static class Listener implements IEventListener {

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

}
