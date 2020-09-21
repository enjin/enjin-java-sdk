package com.enjin.sdk.schemas.shared.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SendEnjTest {

    @Test
    void recipientAddress_HasVariable() {
        // Arrange
        final String key = "recipientAddress";
        final String expected = "value";
        final SendEnj request = new SendEnj();

        // Act
        request.recipientAddress(expected);
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
        final SendEnj request = new SendEnj();

        // Act
        request.value(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}