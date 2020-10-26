package com.enjin.sdk.models;

import com.enjin.sdk.events.EventFilter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

class EventTypeTest {

    @Test
    void getFromName_ValidName_ReturnCorrectEnum() {
        // Arrange
        final String name = "APP_LINKED";
        final EventType expected = EventType.APP_LINKED;

        // Act
        EventType actual = EventType.getFromName(name);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFromName_InvalidName_ReturnUnknownEnum() {
        // Arrange
        final String name = "";
        final EventType expected = EventType.UNKNOWN;

        // Act
        EventType actual = EventType.getFromName(name);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFromKey_ValidKey_ReturnCorrectEnum() {
        // Arrange
        final String key = "EnjinCloud\\Events\\AppLinked";
        final EventType expected = EventType.APP_LINKED;

        // Act
        EventType actual = EventType.getFromKey(key);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFromKey_InvalidKey_ReturnUnknownEnum() {
        // Arrange
        final String key = "";
        final EventType expected = EventType.UNKNOWN;

        // Act
        EventType actual = EventType.getFromKey(key);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void in_IsInFilter_ReturnTrue() {
        // Arrange
        final EventType TYPE = EventType.APP_LINKED;
        final EventType[] VALUES = { EventType.APP_LINKED, EventType.APP_UNLINKED };
        final EventFilter filter = createdEventFilter(VALUES);

        // Act
        boolean actual = TYPE.in(filter);

        // Assert
        assertTrue(actual);
    }

    @Test
    void in_IsNotInFilter_ReturnTrue() {
        // Arrange
        final EventType TYPE = EventType.APP_LINKED;
        final EventType[] VALUES = { EventType.APP_CREATED, EventType.APP_UNLINKED };
        final EventFilter filter = createdEventFilter(VALUES);

        // Act
        boolean actual = TYPE.in(filter);

        // Assert
        assertFalse(actual);
    }

    @Test
    void in_IsInParams_ReturnTrue() {
        // Arrange
        final EventType TYPE = EventType.APP_LINKED;
        final EventType[] TYPES = { EventType.APP_LINKED, EventType.APP_UNLINKED };

        // Act
        boolean actual = TYPE.in(TYPES);

        // Assert
        assertTrue(actual);
    }

    @Test
    void in_IsNotInParams_ReturnFalse() {
        // Arrange
        final EventType TYPE = EventType.APP_LINKED;
        final EventType[] TYPES = { EventType.APP_CREATED, EventType.APP_UNLINKED };

        // Act
        boolean actual = TYPE.in(TYPES);

        // Assert
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { "app", "player", "token", "wallet" })
    void filterByChannelTypes_ValidChannel_ReturnEventsContainingChannel(String channel) {
        // Act
        List<EventType> actualTypes = EventType.filterByChannelTypes(channel);

        // Assert
        for (EventType type : EventType.values()) {
            List<String> channels = Arrays.asList(type.getChannels());
            boolean expected = channels.contains(channel);
            boolean actual = actualTypes.contains(type);
            assertEquals(expected, actual);
        }
    }

    private static EventFilter createdEventFilter(EventType... values) {
        return new EventFilter() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public EventType[] value() {
                return values;
            }

            @Override
            public boolean allow() {
                return true;
            }
        };
    }

}