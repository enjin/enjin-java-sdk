package com.enjin.sdk.models;

import com.enjin.sdk.TestFilterInterface;
import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;

class PlayerFilterTest implements TestFilterInterface {

    @ParameterizedTest
    @ValueSource(strings = "player0")
    @NullAndEmptySource
    void id_FieldContainsArgument(String expected) {
        // Arrange
        final TestablePlayerFilter filter = new TestablePlayerFilter();

        // Act
        filter.id(expected);
        String actual = filter.getId();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestablePlayerFilter filter = new TestablePlayerFilter();
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
        final TestablePlayerFilter filter = new TestablePlayerFilter();

        // Act
        filter.idIn();
        List<String> actual = filter.getIdIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void idIn_NullArgument_FieldIsNull() {
        // Arrange
        final TestablePlayerFilter filter = new TestablePlayerFilter();

        // Act
        filter.idIn(null);
        List<String> actual = filter.getIdIn();

        // Assert
        assertNull(actual);
    }

    private static class TestablePlayerFilter extends PlayerFilter implements Testable {

        private static final Field idField;
        private static final Field idInField;

        static {
            Class<PlayerFilter> c = PlayerFilter.class;
            idField = Testable.getField(c, "id");
            idInField = Testable.getField(c, "idIn");
        }

        @SneakyThrows
        public String getId() {
            return (String) idField.get(this);
        }

        @SneakyThrows
        public List<String> getIdIn() {
            return (List<String>) idInField.get(this);
        }

    }

}