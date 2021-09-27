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
        final String name = "PROJECT_LINKED";
        final EventType expected = EventType.PROJECT_LINKED;

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
        final String key = "EnjinCloud\\Events\\ProjectLinked";
        final EventType expected = EventType.PROJECT_LINKED;

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
        final EventType TYPE = EventType.PROJECT_LINKED;
        final EventType[] VALUES = {EventType.PROJECT_LINKED, EventType.PROJECT_UNLINKED};
        final EventFilter filter = createEventFilter(VALUES);

        // Act
        boolean actual = TYPE.in(filter);

        // Assert
        assertTrue(actual);
    }

    @Test
    void in_IsNotInFilter_ReturnTrue() {
        // Arrange
        final EventType TYPE = EventType.PROJECT_LINKED;
        final EventType[] VALUES = {EventType.PROJECT_CREATED, EventType.PROJECT_UNLINKED};
        final EventFilter filter = createEventFilter(VALUES);

        // Act
        boolean actual = TYPE.in(filter);

        // Assert
        assertFalse(actual);
    }

    @Test
    void in_IsInParams_ReturnTrue() {
        // Arrange
        final EventType TYPE = EventType.PROJECT_LINKED;
        final EventType[] TYPES = {EventType.PROJECT_LINKED, EventType.PROJECT_UNLINKED};

        // Act
        boolean actual = TYPE.in(TYPES);

        // Assert
        assertTrue(actual);
    }

    @Test
    void in_IsNotInParams_ReturnFalse() {
        // Arrange
        final EventType TYPE = EventType.PROJECT_LINKED;
        final EventType[] TYPES = {EventType.PROJECT_CREATED, EventType.PROJECT_UNLINKED};

        // Act
        boolean actual = TYPE.in(TYPES);

        // Assert
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { "project", "player", "asset", "wallet" })
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

    private static EventFilter createEventFilter(EventType... values) {
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