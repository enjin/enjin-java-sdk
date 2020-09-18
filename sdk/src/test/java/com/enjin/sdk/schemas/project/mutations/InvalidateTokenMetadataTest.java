package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class InvalidateTokenMetadataTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final String expected = "value";
        final InvalidateTokenMetadata request = new InvalidateTokenMetadata();

        // Act
        request.id(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}