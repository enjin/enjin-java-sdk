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

package com.enjin.sdk.http;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class HttpResponseTest {

    private static final int DEFAULT_CODE = 200;
    private static final Object DEFAULT_BODY = new Object();

    @ParameterizedTest
    @MethodSource("successfulStatusCodeProvider")
    void isSuccess_StatusCodeIs2xx_ReturnsTrue(final int code) {
        // Arrange
        final HttpResponse<Object> response = new HttpResponse<>(code, null);

        // Act
        boolean actual = response.isSuccess();

        // Assert
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("unsuccessfulStatusCodeProvider")
    void isSuccess_StatusCodeIsNot2xx_ReturnsFalse(final int code) {
        // Arrange
        final HttpResponse<Object> response = new HttpResponse<>(code, null);

        // Act
        boolean actual = response.isSuccess();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isEmpty_NullBody_ReturnsTrue() {
        // Arrange
        final HttpResponse<Object> response = new HttpResponse<>(DEFAULT_CODE, null);

        // Act
        boolean actual = response.isEmpty();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isEmpty_NonNullBody_ReturnsFalse() {
        // Arrange
        final HttpResponse<Object> response = new HttpResponse<>(DEFAULT_CODE, DEFAULT_BODY);

        // Act
        boolean actual = response.isEmpty();

        // Assert
        assertFalse(actual);
    }

    private static Stream<Arguments> successfulStatusCodeProvider() {
        List<Arguments> argumentsList = new ArrayList<>(100);
        for (int i = 200; i < 300; i++) {
            argumentsList.add(Arguments.of(i));
        }

        return argumentsList.stream();
    }

    private static Stream<Arguments> unsuccessfulStatusCodeProvider() {
        List<Arguments> argumentsList = new ArrayList<>(400);
        for (int i = 100; i < 200; i++) {
            argumentsList.add(Arguments.of(i));
        }
        for (int i = 300; i < 600; i++) {
            argumentsList.add(Arguments.of(i));
        }

        return argumentsList.stream();
    }

}