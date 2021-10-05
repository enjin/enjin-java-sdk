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

package com.enjin.sdk;

import lombok.SneakyThrows;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerClientTest {

    private final MockWebServer mockWebServer = new MockWebServer();

    private PlayerClient classUnderTest;

    @BeforeEach
    public void BeforeEach() {
        try {
            mockWebServer.start();
        } catch (Exception ignored) {
        }
        classUnderTest = PlayerClient.builder()
                                     .baseUri(mockWebServer.url("/").toString())
                                     .build();
    }

    @AfterEach
    @SneakyThrows
    public void AfterEach() {
        mockWebServer.shutdown();
    }

    @Test
    void isAuthenticated_AuthenticatedWithValidToken_ReturnsTrue() {
        // Arrange
        final String fakeToken = "xyz";
        classUnderTest.auth(fakeToken);

        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertTrue(actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isAuthenticated_AuthenticatedWithInvalidToken_ReturnsFalse(final String fakeToken) {
        // Arrange
        classUnderTest.auth(fakeToken);

        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isClosed_ClientHasBeenClosed_ReturnsTrue() {
        // Arrange
        classUnderTest.close();

        // Act
        boolean actual = classUnderTest.isClosed();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isClosed_ClientHasNotBeenClosed_ReturnsFalse() {
        // Act
        boolean actual = classUnderTest.isClosed();

        // Assert
        assertFalse(actual);
    }

}