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

import com.enjin.sdk.http.ClientInterceptor;
import com.enjin.sdk.models.AccessToken;
import com.google.gson.Gson;
import lombok.NonNull;
import lombok.SneakyThrows;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import static org.awaitility.Awaitility.*;
import static org.junit.Assume.assumeNoException;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class ProjectClientTest {

    private ProjectClient classUnderTest;

    private MockWebServer mockWebServer;

    @BeforeEach
    public void BeforeEach() {
        mockWebServer = new MockWebServer();

        try {
            mockWebServer.start();
            classUnderTest = ProjectClient.builder()
                                          .baseUri(mockWebServer.url("/").toString())
                                          .build();
        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @AfterEach
    public void AfterEach() {
        try {
            mockWebServer.shutdown();
        } catch (Exception e) {
            assumeNoException(e);
        }
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

@ExtendWith(MockitoExtension.class)
class ProjectClientReauthenticateTest {

    private ProjectClient classUnderTest;

    @Mock
    private IAuthenticationEventListener mockAuthListener;

    private MockWebServer mockWebServer = new MockWebServer();

    private static final String FAKE_UUID = "FakeUuid";
    private static final String FAKE_SECRET = "FakeSecret";
    private static final Gson GSON = new Gson();

    @BeforeEach
    public void BeforeEach() {
        mockWebServer = new MockWebServer();

        try {
            mockWebServer.start();
            classUnderTest = ProjectClient.builder()
                                          .baseUri(mockWebServer.url("/").toString())
                                          .enableAutomaticReauthentication()
                                          .authenticationListener(mockAuthListener)
                                          .build();
        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @AfterEach
    public void AfterEach() {
        try {
            mockWebServer.shutdown();
        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @Test
    void auth_GivenAccessTokenWhileClientHasNullUuidAndSecret_DoesNotStartReauthenticationTimer() {
        // Arrange
        final AccessToken fakeToken = createFakeAccessToken("xyz", 1000L);

        // Assumption
        assumeTrue(classUnderTest.isAutomaticReauthenticationEnabled(), "Automatic reauthentication is disabled.");
        assumeFalse(classUnderTest.isReauthenticationRunning(), "Timer is running before call to authenticate.");

        // Act
        classUnderTest.auth(fakeToken);

        // Assert
        assertFalse(classUnderTest.isReauthenticationRunning(), "Timer is running after call to authenticate.");
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void authProject_GiveValidUuidAndSecret_ClientReauthenticates() {
        // Arrange - Data
        final String authToken = "FakeAuthToken";
        final String expectedPath = "/graphql/project";
        final String expectedHeader = ClientInterceptor.AUTHORIZATION;
        final String expectedHeaderValue = String.format("Bearer %s", authToken);
        final AccessToken fakeToken = createFakeAccessToken(authToken, 1L);
        final String responseBody = String.format("{\"data\":{\"result\":%s}}", GSON.toJson(fakeToken));

        // Arrange - Mocking
        mockWebServer.enqueue(new MockResponse().addHeader("Content-Type: application/json")
                                                .setResponseCode(200)
                                                .setBody(responseBody));

        // Assumption
        assumeTrue(classUnderTest.isAutomaticReauthenticationEnabled(), "Automatic reauthentication is disabled.");
        assumeFalse(classUnderTest.isAuthenticated(), "Is authenticated before request is sent.");

        // Act
        CompletableFuture<Void> future = classUnderTest.authClient(FAKE_UUID, FAKE_SECRET);

        await().until(future::isDone);
        await().atLeast(2, TimeUnit.SECONDS);

        // Assert
        assertFalse(future.isCompletedExceptionally(), "authClient operation completed exceptionally.");
        assertTrue(classUnderTest.isAuthenticated(), "Client was not authenticated.");

        // Verify
        RecordedRequest req1 = mockWebServer.takeRequest();
        assertEquals(expectedPath, req1.getPath(), "Req1 is not to the expected path.");
        assertNull(req1.getHeader(expectedHeader), "Req1 had authorization.");

        RecordedRequest req2 = mockWebServer.takeRequest();
        assertEquals(expectedPath, req2.getPath(), "Req2 is not to the expected path.");
        assertEquals(expectedHeaderValue, req2.getHeader(expectedHeader), "Req2 did not have authorization.");
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void auth_GivenNullToken_ListenerReceivesTimerStoppedEvent() {
        // Arrange - Data
        final AccessToken fakeToken = createFakeAccessToken("xyz", 1000L);
        final String responseBody = String.format("{\"data\":{\"result\":%s}}", GSON.toJson(fakeToken));

        // Arrange - Stubbing
        mockWebServer.enqueue(new MockResponse().addHeader("Content-Type: application/json")
                                                .setResponseCode(200)
                                                .setBody(responseBody));

        // Arrange - Data (continued)
        classUnderTest.authClient(FAKE_UUID, FAKE_SECRET).get();

        // Assumption
        assumeTrue(classUnderTest.isAuthenticated(), "Is not authenticated.");
        assumeTrue(classUnderTest.isReauthenticationRunning(), "Timer is not running.");

        // Act
        classUnderTest.auth((AccessToken) null);

        // Assert
        assertFalse(classUnderTest.isReauthenticationRunning(), "Reauthentication timer is still running.");

        // Verify
        verify(mockAuthListener).onAutomaticReauthenticationStopped();
    }

    @ParameterizedTest
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @ValueSource(longs = {0L, -1L, -100L})
    @SneakyThrows
    void auth_GivenTokenWithNonPositiveDuration_ListenerReceivesTimerStoppedEvent(long expiresIn) {
        // Arrange - Data
        final AccessToken badToken = createFakeAccessToken("xyz", expiresIn);
        final AccessToken fakeToken = createFakeAccessToken("xyz", 1000L);
        final String responseBody = String.format("{\"data\":{\"result\":%s}}", GSON.toJson(fakeToken));

        // Arrange - Stubbing
        mockWebServer.enqueue(new MockResponse().addHeader("Content-Type: application/json")
                                                .setResponseCode(200)
                                                .setBody(responseBody));

        // Arrange - Data (continued)
        classUnderTest.authClient(FAKE_UUID, FAKE_SECRET).get();

        // Assumption
        assumeTrue(classUnderTest.isAuthenticated(), "Is not authenticated.");
        assumeTrue(classUnderTest.isReauthenticationRunning(), "Timer is not running.");

        // Act
        classUnderTest.auth(badToken);

        // Assert
        assertFalse(classUnderTest.isReauthenticationRunning(), "Reauthentication timer is still running.");

        // Verify
        verify(mockAuthListener).onAutomaticReauthenticationStopped();
    }

    private static AccessToken createFakeAccessToken(@NonNull String accessToken, @NonNull Long expiresIn) {
        return GSON.fromJson(String.format("{\"accessToken\":\"%s\",\"expiresIn\":%d}", accessToken, expiresIn),
                             AccessToken.class);
    }
}