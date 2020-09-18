package com.enjin.sdk.models;

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import java.lang.reflect.Field;

class TokenSortTest {

    @ParameterizedTest
    @EnumSource
    @NullSource
    void field_FieldContainsArgument(TokenField expected) {
        // Arrange
        final TestableTokenSort tokenSort = new TestableTokenSort();

        // Act
        tokenSort.field(expected);
        TokenField actual = tokenSort.getField();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    @NullSource
    void direction_FieldContainsArgument(SortDirection expected) {
        // Arrange
        final TestableTokenSort tokenSort = new TestableTokenSort();

        // Act
        tokenSort.direction(expected);
        SortDirection actual = tokenSort.getDirection();

        // Assert
        assertEquals(expected, actual);
    }

    private static class TestableTokenSort extends TokenSort implements Testable {

        private static final Field fieldField;
        private static final Field directionField;

        static {
            Class<TokenSort> c = TokenSort.class;
            fieldField = Testable.getField(c, "field");
            directionField = Testable.getField(c, "direction");
        }

        @SneakyThrows
        public TokenField getField() {
            return (TokenField) fieldField.get(this);
        }

        @SneakyThrows
        public SortDirection getDirection() {
            return (SortDirection) directionField.get(this);
        }

    }

}