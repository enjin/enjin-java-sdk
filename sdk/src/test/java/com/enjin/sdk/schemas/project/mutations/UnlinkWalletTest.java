package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UnlinkWalletTest {

    @Test
    void ethAddress_HasVariable() {
        // Arrange
        final String key = "ethAddress";
        final String expected = "value";
        final UnlinkWallet request = new UnlinkWallet();

        // Act
        request.ethAddress(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}