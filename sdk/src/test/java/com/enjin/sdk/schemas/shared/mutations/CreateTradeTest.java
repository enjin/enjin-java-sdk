package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.models.Trade;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CreateTradeTest {

    private static final List<Trade> trades = new ArrayList<>();

    @BeforeAll
    static void setup() {
        trades.add(new Trade());
        trades.add(new Trade());
        trades.add(new Trade());
    }

    @Test
    void askingTokens_HasVariable() {
        // Arrange
        final String key = "askingTokens";
        final Trade[] expected = trades.toArray(new Trade[0]);
        final CreateTrade request = new CreateTrade();

        // Act
        request.askingTokens(expected);
        Trade[] actual = (Trade[]) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void offeringTokens_HasVariable() {
        // Arrange
        final String key = "offeringTokens";
        final Trade[] expected = trades.toArray(new Trade[0]);
        final CreateTrade request = new CreateTrade();

        // Act
        request.offeringTokens(expected);
        Trade[] actual = (Trade[]) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void recipientAddress_HasVariable() {
        // Arrange
        final String key = "recipientAddress";
        final String expected = "value";
        final CreateTrade request = new CreateTrade();

        // Act
        request.recipientAddress(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}