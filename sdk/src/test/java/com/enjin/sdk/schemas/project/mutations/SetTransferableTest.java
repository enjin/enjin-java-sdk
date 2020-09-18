package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.models.TokenTransferable;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class SetTransferableTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final SetTransferable request = new SetTransferable();

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
        final SetTransferable request = new SetTransferable();

        // Act
        request.tokenIndex(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void transferable_HasVariable(TokenTransferable expected) {
        // Arrange
        final String key = "transferable";
        final SetTransferable request = new SetTransferable();

        // Act
        request.transferable(expected);
        TokenTransferable actual = (TokenTransferable) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}