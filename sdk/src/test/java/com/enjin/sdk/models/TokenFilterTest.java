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

class TokenFilterTest implements TestFilterInterface {

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void id_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.id(expected);
        String actual = filter.getId();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void name_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.name(expected);
        String actual = filter.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void nameContains_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.nameContains(expected);
        String actual = filter.getNameContains();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();
        final String[] args = ids.toArray(new String[0]);

        // Act
        filter.idId(args);
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
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.idId();
        List<String> actual = filter.getIdIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void idIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.idId(null);
        List<String> actual = filter.getIdIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void nameIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();
        final String[] args = ids.toArray(new String[0]);

        // Act
        filter.nameIn(args);
        List<String> actual = filter.getNameIn();

        // Assert
        assertTrue(args.length > 0);
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void nameIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.nameIn();
        List<String> actual = filter.getNameIn();

        // Assert
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void nameIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.nameIn(null);
        List<String> actual = filter.getNameIn();

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void nameStartsWith_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.nameStartsWith(expected);
        String actual = filter.getNameStartsWith();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void nameEndsWith_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.nameEndsWith(expected);
        String actual = filter.getNameEndsWith();

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "0")
    @NullAndEmptySource
    void wallet_FieldContainsArgument(String expected) {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.wallet(expected);
        String actual = filter.getWallet();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();
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
        final TestableTokenFilter filter = new TestableTokenFilter();

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
        final TestableTokenFilter filter = new TestableTokenFilter();

        // Act
        filter.walletIn(null);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNull(actual);
    }

    private static class TestableTokenFilter extends TokenFilter implements Testable {

        private static final Field idField;
        private static final Field idInField;
        private static final Field nameField;
        private static final Field nameContainsField;
        private static final Field nameInField;
        private static final Field nameStartsWithField;
        private static final Field nameEndsWithField;
        private static final Field walletField;
        private static final Field walletInField;

        static {
            Class<TokenFilter> c = TokenFilter.class;
            idField = Testable.getField(c, "id");
            idInField = Testable.getField(c, "idIn");
            nameField = Testable.getField(c, "name");
            nameContainsField = Testable.getField(c, "nameContains");
            nameInField = Testable.getField(c, "nameIn");
            nameStartsWithField = Testable.getField(c, "nameStartsWith");
            nameEndsWithField = Testable.getField(c, "nameEndsWith");
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
        public String getName() {
            return (String) nameField.get(this);
        }

        @SneakyThrows
        public String getNameContains() {
            return (String) nameContainsField.get(this);
        }

        @SneakyThrows
        public List<String> getNameIn() {
            return (List<String>) nameInField.get(this);
        }

        @SneakyThrows
        public String getNameStartsWith() {
            return (String) nameStartsWithField.get(this);
        }

        @SneakyThrows
        public String getNameEndsWith() {
            return (String) nameEndsWithField.get(this);
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