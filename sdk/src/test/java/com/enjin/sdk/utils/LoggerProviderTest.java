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

package com.enjin.sdk.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class,})
class LoggerProviderTest {

    public static String DEFAULT_MESSAGE = "Test Message";
    public static Exception DEFAULT_EXCEPTION = new Exception("Test Exception");

    public LoggerProvider classUnderTest;

    @Mock
    public ILogger mockLogger;

    @BeforeEach
    void setUp() {
        classUnderTest = new LoggerProvider(mockLogger);
    }

    @Test
    void log_GivenMessage_LogsDataAtDefaultLevel() {
        // Arrange - Data
        final LogLevel level = classUnderTest.getDefaultLevel();
        final String message = DEFAULT_MESSAGE;

        // Arrange - Stubbing
        doAnswer(invocation -> true).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.log(message);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, times(1)).log(eq(level), eq(message));
    }

    @Test
    void debug_GivenMessage_LogsDataAtDebugLevel() {
        // Arrange - Data
        final LogLevel level = classUnderTest.getDebugLevel();
        final String message = DEFAULT_MESSAGE;

        // Arrange - Stubbing
        doAnswer(invocation -> true).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.debug(message);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, times(1)).log(eq(level), eq(message));
    }

    @ParameterizedTest
    @EnumSource(LogLevel.class)
    void log_GivenMessageWithLoggableLevel_LogsDataAtLoggingLevel(final LogLevel level) {
        // Arrange - Data
        final String message = DEFAULT_MESSAGE;

        // Arrange - Stubbing
        doAnswer(invocation -> true).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.log(level, message);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, times(1)).log(eq(level), eq(message));
    }

    @ParameterizedTest
    @EnumSource(LogLevel.class)
    void log_GivenMessageWithNonLoggableLevel_DoesNotLogData(final LogLevel level) {
        // Arrange - Data
        final String message = DEFAULT_MESSAGE;

        // Arrange - Stubbing
        doAnswer(invocation -> false).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.log(level, message);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, never()).log(eq(level), eq(message));
    }

    @Test
    void log_GivenMessageAndException_LogsDataAtDefaultLevel() {
        // Arrange - Data
        final LogLevel level = classUnderTest.getDefaultLevel();
        final String message = DEFAULT_MESSAGE;
        final Exception e = DEFAULT_EXCEPTION;

        // Arrange - Stubbing
        doAnswer(invocation -> true).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.log(message, e);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, times(1)).log(eq(level), eq(message), eq(e));
    }

    @Test
    void debug_GivenMessageAndException_LogsDataAtDebugLevel() {
        // Arrange - Data
        final LogLevel level = classUnderTest.getDebugLevel();
        final String message = DEFAULT_MESSAGE;
        final Exception e = DEFAULT_EXCEPTION;

        // Arrange - Stubbing
        doAnswer(invocation -> true).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.debug(message, e);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, times(1)).log(eq(level), eq(message), eq(e));
    }

    @ParameterizedTest
    @EnumSource(LogLevel.class)
    void log_GivenMessageAndExceptionWithLoggableLevel_LogsDataAtLoggingLevel(final LogLevel level) {
        // Arrange - Data
        final String message = DEFAULT_MESSAGE;
        final Exception e = DEFAULT_EXCEPTION;

        // Arrange - Stubbing
        doAnswer(invocation -> true).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.log(level, message, e);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, times(1)).log(eq(level), eq(message), eq(e));
    }

    @ParameterizedTest
    @EnumSource(LogLevel.class)
    void log_GivenMessageAndExceptionWithNonLoggableLevel_DoesNotLogData(final LogLevel level) {
        // Arrange - Data
        final String message = DEFAULT_MESSAGE;
        final Exception e = DEFAULT_EXCEPTION;

        // Arrange - Stubbing
        doAnswer(invocation -> false).when(mockLogger).isLoggable(eq(level));

        // Act
        classUnderTest.log(level, message, e);

        // Verify
        verify(mockLogger, atLeastOnce()).isLoggable(eq(level));
        verify(mockLogger, never()).log(eq(level), eq(message), eq(e));
    }

}