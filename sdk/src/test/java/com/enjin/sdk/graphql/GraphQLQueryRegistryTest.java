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

package com.enjin.sdk.graphql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GraphQLQueryRegistryTest {

    private static final String DEFAULT_KEY = "key";
    private static final String DEFAULT_QUERY = "query";

    @Test
    void register_RegistryDoesNotHaveKey_ReturnsTrue() {
        // Arrange
        final String key = DEFAULT_KEY;
        final String query = DEFAULT_QUERY;
        final GraphQLQueryRegistry registry = createDefaultQueryRegistry();

        // Act
        boolean actual = registry.register(key, query);

        // Assert
        assertTrue(actual);
    }

    @Test
    void register_RegistryHasKey_ReturnsFalse() {
        // Arrange
        final String key = DEFAULT_KEY;
        final String query1 = DEFAULT_QUERY + "1";
        final String query2 = DEFAULT_QUERY + "2";
        final GraphQLQueryRegistry registry = createDefaultQueryRegistry();
        registry.register(key, query1);

        // Act
        boolean actual = registry.register(key, query2);

        // Assert
        assertFalse(actual);
    }

    @Test
    void has_RegistryHasKey_ReturnsTrue() {
        // Arrange
        final String key = DEFAULT_KEY;
        final GraphQLQueryRegistry registry = createDefaultQueryRegistry();
        registry.register(key, DEFAULT_QUERY);

        // Act
        boolean actual = registry.has(key);

        // Assert
        assertTrue(actual);
    }

    @Test
    void has_RegistryDoesNotHaveKey_ReturnsFalse() {
        // Arrange
        final String key = DEFAULT_KEY;
        final GraphQLQueryRegistry registry = createDefaultQueryRegistry();

        // Act
        boolean actual = registry.has(key);

        // Assert
        assertFalse(actual);
    }

    @Test
    void get_RegistryHasMapping_ReturnsQuery() {
        // Arrange
        final String expected = DEFAULT_QUERY;
        final String key = DEFAULT_KEY;
        final GraphQLQueryRegistry registry = createDefaultQueryRegistry();
        registry.register(key, expected);

        // Act
        String actual = registry.get(key);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void has_RegistryDoesNotHaveMapping_ReturnsNull() {
        // Arrange
        final String key = DEFAULT_KEY;
        final GraphQLQueryRegistry registry = createDefaultQueryRegistry();

        // Act
        String actual = registry.get(key);

        // Assert
        assertNull(actual);
    }

    private static GraphQLQueryRegistry createDefaultQueryRegistry() {
        return new GraphQLQueryRegistry();
    }

}