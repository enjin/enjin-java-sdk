package com.enjin.sdk.models;

import com.enjin.sdk.TestFilterInterface;
import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

class TokenFilterTest implements TestFilterInterface {

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();
        final String[] args = ids.toArray(new String[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.idId(args);
        List<String> actual = filter.getIdIn();

        // Assert
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

        assumeTrue(args.length > 0);

        // Act
        filter.nameIn(args);
        List<String> actual = filter.getNameIn();

        // Assert
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

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTokenFilter filter = new TestableTokenFilter();
        final String[] args = ids.toArray(new String[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.walletIn(args);
        List<String> actual = filter.getWalletIn();

        // Assert
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

        private static final Field idInField;
        private static final Field nameInField;
        private static final Field walletInField;

        static {
            Class<TokenFilter> c = TokenFilter.class;
            idInField = Testable.getField(c, "idIn");
            nameInField = Testable.getField(c, "nameIn");
            walletInField = Testable.getField(c, "walletIn");
        }

        @SneakyThrows
        public List<String> getIdIn() {
            return (List<String>) idInField.get(this);
        }

        @SneakyThrows
        public List<String> getNameIn() {
            return (List<String>) nameInField.get(this);
        }

        @SneakyThrows
        public List<String> getWalletIn() {
            return (List<String>) walletInField.get(this);
        }

    }

}