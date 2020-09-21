package com.enjin.sdk.schemas.shared.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MessageTest {

    @Test
    void message_HasVariable() {
        // Arrange
        final String key = "message";
        final String expected = "value";
        final Message request = new Message();

        // Act
        request.message(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}