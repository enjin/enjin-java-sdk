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

import com.enjin.sdk.models.PaginationCursor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

class GraphQLResponseTest {

    private static final Object DEFAULT_DATA = new Object();
    private static final List<GraphQLError> DEFAULT_ERRORS = new ArrayList<>();
    private static final PaginationCursor DEFAULT_CURSOR = new PaginationCursor();

    @BeforeAll
    public static void BeforeAll() {
        DEFAULT_ERRORS.add(new GraphQLError());
        DEFAULT_ERRORS.add(new GraphQLError());
        DEFAULT_ERRORS.add(new GraphQLError());
    }

    @Test
    void isEmpty_NullData_ReturnsTrue() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       null,
                                                                       null,
                                                                       null);

        // Act
        boolean actual = response.isEmpty();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isEmpty_NonNullData_ReturnsTrue() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       DEFAULT_DATA,
                                                                       null,
                                                                       null);

        // Act
        boolean actual = response.isEmpty();

        // Assert
        assertFalse(actual);
    }

    @Test
    void hasErrors_NonEmptyErrors_ReturnsTrue() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       null,
                                                                       DEFAULT_ERRORS,
                                                                       null);

        // Act
        boolean actual = response.hasErrors();

        // Assert
        assertTrue(actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void hasErrors_NullAndEmptyErrors_ReturnsFalse(final List<GraphQLError> errors) {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       null,
                                                                       errors,
                                                                       null);

        // Act
        boolean actual = response.hasErrors();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isPaginated_NonNullCursor_ReturnsTrue() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       null,
                                                                       null,
                                                                       DEFAULT_CURSOR);

        // Act
        boolean actual = response.isPaginated();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isPaginated_NullCursor_ReturnsFalse() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       null,
                                                                       null,
                                                                       null);

        // Act
        boolean actual = response.isPaginated();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isSuccess_HasDataAndDoesNotHaveErrors_ReturnsTrue() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       DEFAULT_DATA,
                                                                       null,
                                                                       null);

        // Act
        boolean actual = response.isSuccess();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isSuccess_HasDataAndHasErrors_ReturnsFalse() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       DEFAULT_DATA,
                                                                       DEFAULT_ERRORS,
                                                                       null);

        // Act
        boolean actual = response.isSuccess();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isSuccess_DoesNotHaveDataAndHasErrors_ReturnsFalse() {
        // Arrange
        final GraphQLResponse<Object> response = new GraphQLResponse<>(null,
                                                                       null,
                                                                       DEFAULT_ERRORS,
                                                                       null);

        // Act
        boolean actual = response.isSuccess();

        // Assert
        assertFalse(actual);
    }

}