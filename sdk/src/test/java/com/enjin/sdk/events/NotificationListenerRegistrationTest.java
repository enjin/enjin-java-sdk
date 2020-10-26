package com.enjin.sdk.events;

import com.enjin.sdk.events.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.NotificationEvent;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class NotificationListenerRegistrationTest {

    @Test
    void configure_ConfigurationHasListener() {
        // Arrange
        final NotificationListener expected = new Listener();

        // Act
        RegistrationListenerConfiguration configuration = NotificationListenerRegistration.configure(expected);
        NotificationListener actual = configuration.listener;

        // Assert
        assertSame(expected, actual);
    }

    @Test
    void configure_AllowedEvents_ConfigurationAppliesEventFilter() {
        // Arrange
        final List<EventType> allowedTypes = Arrays.asList(AllowedFilteredListener.ALLOWED_EVENTS);
        final NotificationListener filteredListener = new AllowedFilteredListener();

        // Act
        RegistrationListenerConfiguration configuration = NotificationListenerRegistration.configure(filteredListener);
        EventMatcher matcher = configuration.eventMatcher;

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
        final NotificationListener filteredListener = new IgnoredFilteredListener();

        // Act
        RegistrationListenerConfiguration configuration = NotificationListenerRegistration.configure(filteredListener);
        EventMatcher matcher = configuration.eventMatcher;

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

    private static class Listener implements NotificationListener {

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

    @EventFilter(value = {EventType.APP_CREATED, EventType.APP_DELETED})
    private static class AllowedFilteredListener implements NotificationListener {

        public static final EventType[] ALLOWED_EVENTS = {EventType.APP_CREATED, EventType.APP_DELETED};

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

    @EventFilter(allow = false, value = {EventType.APP_CREATED, EventType.APP_DELETED})
    private static class IgnoredFilteredListener implements NotificationListener {

        public static final EventType[] IGNORED_EVENTS = {EventType.APP_CREATED, EventType.APP_DELETED};

        @Override
        public void notificationReceived(NotificationEvent event) { }

    }

}