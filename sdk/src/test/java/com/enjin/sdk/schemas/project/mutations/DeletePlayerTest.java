package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DeletePlayerTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final String expected = "value";
        final DeletePlayer request = new DeletePlayer();

        // Act
        request.id(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}