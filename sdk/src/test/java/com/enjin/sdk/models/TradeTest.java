package com.enjin.sdk.models;

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

class TradeTest {

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void tokenId_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTrade trade = new TestableTrade();

        // Act
        trade.tokenId(expected);
        String actual = trade.getTokenId();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void tokenIndex_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTrade trade = new TestableTrade();

        // Act
        trade.tokenIndex(expected);
        String actual = trade.getTokenIndex();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void value_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTrade trade = new TestableTrade();

        // Act
        trade.value(expected);
        String actual = trade.getValue();

        // Assert
        assertEquals(expected, actual);
    }

    private static class TestableTrade extends Trade implements Testable {

        private static final Field tokenIdField;
        private static final Field tokenIndexField;
        private static final Field valueField;

        static {
            Class<Trade> c = Trade.class;
            tokenIdField = Testable.getField(c, "tokenId");
            tokenIndexField = Testable.getField(c, "tokenIndex");
            valueField = Testable.getField(c, "value");
        }

        @SneakyThrows
        public String getTokenId() {
            return (String) tokenIdField.get(this);
        }

        @SneakyThrows
        public String getTokenIndex() {
            return (String) tokenIndexField.get(this);
        }

        @SneakyThrows
        public String getValue() {
            return (String) valueField.get(this);
        }

    }

}