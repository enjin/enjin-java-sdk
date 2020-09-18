package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.models.TokenSupplyModel;
import com.enjin.sdk.models.TokenTransferFeeSettings;
import com.enjin.sdk.models.TokenTransferable;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class CreateTokenTest {

    @Test
    void name_HasVariable() {
        // Arrange
        final String key = "name";
        final String expected = "value";
        final CreateToken request = new CreateToken();

        // Act
        request.name(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void totalSupply_HasVariable() {
        // Arrange
        final String key = "totalSupply";
        final String expected = "value";
        final CreateToken request = new CreateToken();

        // Act
        request.totalSupply(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void initialReserve_HasVariable() {
        // Arrange
        final String key = "initialReserve";
        final String expected = "value";
        final CreateToken request = new CreateToken();

        // Act
        request.initialReserve(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void supplyModel_HasVariable(TokenSupplyModel expected) {
        // Arrange
        final String key = "supplyModel";
        final CreateToken request = new CreateToken();

        // Act
        request.supplyModel(expected);
        TokenSupplyModel actual = (TokenSupplyModel) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void meltValue_HasVariable() {
        // Arrange
        final String key = "meltValue";
        final String expected = "value";
        final CreateToken request = new CreateToken();

        // Act
        request.meltValue(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void meltFeeRatio_HasVariable() {
        // Arrange
        final String key = "meltFeeRatio";
        final int expected = 0;
        final CreateToken request = new CreateToken();

        // Act
        request.meltFeeRatio(expected);
        Integer actual = (Integer) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void transferable_HasVariable(TokenTransferable expected) {
        // Arrange
        final String key = "transferable";
        final CreateToken request = new CreateToken();

        // Act
        request.transferable(expected);
        TokenTransferable actual = (TokenTransferable) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void transferFeeSettings_HasVariable() {
        // Arrange
        final String key = "transferFeeSettings";
        final TokenTransferFeeSettings expected = createDummyTokenTransferFeeSettings();
        final CreateToken request = new CreateToken();

        // Act
        request.transferFeeSettings(expected);
        TokenTransferFeeSettings actual = (TokenTransferFeeSettings) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    @Test
    void nonfungible_HasVariable() {
        // Arrange
        final String key = "nonfungible";
        final boolean expected = true;
        final CreateToken request = new CreateToken();

        // Act
        request.nonfungible(expected);
        Boolean actual = (Boolean) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    private static TokenTransferFeeSettings createDummyTokenTransferFeeSettings() {
        return new TokenTransferFeeSettings();
    }

}