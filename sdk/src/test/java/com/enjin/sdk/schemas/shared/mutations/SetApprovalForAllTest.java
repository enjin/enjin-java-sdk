package com.enjin.sdk.schemas.shared.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SetApprovalForAllTest {

    @Test
    void operatorAddress_HasVariable() {
        // Arrange
        final String key = "operatorAddress";
        final String expected = "value";
        final SetApprovalForAll request = new SetApprovalForAll();

        // Act
        request.operatorAddress(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void approved_HasVariable() {
        // Arrange
        final String key = "approved";
        final boolean expected = true;
        final SetApprovalForAll request = new SetApprovalForAll();

        // Act
        request.approved(expected);
        Boolean actual = (Boolean) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}