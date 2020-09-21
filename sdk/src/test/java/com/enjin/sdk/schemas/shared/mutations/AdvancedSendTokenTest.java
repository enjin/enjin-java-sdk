package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.models.Transfers;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AdvancedSendTokenTest {

    private static final List<Transfers> transfers = new ArrayList<>();

    @BeforeAll
    static void setup() {
        transfers.add(new Transfers());
        transfers.add(new Transfers());
        transfers.add(new Transfers());
    }

    @Test
    void transfers_HasVariable() {
        // Arrange
        final String key = "transfers";
        final Transfers[] expected = transfers.toArray(new Transfers[0]);
        final AdvancedSendToken request = new AdvancedSendToken();

        // Act
        request.transfers(expected);
        Transfers[] actual = (Transfers[]) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void data_HasVariable() {
        // Arrange
        final String key = "data";
        final String expected = "value";
        final AdvancedSendToken request = new AdvancedSendToken();

        // Act
        request.data(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}