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
        classUnderTest = new PlayerClient(mockWebServer.url("/").toString());
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