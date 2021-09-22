/* Copyright 2021 Enjin Pte Ltd.
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

class TransactionFilterTest implements TestFilterInterface {

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.idIn();
        List<String> actual = filter.getIdIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void idIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.idIn((String[]) null);
        List<String> actual = filter.getIdIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void transactionIdIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final String[] args = ids.toArray(new String[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.transactionIdIn(args);
        List<String> actual = filter.getTransactIdIn();

        // Assert
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
        assertTrue(actual.isEmpty());
    }

    @Test
    void transactionIdIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.transactionIdIn((String[]) null);
        List<String> actual = filter.getTransactIdIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void assetIdIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.assetIdIn();
        List<String> actual = filter.getAssetIdIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void assetIdIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.assetIdIn((String[]) null);
        List<String> actual = filter.getAssetIdIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void typeIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final RequestType[] args = RequestType.values();

        assumeTrue(args.length > 0);

        // Act
        filter.typeIn(args);
        List<RequestType> actual = filter.getTypeIn();

        // Assert
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
        assertTrue(actual.isEmpty());
    }

    @Test
    void typeIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.typeIn((RequestType[]) null);
        List<RequestType> actual = filter.getTypeIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void stateIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
        final RequestState[] args = RequestState.values();

        assumeTrue(args.length > 0);

        // Act
        filter.stateIn(args);
        List<RequestState> actual = filter.getStateIn();

        // Assert
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
        assertTrue(actual.isEmpty());
    }

    @Test
    void stateIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.stateIn((RequestState[]) null);
        List<RequestState> actual = filter.getStateIn();

        // Assert
        assertNull(actual);
    }

    @Test
    void walletIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();
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
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.walletIn();
        List<String> actual = filter.getWalletIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void walletIn_NullArguments_FieldIsNull() {
        // Arrange
        final TestableTransactionFilter filter = new TestableTransactionFilter();

        // Act
        filter.walletIn((String[]) null);
        List<String> actual = filter.getWalletIn();

        // Assert
        assertNull(actual);
    }

    private static class TestableTransactionFilter extends TransactionFilter implements Testable {

        private static final Field idInField;
        private static final Field transactIdInField;
        private static final Field assetIdInField;
        private static final Field typeInField;
        private static final Field stateInField;
        private static final Field walletInField;

        static {
            Class<TransactionFilter> c = TransactionFilter.class;
            idInField = Testable.getField(c, "idIn");
            transactIdInField = Testable.getField(c, "transactionIdIn");
            assetIdInField = Testable.getField(c, "assetIdIn");
            typeInField = Testable.getField(c, "typeIn");
            stateInField = Testable.getField(c, "stateIn");
            walletInField = Testable.getField(c, "walletIn");
        }

        @SneakyThrows
        public List<String> getIdIn() {
            return (List<String>) idInField.get(this);
        }

        @SneakyThrows
        public List<String> getTransactIdIn() {
            return (List<String>) transactIdInField.get(this);
        }

        @SneakyThrows
        public List<String> getAssetIdIn() {
            return (List<String>) assetIdInField.get(this);
        }

        @SneakyThrows
        public List<RequestType> getTypeIn() {
            return (List<RequestType>) typeInField.get(this);
        }

        @SneakyThrows
        public List<RequestState> getStateIn() {
            return (List<RequestState>) stateInField.get(this);
        }

        @SneakyThrows
        public List<String> getWalletIn() {
            return (List<String>) walletInField.get(this);
        }

    }

}