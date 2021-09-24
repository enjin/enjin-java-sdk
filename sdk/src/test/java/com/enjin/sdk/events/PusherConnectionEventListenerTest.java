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

package com.enjin.sdk.events;

import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class PusherConnectionEventListenerTest {

    private final PusherConnectionEventListener classUnderTest = new PusherConnectionEventListener();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void onConnectionStateChange_OnConnect_FutureCompletes() {
        // Arrange - Data
        final CompletableFuture<Void> future = classUnderTest.getConnectFuture();
        final ConnectionStateChange stubStateChange = mock(ConnectionStateChange.class);

        // Arrange- Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubStateChange).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubStateChange).getCurrentState();

        assumeFalse(future.isDone(), "Future completed prematurely before action was taken");

        // Act
        classUnderTest.onConnectionStateChange(stubStateChange);

        // Assert
        assertAll(future::get);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void onConnectionStateChange_OnDisconnect_FutureCompletes() {
        // Arrange - Data
        final CompletableFuture<Void> future = classUnderTest.getDisconnectFuture();
        final ConnectionStateChange stubStateChange = mock(ConnectionStateChange.class);

        // Arrange- Stubbing
        doAnswer(invocation -> ConnectionState.DISCONNECTING).when(stubStateChange).getPreviousState();
        doAnswer(invocation -> ConnectionState.DISCONNECTED).when(stubStateChange).getCurrentState();

        assumeFalse(future.isDone(), "Future completed prematurely before action was taken");

        // Act
        classUnderTest.onConnectionStateChange(stubStateChange);

        // Assert
        assertAll(future::get);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void onConnectionStateChange_OnConnect_AppendedFutureCompletes() {
        // Arrange - Data
        final CompletableFuture<Void> future = classUnderTest.appendConnectAction(() -> { });
        final ConnectionStateChange stubStateChange = mock(ConnectionStateChange.class);

        // Arrange- Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubStateChange).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubStateChange).getCurrentState();

        assumeFalse(future.isDone(), "Appended future completed prematurely before action was taken");

        // Act
        classUnderTest.onConnectionStateChange(stubStateChange);

        // Assert
        assertAll(future::get);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void onConnectionStateChange_OnDisconnect_AppendedFutureCompletes() {
        // Arrange - Data
        final CompletableFuture<Void> future = classUnderTest.appendDisconnectAction(() -> { });
        final ConnectionStateChange stubStateChange = mock(ConnectionStateChange.class);

        // Arrange- Stubbing
        doAnswer(invocation -> ConnectionState.DISCONNECTING).when(stubStateChange).getPreviousState();
        doAnswer(invocation -> ConnectionState.DISCONNECTED).when(stubStateChange).getCurrentState();

        assumeFalse(future.isDone(), "Appended future completed prematurely before action was taken");

        // Act
        classUnderTest.onConnectionStateChange(stubStateChange);

        // Assert
        assertAll(future::get);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void onError_FutureCompletesExceptionally() {
        // Arrange
        final CompletableFuture<Void> future = classUnderTest.getConnectFuture();

        assumeFalse(future.isDone(), "Future completed prematurely before action was taken");

        // Act
        classUnderTest.onError("", "", new Exception());

        // Assert
        assertThrows(Exception.class, future::get);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void onError_AppendedFutureCompletesExceptionally() {
        // Arrange
        final CompletableFuture<Void> future = classUnderTest.appendConnectAction(() -> { });

        assumeFalse(future.isDone(), "Appended future completed prematurely before action was taken");

        // Act
        classUnderTest.onError("", "", new Exception());

        // Assert
        assertThrows(Exception.class, future::get);
    }

}
