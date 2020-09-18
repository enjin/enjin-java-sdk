package com.enjin.sdk.models;

import com.enjin.sdk.TestFilterInterface;
import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;

class BalanceFilterTest implements TestFilterInterface {

    @ParameterizedTest
    @ValueSource(strings = "0000000000000000")
    @NullAndEmptySource
    void tokenId_FieldContainsArgument(String expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.tokenId(expected);
        String actual = filter.getTokenId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void tokenIdIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();
        final String[] args = ids.toArray(new String[0]);

        // Act
        filter.tokenIdIn(args);
        List<String> actual = filter.getTokenIdIn();

        // Assert
        assertTrue(args.length > 0);
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void tokenIdIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.tokenIdIn();
        List<String> actual = filter.getTokenIdIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void tokenIdIn_NullArgument_FieldIsNull() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.tokenIdIn(null);
        List<String> actual = filter.getTokenIdIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void value_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.value(expected);
        Integer actual = filter.getValue();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void valueGreaterThan_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.valueGreaterThan(expected);
        Integer actual = filter.getValueGreaterThan();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void valueGreaterThanOrEqual_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.valueGreaterThanOrEqual(expected);
        Integer actual = filter.getValueGreaterThanOrEqual();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void valueLessThan_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.valueLessThan(expected);
        Integer actual = filter.getValueLessThan();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void valueLessThanOrEqual_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.valueLessThanOrEqual(expected);
        Integer actual = filter.getValueLessThanOrEqual();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0x0")
    @NullAndEmptySource
    void wallet_FieldContainsArgument(String expected) {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.wallet(expected);
        String actual = filter.getWallet();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();
        final String[] args = ids.toArray(new String[0]);

        // Act
        filter.walletIn(args);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertTrue(args.length > 0);
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void walletIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.walletIn();
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void walletIn_NullArgument_FieldIsNull() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.walletIn(null);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNull(actual);
    }

    private static class TestableBalanceFilter extends BalanceFilter implements Testable {

        private static final Field tokenIdField;
        private static final Field tokenIdInField;
        private static final Field walletField;
        private static final Field walletInField;
        private static final Field valueField;
        private static final Field valueGtField;
        private static final Field valueGteField;
        private static final Field valueLtField;
        private static final Field valueLteField;

        static {
            Class<BalanceFilter> c = BalanceFilter.class;
            tokenIdField = Testable.getField(c, "tokenId");
            tokenIdInField = Testable.getField(c, "tokenIdIn");
            walletField = Testable.getField(c, "wallet");
            walletInField = Testable.getField(c, "walletIn");
            valueField = Testable.getField(c, "value");
            valueGtField = Testable.getField(c, "valueGt");
            valueGteField = Testable.getField(c, "valueGte");
            valueLtField = Testable.getField(c, "valueLt");
            valueLteField = Testable.getField(c, "valueLte");
        }

        @SneakyThrows
        public String getTokenId() {
            return (String) tokenIdField.get(this);
        }

        @SneakyThrows
        public List<String> getTokenIdIn() {
            return (List<String>) tokenIdInField.get(this);
        }

        @SneakyThrows
        public String getWallet() {
            return (String) walletField.get(this);
        }

        @SneakyThrows
        public List<String> getWalletIn() {
            return (List<String>) walletInField.get(this);
        }

        @SneakyThrows
        public Integer getValue() {
            return (Integer) valueField.get(this);
        }

        @SneakyThrows
        public Integer getValueGreaterThan() {
            return (Integer) valueGtField.get(this);
        }

        @SneakyThrows
        public Integer getValueGreaterThanOrEqual() {
            return (Integer) valueGteField.get(this);
        }

        @SneakyThrows
        public Integer getValueLessThan() {
            return (Integer) valueLtField.get(this);
        }

        @SneakyThrows
        public Integer getValueLessThanOrEqual() {
            return (Integer) valueLteField.get(this);
        }

    }

}