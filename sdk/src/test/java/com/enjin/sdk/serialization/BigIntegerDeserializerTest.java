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

package com.enjin.sdk.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Type;
import java.math.BigInteger;

class BigIntegerDeserializerTest {

    private final BigIntegerDeserializer classUnderTest = new BigIntegerDeserializer();

    @Test
    void deserialize_JsonElementIsNotJsonPrimitive_ReturnsNull() {
        // Arrange
        final JsonElement jsonElement = new JsonObject();
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        BigInteger actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertNull(actual);
    }

    @Test
    void deserialize_NoSpecialCharacters_ReturnsExpectedValue() {
        // Arrange
        final BigInteger expected = BigInteger.valueOf(1L);
        final JsonElement jsonElement = new JsonPrimitive("1");
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        BigInteger actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void deserialize_DecimalValue_ReturnsExpectedValue() {
        // Arrange
        final BigInteger expected = BigInteger.valueOf(1L);
        final JsonElement jsonElement = new JsonPrimitive("1.0");
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        BigInteger actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void deserialize_UnsignedExponentIndicator_ReturnsExpectedValue() {
        // Arrange
        final BigInteger expected = BigInteger.valueOf(10L);
        final JsonElement jsonElement = new JsonPrimitive("1e1");
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        BigInteger actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void deserialize_PositiveExponentIndicator_ReturnsExpectedValue() {
        // Arrange
        final BigInteger expected = BigInteger.valueOf(10L);
        final JsonElement jsonElement = new JsonPrimitive("1e+1");
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        BigInteger actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void deserialize_InvalidSyntax_ThrowsException() {
        // Arrange
        final Class<JsonSyntaxException> expected = JsonSyntaxException.class;
        final JsonElement jsonElement = new JsonPrimitive("");
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Assert
        assertThrows(expected, () -> classUnderTest.deserialize(jsonElement, dummyType, dummyContext));
    }

}