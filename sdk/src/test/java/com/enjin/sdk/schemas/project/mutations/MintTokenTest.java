package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.models.MintInput;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MintTokenTest {

    @Test
    void tokenId_HasVariable() {
        // Arrange
        final String key = "tokenId";
        final String expected = "value";
        final MintToken request = new MintToken();

        // Act
        request.tokenId(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void mints_HasVariable() {
        // Arrange
        final String key = "mints";
        final List<MintInput> expected = new ArrayList<>();
        final MintToken request = new MintToken();

        // Act
        request.mints(expected);
        List<MintInput> actual = (List<MintInput>) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}