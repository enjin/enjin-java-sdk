package com.enjin.sdk.models;

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

class MintInputTest {

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void to_FieldContainsArgument(String expected) {
        // Arrange
        final TestableMintInput mintInput = new TestableMintInput();

        // Act
        mintInput.to(expected);
        String actual = mintInput.getTo();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void value_FieldContainsArgument(String expected) {
        // Arrange
        final TestableMintInput mintInput = new TestableMintInput();

        // Act
        mintInput.value(expected);
        String actual = mintInput.getValue();

        // Assert
        assertEquals(expected, actual);
    }

    private static class TestableMintInput extends MintInput implements Testable {

        private static final Field toField;
        private static final Field valueField;

        static {
            Class<MintInput> c = MintInput.class;
            toField = Testable.getField(c, "to");
            valueField = Testable.getField(c, "value");
        }

        @SneakyThrows
        public String getTo() {
            return (String) toField.get(this);
        }

        @SneakyThrows
        public String getValue() {
            return (String) valueField.get(this);
        }

    }

}