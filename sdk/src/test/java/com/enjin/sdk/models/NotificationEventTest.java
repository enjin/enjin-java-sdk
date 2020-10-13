package com.enjin.sdk.models;

import com.google.gson.JsonObject;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import org.junit.jupiter.api.Test;

class NotificationEventTest {

    private static final EventType DEFAULT_TYPE = EventType.UNKNOWN;
    private static final String DEFAULT_CHANNEL = "xyz";
    private static final String DEFAULT_MESSAGE = "{\"data\": \"message\"}";

    @Test
    void getData_GetsDeserializedData() {
        // Arrange
        final NotificationEvent notificationEvent = createDefaultNotificationEvent();

        assumeFalse(notificationEvent.getMessage() == null);
        assumeFalse(notificationEvent.getMessage().isEmpty());

        // Act
        JsonObject actual = notificationEvent.getData();

        // Assert
        assertNotNull(actual);
    }

    private static NotificationEvent createDefaultNotificationEvent() {
        return new NotificationEvent(DEFAULT_TYPE, DEFAULT_CHANNEL, DEFAULT_MESSAGE);
    }

}