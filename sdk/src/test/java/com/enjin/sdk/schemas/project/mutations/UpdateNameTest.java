package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UpdateNameTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final UpdateName request = new UpdateName();

        // Act
        request.tokenId(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void tokenIndex_HasVariable() {
        // Arrange
        final String key = "tokenIndex";
        final String expected = "value";
        final UpdateName request = new UpdateName();

        // Act
        request.tokenIndex(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void name_HasVariable() {
        // Arrange
        final String key = "name";
        final String expected = "value";
        final UpdateName request = new UpdateName();

        // Act
        request.name(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}