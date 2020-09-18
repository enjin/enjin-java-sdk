package com.enjin.sdk.models;

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

class TransfersTest {

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void from(String expected) {
        // Arrange
        final TestableTransfers transfers = new TestableTransfers();

        // Act
        transfers.from(expected);
        String actual = transfers.getFrom();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void to(String expected) {
        // Arrange
        final TestableTransfers transfers = new TestableTransfers();

        // Act
        transfers.to(expected);
        String actual = transfers.getTo();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void tokenId(String expected) {
        // Arrange
        final TestableTransfers transfers = new TestableTransfers();

        // Act
        transfers.tokenId(expected);
        String actual = transfers.getTokenId();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void tokenIndex(String expected) {
        // Arrange
        final TestableTransfers transfers = new TestableTransfers();

        // Act
        transfers.tokenIndex(expected);
        String actual = transfers.getTokenIndex();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void value(String expected) {
        // Arrange
        final TestableTransfers transfers = new TestableTransfers();

        // Act
        transfers.value(expected);
        String actual = transfers.getValue();

        // Assert
        assertEquals(expected, actual);
    }

    private static class TestableTransfers extends Transfers implements Testable {

        private static final Field fromField;
        private static final Field toField;
        private static final Field tokenIdField;
        private static final Field tokenIndexField;
        private static final Field valueField;

        static {
            Class<Transfers> c = Transfers.class;
            fromField = Testable.getField(c, "from");
            toField = Testable.getField(c, "to");
            tokenIdField = Testable.getField(c, "tokenId");
            tokenIndexField = Testable.getField(c, "tokenIndex");
            valueField = Testable.getField(c, "value");
        }

        @SneakyThrows
        public String getFrom() {
            return (String) fromField.get(this);
        }

        @SneakyThrows
        public String getTo() {
            return (String) toField.get(this);
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