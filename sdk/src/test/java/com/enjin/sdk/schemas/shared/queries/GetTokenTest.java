package com.enjin.sdk.schemas.shared.queries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetTokenTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final String expected = "value";
        final GetToken request = new GetToken();

        // Act
        request.id(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}