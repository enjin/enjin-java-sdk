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

class TrustedPlatformInterceptorTest {

    private final TrustedPlatformInterceptor classUnderTest = new TrustedPlatformInterceptor();

    @Test
    @SneakyThrows
    void intercept_HasNotBeenAuthenticated_AddsOnlyUserToHeader() {
        // Arrange - Data
        final String expectedUserHeader = TrustedPlatformInterceptor.USER_AGENT;
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
        final String expectedUserHeader = TrustedPlatformInterceptor.USER_AGENT;
        final String expectedAuthHeader = TrustedPlatformInterceptor.AUTHORIZATION;
        final Request dummyRequest = mock(Request.class);
        final Response dummyResponse = mock(Response.class);
        final Chain stubChain = mock(Chain.class);
        final Request stubRequest = mock(Request.class);
        final Request.Builder mockBuilder = mock(Request.Builder.class);
        classUnderTest.auth("xyz");

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
    void isAuthenticated_HasBeenAuthenticated_ReturnsTrue() {
        // Arrange
        classUnderTest.auth("xyz");

        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertTrue(actual);
    }

    @Test
    void isAuthenticated_HasNotBeenAuthenticated_ReturnsFalse() {
        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertFalse(actual);
    }

    @Test
    void isAuthenticated_AuthenticatedWithEmptyToken_ReturnsFalse() {
        // Arrange
        classUnderTest.auth("");

        // Act
        boolean actual = classUnderTest.isAuthenticated();

        // Assert
        assertFalse(actual);
    }

}