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

class PlayerFilterTest implements TestFilterInterface {

    @Test
    void idIn_PassedArguments_FieldContainsArguments() {
        // Arrange
        final TestablePlayerFilter filter = new TestablePlayerFilter();
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
        final TestablePlayerFilter filter = new TestablePlayerFilter();

        // Act
        filter.idIn();
        List<String> actual = filter.getIdIn();

        // Assert
        assertTrue(actual.isEmpty());
    }

    @Test
    void idIn_NullArgument_FieldIsNull() {
        // Arrange
        final TestablePlayerFilter filter = new TestablePlayerFilter();

        // Act
        filter.idIn((String[]) null);
        List<String> actual = filter.getIdIn();

        // Assert
        assertNull(actual);
    }

    private static class TestablePlayerFilter extends PlayerFilter implements Testable {

        private static final Field idInField;

        static {
            Class<PlayerFilter> c = PlayerFilter.class;
            idInField = Testable.getField(c, "idIn");
        }

        @SneakyThrows
        public List<String> getIdIn() {
            return (List<String>) idInField.get(this);
        }

    }

}