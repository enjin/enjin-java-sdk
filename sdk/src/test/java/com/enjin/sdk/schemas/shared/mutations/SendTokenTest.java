package com.enjin.sdk.schemas.shared.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SendTokenTest {

    @Test
    void recipientAddress_HasVariable() {
        // Arrange
        final String key = "recipientAddress";
        final String expected = "value";
        final SendToken request = new SendToken();

        // Act
        request.recipientAddress(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final SendToken request = new SendToken();

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
        final SendToken request = new SendToken();

        // Act
        request.tokenIndex(expected);
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
        final SendToken request = new SendToken();

        // Act
        request.value(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void data_HasVariable() {
        // Arrange
        final String key = "data";
        final String expected = "value";
        final SendToken request = new SendToken();

        // Act
        request.data(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}