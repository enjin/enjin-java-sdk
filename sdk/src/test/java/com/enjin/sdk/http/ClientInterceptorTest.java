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

import lombok.SneakyThrows;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientInterceptorTest {

    private final ClientInterceptor classUnderTest = new ClientInterceptor();

    @Test
    @SneakyThrows
    void intercept_HasNotBeenAuthenticated_AddsOnlyUserToHeader() {
        // Arrange - Data
        final String expectedUserHeader = ClientInterceptor.USER_AGENT;
        final Request dummyRequest = mock(Request.class);
        final Response dummyResponse = mock(Response.class);
        final Chain stubChain = mock(Chain.class);
        final Request stubRequest = mock(Request.class);
        final Request.Builder mockBuilder = mock(Request.Builder.class);

        // Arrange - Stubbing
        when(stubChain.request()).thenReturn(stubRequest);
        when(stubRequest.newBuilder()).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(dummyRequest);
        when(stubChain.proceed(any())).thenReturn(dummyResponse);

        // Act
        classUnderTest.intercept(stubChain);

        // Verify
        InOrder inOrder = Mockito.inOrder(ignoreStubs(mockBuilder));
        inOrder.verify(mockBuilder)
               .header(eq(expectedUserHeader), anyString());
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    @SneakyThrows
    void intercept_HasBeenAuthenticated_AddsUserAndAuthToHeader() {
        // Arrange - Data
        final String expectedUserHeader = ClientInterceptor.USER_AGENT;
        final String expectedAuthHeader = ClientInterceptor.AUTHORIZATION;
        final Request dummyRequest = mock(Request.class);
        final Response dummyResponse = mock(Response.class);
        final Chain stubChain = mock(Chain.class);
        final Request stubRequest = mock(Request.class);
        final Request.Builder mockBuilder = mock(Request.Builder.class);
        classUnderTest.setToken("xyz");

        // Arrange - Stubbing
        when(stubChain.request()).thenReturn(stubRequest);
        when(stubRequest.newBuilder()).thenReturn(mockBuilder);
        when(mockBuilder.build()).thenReturn(dummyRequest);
        when(stubChain.proceed(any())).thenReturn(dummyResponse);

        // Act
        classUnderTest.intercept(stubChain);

        // Verify
        InOrder inOrder = Mockito.inOrder(ignoreStubs(mockBuilder));
        inOrder.verify(mockBuilder)
               .header(eq(expectedUserHeader), anyString());
        inOrder.verify(mockBuilder)
               .header(eq(expectedAuthHeader), anyString());
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    void isAuthenticated_AuthTokenHasBeenSet_ReturnsTrue() {
        // Arrange
        classUnderTest.setToken("xyz");

        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isAuthenticated_AuthTokenHasNotBeenSet_ReturnsFalse() {
        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isAuthenticated_AuthTokenIsEmpty_ReturnsFalse() {
        // Arrange
        classUnderTest.setToken("");

        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertFalse(actual);
    }

}