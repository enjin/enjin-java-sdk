package com.enjin.sdk.graphql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class GraphQLRequestTest {

    @Test
    void set_NewNonNullValue_RequestContainsValue() {
        // Arrange
        final Object expected = new Object();
        final String KEY = "variable";
        final GraphQLRequest request = defaultRequest();

        // Act
        request.set(KEY, expected);
        Object actual = request.getVariables().get(KEY);

        // Assert
        assertSame(expected, actual);
    }

    @Test
    void set_NonNullValueOverwrite_RequestOverwritesValue() {
        // Arrange
        final Object expected = new Object();
        final String KEY = "variable";
        final Object FIRST_VALUE = new Object();
        final GraphQLRequest request = defaultRequest();
        request.set(KEY, FIRST_VALUE);

        // Act
        request.set(KEY, expected);
        Object actual = request.getVariables().get(KEY);

        // Assert
        assertSame(expected, actual);
    }

    @ParameterizedTest
    @NullSource
    void set_NewNullValue_RequestDoesNotContainValue(Object value) {
        // Arrange
        final String KEY = "variable";
        final GraphQLRequest request = defaultRequest();

        // Act
        request.set(KEY, value);
        Object actual = request.getVariables().get(KEY);

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @NullSource
    void set_NullValueOverwrite_RequestDoesNotContainValue(Object value) {
        // Arrange
        final String KEY = "variable";
        final Object FIRST_VALUE = new Object();
        final GraphQLRequest request = defaultRequest();
        request.set(KEY, FIRST_VALUE);

        // Act
        request.set(KEY, value);
        Object actual = request.getVariables().get(KEY);

        // Assert
        assertNull(actual);
    }

    @ParameterizedTest
    @EmptySource
    void set_EmptyKey_ThrowsIllegalArgumentException(String key) {
        // Arrange
        final Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        final Object VALUE = new Object();
        final GraphQLRequest request = defaultRequest();

        // Assert
        assertThrows(expected, () -> request.set(key, VALUE));
    }

    @ParameterizedTest
    @NullSource
    void set_NullKey_ThrowsNullPointerException(String key) {
        // Arrange
        final Class<NullPointerException> expected = NullPointerException.class;
        final Object VALUE = new Object();
        final GraphQLRequest request = defaultRequest();

        // Assert
        assertThrows(expected, () -> request.set(key, VALUE));
    }

    @Test
    void isSet_ValueIsSet_ReturnTrue() {
        // Arrange
        final String KEY = "variable";
        final Object VALUE = new Object();
        final GraphQLRequest request = defaultRequest();
        request.set(KEY, VALUE);

        // Act
        boolean actual = request.isSet(KEY);

        // Assert
        assertTrue(actual);
    }

    @Test
    void isSet_ValueIsNotSet_ReturnFalse() {
        // Arrange
        final String KEY = "variable";
        final GraphQLRequest request = defaultRequest();

        // Act
        boolean actual = request.isSet(KEY);

        // Assert
        assertFalse(actual);
    }

    @ParameterizedTest
    @NullSource
    void isSet_NullOverwrite_ReturnFalse(Object value) {
        // Arrange
        final String KEY = "variable";
        final Object FIRST_VALUE = new Object();
        final GraphQLRequest request = defaultRequest();
        request.set(KEY, FIRST_VALUE);

        // Act
        request.set(KEY, value);
        boolean actual = request.isSet(KEY);

        // Assert
        assertFalse(actual);
    }

    private static GraphQLRequest defaultRequest() {
        return new GraphQLRequest("");
    }

}