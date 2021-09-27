/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.models;

import com.enjin.sdk.TestFilterInterface;
import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

class AssetFilterTest implements TestFilterInterface {

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();
        final String[] args = ids.toArray(new String[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.idIn(args);
        List<String> actual = filter.getIdIn();

        // Assert
        for (String s : args) {
            assertTrue(actual.contains(s));
        }
    }

    @Test
    void idIn_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();

        // Act
        filter.idIn();
        List<String> actual = filter.getIdIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void idIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();

        // Act
        filter.idIn((String[]) null);
        List<String> actual = filter.getIdIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void nameIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();
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
        final TestableAssetFilter filter = new TestableAssetFilter();

        // Act
        filter.nameIn();
        List<String> actual = filter.getNameIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void nameIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();

        // Act
        filter.nameIn((String[]) null);
        List<String> actual = filter.getNameIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();
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
        final TestableAssetFilter filter = new TestableAssetFilter();

        // Act
        filter.walletIn();
        List<String> actual = filter.getWalletIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void walletIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableAssetFilter filter = new TestableAssetFilter();

        // Act
        filter.walletIn((String[]) null);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNull(actual);
    }

    private static class TestableAssetFilter extends AssetFilter implements Testable {

        private static final Field idInField;
        private static final Field nameInField;
        private static final Field walletInField;

        static {
            Class<AssetFilter> c = AssetFilter.class;
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