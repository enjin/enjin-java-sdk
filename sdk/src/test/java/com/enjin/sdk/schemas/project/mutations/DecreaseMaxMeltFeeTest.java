package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DecreaseMaxMeltFeeTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final DecreaseMaxMeltFee request = new DecreaseMaxMeltFee();

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
        final DecreaseMaxMeltFee request = new DecreaseMaxMeltFee();

        // Act
        request.tokenIndex(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void maxMeltFee_HasVariable() {
        // Arrange
        final String key = "maxMeltFee";
        final int expected = 0;
        final DecreaseMaxMeltFee request = new DecreaseMaxMeltFee();

        // Act
        request.maxMeltFee(expected);
        Integer actual = (Integer) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}