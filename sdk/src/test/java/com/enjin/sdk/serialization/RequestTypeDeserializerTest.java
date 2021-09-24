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

import com.enjin.sdk.models.RequestType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Type;

class RequestTypeDeserializerTest {

    private final RequestTypeDeserializer classUnderTest = new RequestTypeDeserializer();

    @Test
    void deserialize_JsonElementIsNotJsonPrimitive_ReturnsUnknown() {
        // Arrange
        final RequestType expected = RequestType.UNKNOWN;
        final JsonElement jsonElement = new JsonObject();
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        RequestType actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void deserialize_ValidString_ReturnsExpectedRequestType(RequestType expected) {
        // Arrange
        final JsonElement jsonElement = new JsonPrimitive(expected.toString());
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        RequestType actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void deserialize_InvalidString_ReturnsUnknown() {
        // Arrange
        final RequestType expected = RequestType.UNKNOWN;
        final JsonElement jsonElement = new JsonPrimitive("");
        final Type dummyType = mock(Type.class);
        final JsonDeserializationContext dummyContext = mock(JsonDeserializationContext.class);

        // Act
        RequestType actual = classUnderTest.deserialize(jsonElement, dummyType, dummyContext);

        // Assert
        assertEquals(expected, actual);
    }

}