package com.enjin.sdk.schemas.project.queries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AuthProjectTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final String expected = "value";
        final AuthProject request = new AuthProject();

        // Act
        request.id(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void secret_HasVariable() {
        // Arrange
        final String key = "secret";
        final String expected = "value";
        final AuthProject request = new AuthProject();

        // Act
        request.secret(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}