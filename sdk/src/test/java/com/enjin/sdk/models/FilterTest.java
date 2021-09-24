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

import com.enjin.sdk.Testable;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class FilterTest {

    private static List<TestableFilter> filters;

    @BeforeAll
    static void setup() {
        filters = new ArrayList<>();
        filters.add(new TestableFilter());
        filters.add(new TestableFilter());
        filters.add(new TestableFilter());
    }

    @Test
    void and_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableFilter filter = new TestableFilter();
        final TestableFilter[] args = filters.toArray(new TestableFilter[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.and(args);
        List<TestableFilter> actual = filter.getAnd();

        // Assert
        for (TestableFilter f : args) {
            assertTrue(actual.contains(f));
        }
    }

    @Test
    void and_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableFilter filter = new TestableFilter();

        // Act
        filter.and();
        List<TestableFilter> actual = filter.getAnd();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void and_NullArgument_FieldIsNull() {
        // Arrange
        final TestableFilter filter = new TestableFilter();

        // Act
        filter.and((TestableFilter[]) null);
        List<TestableFilter> actual = filter.getAnd();

        // Assert
        assertNull(actual);
    }

    @Test
    void or_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestableFilter filter = new TestableFilter();
        final TestableFilter[] args = filters.toArray(new TestableFilter[0]);

        assumeTrue(args.length > 0);

        // Act
        filter.or(args);
        List<TestableFilter> actual = filter.getOr();

        // Assert
        for (TestableFilter f : args) {
            assertTrue(actual.contains(f));
        }
    }

    @Test
    void or_NoArguments_FieldIsEmpty() {
        // Arrange
        final TestableFilter filter = new TestableFilter();

        // Act
        filter.or();
        List<TestableFilter> actual = filter.getOr();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void or_NullArgument_FieldIsNull() {
        // Arrange
        final TestableFilter filter = new TestableFilter();

        // Act
        filter.or((TestableFilter[]) null);
        List<TestableFilter> actual = filter.getOr();

        // Assert
        assertNull(actual);
    }

    private static class TestableFilter extends Filter<TestableFilter> implements Testable {

        private static final Field andField;
        private static final Field orField;

        static {
            Class<Filter> c = Filter.class;
            andField = Testable.getField(c, "and");
            orField = Testable.getField(c, "or");
        }

        @SneakyThrows
        public List<TestableFilter> getAnd() {
            return (List<TestableFilter>) andField.get(this);
        }

        @SneakyThrows
        public List<TestableFilter> getOr() {
            return (List<TestableFilter>) orField.get(this);
        }

    }

}