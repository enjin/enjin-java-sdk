package com.enjin.sdk.models;

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import java.lang.reflect.Field;

class TransactionSortTest {

    @ParameterizedTest
    @EnumSource
    @NullSource
    void field_FieldContainsArgument(TransactionField expected) {
        // Arrange
        final TestableTransactionSort transactionSort = new TestableTransactionSort();

        // Act
        transactionSort.field(expected);
        TransactionField actual = transactionSort.getField();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    @NullSource
    void direction_FieldContainsArgument(SortDirection expected) {
        // Arrange
        final TestableTransactionSort transactionSort = new TestableTransactionSort();

        // Act
        transactionSort.direction(expected);
        SortDirection actual = transactionSort.getDirection();

        // Assert
        assertEquals(expected, actual);
    }

    private static class TestableTransactionSort extends TransactionSort implements Testable {

        private static final Field fieldField;
        private static final Field directionField;

        static {
            Class<TransactionSort> c = TransactionSort.class;
            fieldField = Testable.getField(c, "field");
            directionField = Testable.getField(c, "direction");
        }

        @SneakyThrows
        public TransactionField getField() {
            return (TransactionField) fieldField.get(this);
        }

        @SneakyThrows
        public SortDirection getDirection() {
            return (SortDirection) directionField.get(this);
        }

    }

}