package com.enjin.sdk.events;

import com.enjin.sdk.events.NotificationListenerRegistration.RegistrationListenerConfiguration;
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
        final NotificationListener expected = new Listener();
        final RegistrationListenerConfiguration configuration = NotificationListenerRegistration.configure(expected);

        // Act
        NotificationListener actual = configuration.create()
                                                   .getListener();

        // Assert
        assertSame(expected, actual);
    }

    @Test
    void create_DefaultMatcher_CreatedRegistrationHasNonNullMatcher() {
        // Arrange
        final RegistrationListenerConfiguration configuration = defaultRegistrationListenerConfiguration();

        // Act
        EventMatcher actual = configuration.create()
                                           .getEventMatcher();

        // Assert
        assertNotNull(actual);
    }

    @Test
    void withMatcher_CreatedRegistrationHasMatcher() {
        // Arrange
        final EventMatcher expected = event -> true;
        final RegistrationListenerConfiguration configuration = defaultRegistrationListenerConfiguration();

        // Act
        EventMatcher actual = configuration.withMatcher(expected)
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
        EventMatcher matcher = configuration.withAllowedEvents(allowedType)
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
        EventMatcher matcher = configuration.withIgnoredEvents(ignoredType)
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
        return NotificationListenerRegistration.configure(new Listener());
    }

    private static class Listener implements NotificationListener {

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

}
