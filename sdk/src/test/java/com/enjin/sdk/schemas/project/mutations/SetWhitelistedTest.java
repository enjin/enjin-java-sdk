package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.models.Whitelisted;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class SetWhitelistedTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final SetWhitelisted request = new SetWhitelisted();

        // Act
        request.tokenId(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void accountAddress_HasVariable() {
        // Arrange
        final String key = "accountAddress";
        final String expected = "value";
        final SetWhitelisted request = new SetWhitelisted();

        // Act
        request.accountAddress(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void whitelisted_HasVariable(Whitelisted expected) {
        // Arrange
        final String key = "whitelisted";
        final SetWhitelisted request = new SetWhitelisted();

        // Act
        request.whitelisted(expected);
        Whitelisted actual = (Whitelisted) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void whitelistedAddress_HasVariable() {
        // Arrange
        final String key = "whitelistedAddress";
        final String expected = "value";
        final SetWhitelisted request = new SetWhitelisted();

        // Act
        request.whitelistedAddress(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void on_HasVariable() {
        // Arrange
        final String key = "on";
        final boolean expected = true;
        final SetWhitelisted request = new SetWhitelisted();

        // Act
        request.on(expected);
        Boolean actual = (Boolean) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}