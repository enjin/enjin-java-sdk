package com.enjin.sdk.models;

import com.enjin.sdk.TestFilterInterface;
import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

class BalanceFilterTest implements TestFilterInterface {

    @Test
    void assetIdIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();
        final String[] args = ids.toArray(new String[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.assetIdIn(args);
        List<String> actual = filter.getAssetIdIn();

        // Assert
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void assetIdIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.assetIdIn();
        List<String> actual = filter.getAssetIdIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void assetIdIn_NullArgument_FieldIsNull() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.assetIdIn((String[]) null);
        List<String> actual = filter.getAssetIdIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();
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
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.walletIn();
        List<String> actual = filter.getWalletIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void walletIn_NullArgument_FieldIsNull() {
        // Arrange
        final TestableBalanceFilter filter = new TestableBalanceFilter();

        // Act
        filter.walletIn((String[]) null);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNull(actual);
    }

    private static class TestableBalanceFilter extends BalanceFilter implements Testable {

        private static final Field assetIdInField;
        private static final Field walletInField;

        static {
            Class<BalanceFilter> c = BalanceFilter.class;
            assetIdInField = Testable.getField(c, "assetIdIn");
            walletInField = Testable.getField(c, "walletIn");
        }

        @SneakyThrows
        public List<String> getAssetIdIn() {
            return (List<String>) assetIdInField.get(this);
        }

        @SneakyThrows
        public List<String> getWalletIn() {
            return (List<String>) walletInField.get(this);
        }

    }

}