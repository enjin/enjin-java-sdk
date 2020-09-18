package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.models.TokenTransferFeeSettings;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SetTransferFeeTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final SetTransferFee request = new SetTransferFee();

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
        final SetTransferFee request = new SetTransferFee();

        // Act
        request.tokenIndex(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void transferFeeSettings_HasVariable() {
        // Arrange
        final String key = "transferFeeSettings";
        final TokenTransferFeeSettings expected = createDummyTokenTransferFeeSettings();
        final SetTransferFee request = new SetTransferFee();

        // Act
        request.transferFeeSettings(expected);
        TokenTransferFeeSettings actual = (TokenTransferFeeSettings) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    private static TokenTransferFeeSettings createDummyTokenTransferFeeSettings() {
        return new TokenTransferFeeSettings();
    }

}