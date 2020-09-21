package com.enjin.sdk.schemas.shared.queries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetProjectTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final int expected = 1;
        final GetProject request = new GetProject();

        // Act
        request.id(expected);
        Integer actual = (Integer) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void name_HasVariable() {
        // Arrange
        final String key = "name";
        final String expected = "value";
        final GetProject request = new GetProject();

        // Act
        request.name(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}