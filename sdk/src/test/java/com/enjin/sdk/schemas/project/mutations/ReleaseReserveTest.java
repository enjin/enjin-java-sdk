package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ReleaseReserveTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final ReleaseReserve request = new ReleaseReserve();

        // Act
        request.tokenId(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void value_HasVariable() {
        // Arrange
        final String key = "value";
        final String expected = "value";
        final ReleaseReserve request = new ReleaseReserve();

        // Act
        request.value(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}