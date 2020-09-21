package com.enjin.sdk.schemas.shared.queries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetPlatformTest {

    @Test
    void withContracts_HasVariable() {
        // Arrange
        final String key = "withContracts";
        final GetPlatform request = new GetPlatform();

        // Act
        request.withContracts();

        // Assert
        assertTrue(request.isSet(key));
    }

    @Test
    void withNotificationDrivers_HasVariable() {
        // Arrange
        final String key = "withNotificationDrivers";
        final GetPlatform request = new GetPlatform();

        // Act
        request.withNotificationDrivers();

        // Assert
        assertTrue(request.isSet(key));
    }

}