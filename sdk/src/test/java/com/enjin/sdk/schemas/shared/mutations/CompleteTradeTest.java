package com.enjin.sdk.schemas.shared.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CompleteTradeTest {

    @Test
    void tradeId_HasVariable() {
        // Arrange
        final String key = "tradeId";
        final String expected = "value";
        final CompleteTrade request = new CompleteTrade();

        // Act
        request.tradeId(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}