package com.enjin.sdk.schemas.shared.queries;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetRequestTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final int expected = 1;
        final GetRequest request = new GetRequest();

        // Act
        request.id(expected);
        Integer actual = (Integer) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void transactionId_HasVariable() {
        // Arrange
        final String key = "transactionId";
        final String expected = "value";
        final GetRequest request = new GetRequest();

        // Act
        request.transactionId(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}