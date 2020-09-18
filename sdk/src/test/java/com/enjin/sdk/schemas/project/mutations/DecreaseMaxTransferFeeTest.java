package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DecreaseMaxTransferFeeTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final DecreaseMaxTransferFee request = new DecreaseMaxTransferFee();

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
        final DecreaseMaxTransferFee request = new DecreaseMaxTransferFee();

        // Act
        request.tokenIndex(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void maxTransferFee_HasVariable() {
        // Arrange
        final String key = "maxTransferFee";
        final int expected = 0;
        final DecreaseMaxTransferFee request = new DecreaseMaxTransferFee();

        // Act
        request.maxTransferFee(expected);
        Integer actual = (Integer) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}