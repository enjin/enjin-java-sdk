package com.enjin.sdk.models;

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

class PaginationOptionsTest {

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void page_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestablePaginationOptions options = new TestablePaginationOptions();

        // Act
        options.page(expected);
        Integer actual = options.getPage();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    void limit_FieldContainsArgument(Integer expected) {
        // Arrange
        final TestablePaginationOptions options = new TestablePaginationOptions();

        // Act
        options.limit(expected);
        Integer actual = options.getLimit();

        // Assert
        assertEquals(expected, actual);
    }

    private static class TestablePaginationOptions extends PaginationOptions implements Testable {

        private static final Field pageField;
        private static final Field limitField;

        static {
            Class<PaginationOptions> c = PaginationOptions.class;
            pageField = Testable.getField(c, "page");
            limitField = Testable.getField(c, "limit");
        }

        @SneakyThrows
        public Integer getPage() {
            return (Integer) pageField.get(this);
        }

        @SneakyThrows
        public Integer getLimit() {
            return (Integer) limitField.get(this);
        }

    }

}