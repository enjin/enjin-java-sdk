package com.enjin.sdk.schemas.shared.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ApproveEnjTest {

    @Test
    void value_HasVariable() {
        // Arrange
        final String key = "value";
        final String expected = "value";
        final ApproveEnj request = new ApproveEnj();

        // Act
        request.value(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}