package com.enjin.sdk.models;

import com.enjin.sdk.TestFilterInterface;
import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;

class TransactionFilterTest implements TestFilterInterface {

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void id_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.id(expected);
        String actual = filter.getId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final String[] args = ids.toArray(new String[0]);

        // Act
        filter.idIn(args);
        List<String> actual = filter.getIdIn();

        // Assert
        assertTrue(args.length > 0);
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void idIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.idIn();
        List<String> actual = filter.getIdIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void idIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.idIn(null);
        List<String> actual = filter.getIdIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void transactionId_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.transactionId(expected);
        String actual = filter.getTransactionId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void transactionIdIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final String[] args = ids.toArray(new String[0]);

        // Act
        filter.transactionIdIn(args);
        List<String> actual = filter.getTransactIdIn();

        // Assert
        assertTrue(args.length > 0);
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void transactionIdIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.transactionIdIn();
        List<String> actual = filter.getTransactIdIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void transactionIdIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.transactionIdIn(null);
        List<String> actual = filter.getTransactIdIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void tokenId_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.tokenId(expected);
        String actual = filter.getTokenId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void tokenIdIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.tokenIdIn();
        List<String> actual = filter.getTokenIdIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void tokenIdIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.tokenIdIn(null);
        List<String> actual = filter.getTokenIdIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @EnumSource
    void type_FieldContainsArgument(RequestType expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.type(expected);
        RequestType actual = filter.getType();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void typeIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final RequestType[] args = RequestType.values();

        // Act
        filter.typeIn(args);
        List<RequestType> actual = filter.getTypeIn();

        // Assert
        assertTrue(args.length > 0);
        for (RequestType v : args) {
            assertTrue(actual.contains(v));
        }
    }

    @Test
    void typeIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.typeIn();
        List<RequestType> actual = filter.getTypeIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void typeIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.typeIn(null);
        List<RequestType> actual = filter.getTypeIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void value_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.valueLessThanOrEqual(expected);
        Integer actual = filter.getValueLessThanOrEqual();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void state_FieldContainsArgument(RequestState expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.state(expected);
        RequestState actual = filter.getState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void stateIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final RequestState[] args = RequestState.values();

        // Act
        filter.stateIn(args);
        List<RequestState> actual = filter.getStateIn();

        // Assert
        assertTrue(args.length > 0);
        for (RequestState v : args) {
            assertTrue(actual.contains(v));
        }
    }

    @Test
    void stateIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.stateIn();
        List<RequestState> actual = filter.getStateIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void stateIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.stateIn(null);
        List<RequestState> actual = filter.getStateIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void wallet_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.wallet(expected);
        String actual = filter.getWallet();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.walletIn();
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void walletIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.walletIn(null);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNull(actual);
    }

    private static class TestableTransactionFilter extends TransactionFilter implements Testable {

        private static final Field idField;
        private static final Field idInField;
        private static final Field transactionIdField;
        private static final Field transactIdInField;
        private static final Field tokenIdField;
        private static final Field tokenIdInField;
        private static final Field typeField;
        private static final Field typeInField;
        private static final Field valueField;
        private static final Field valueGtField;
        private static final Field valueGteField;
        private static final Field valeLtField;
        private static final Field valueLteField;
        private static final Field stateField;
        private static final Field stateInField;
        private static final Field walletField;
        private static final Field walletInField;

        static {
            Class<TransactionFilter> c = TransactionFilter.class;
            idField = Testable.getField(c, "id");
            idInField = Testable.getField(c, "idIn");
            transactionIdField = Testable.getField(c, "transactionId");
            transactIdInField = Testable.getField(c, "transactionIdIn");
            tokenIdField = Testable.getField(c, "tokenId");
            tokenIdInField = Testable.getField(c, "tokenIdIn");
            typeField = Testable.getField(c, "type");
            typeInField = Testable.getField(c, "typeIn");
            valueField = Testable.getField(c, "value");
            valueGtField = Testable.getField(c, "valueGt");
            valueGteField = Testable.getField(c, "valueGte");
            valeLtField = Testable.getField(c, "valueLt");
            valueLteField = Testable.getField(c, "valueLte");
            stateField = Testable.getField(c, "state");
            stateInField = Testable.getField(c, "stateIn");
            walletField = Testable.getField(c, "wallet");
            walletInField = Testable.getField(c, "walletIn");
        }

        @SneakyThrows
        public String getId() {
            return (String) idField.get(this);
        }

        @SneakyThrows
        public List<String> getIdIn() {
            return (List<String>) idInField.get(this);
        }

        @SneakyThrows
        public String getTransactionId() {
            return (String) transactionIdField.get(this);
        }

        @SneakyThrows
        public List<String> getTransactIdIn() {
            return (List<String>) transactIdInField.get(this);
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
        public RequestType getType() {
            return (RequestType) typeField.get(this);
        }

        @SneakyThrows
        public List<RequestType> getTypeIn() {
            return (List<RequestType>) typeInField.get(this);
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
            return (Integer) valeLtField.get(this);
        }

        @SneakyThrows
        public Integer getValueLessThanOrEqual() {
            return (Integer) valueLteField.get(this);
        }

        @SneakyThrows
        public RequestState getState() {
            return (RequestState) stateField.get(this);
        }

        @SneakyThrows
        public List<RequestState> getStateIn() {
            return (List<RequestState>) stateInField.get(this);
        }

        @SneakyThrows
        public String getWallet() {
            return (String) walletField.get(this);
        }

        @SneakyThrows
        public List<String> getWalletIn() {
            return (List<String>) walletInField.get(this);
        }

    }

}