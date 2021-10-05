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

package com.enjin.sdk.events;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.events.channels.AssetChannel;
import com.enjin.sdk.events.channels.PlayerChannel;
import com.enjin.sdk.events.channels.ProjectChannel;
import com.enjin.sdk.events.channels.WalletChannel;
import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.NotificationEvent;
import com.enjin.sdk.models.Platform;
import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.ChannelEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;
import lombok.SneakyThrows;
import org.awaitility.Awaitility;
import static org.awaitility.Awaitility.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.MockedConstruction;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PusherNotificationServiceTest {

    private static final Platform DEFAULT_PLATFORM = PlatformUtils.FAKE_PLATFORM;

    @BeforeEach
    public void BeforeEach() {
        Awaitility.reset();
    }

    @Test
    void registerListener_ReturnRegistrationWithListener() {
        // Arrange
        final NotificationListener expected = mock(NotificationListener.class);
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        NotificationListener actual = service.registerListener(expected)
                                             .getListener();

        // Assert
        assertSame(expected, actual);
    }

    @Test
    void unregisterListener_ContainsListenerRegistration() {
        // Arrange
        final NotificationListener listener = mock(NotificationListener.class);
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        NotificationListenerRegistration registration = service.registerListener(listener);

        // Assert
        assertTrue(service.listeners.contains(registration));
    }

    @Test
    void unregisterListener_ListenerIsUnregistered() {
        // Arrange
        final NotificationListener listener = mock(NotificationListener.class);
        final PusherNotificationService service = defaultPusherNotificationService();
        final NotificationListenerRegistration registration = service.registerListener(listener);

        // Act
        service.unregisterListener(listener);

        // Assert
        assertFalse(service.listeners.contains(registration));
    }

    @Test
    void registerListenerWithMatcher_ReturnRegistrationWithMatcher() {
        // Arrange
        final EventMatcher expected = event -> true;
        final NotificationListener listener = mock(NotificationListener.class);
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        EventMatcher actual = service.registerListenerWithMatcher(listener, expected)
                                     .getEventMatcher();

        // Assert
        assertSame(expected, actual);
    }

    @ParameterizedTest
    @EnumSource
    void registerListenerIncludingTypes_IncludesEvent_ReturnRegistrationWithCorrectMatcher(EventType includedType) {
        // Arrange
        final NotificationListener listener = mock(NotificationListener.class);
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        EventMatcher matcher = service.registerListenerIncludingTypes(listener, includedType)
                                      .getEventMatcher();

        // Assert
        for (EventType type : EventType.values()) {
            NotificationEvent event = createNotificationEvent(type);
            boolean expected = includedType == type;
            boolean actual = matcher.matches(event);
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @EnumSource
    void registerListenerExcludingTypes_ExcludesEvent_ReturnRegistrationWithCorrectMatcher(EventType excludedType) {
        // Arrange
        final NotificationListener listener = mock(NotificationListener.class);
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        EventMatcher matcher = service.registerListenerExcludingTypes(listener, excludedType)
                                      .getEventMatcher();

        // Assert
        for (EventType type : EventType.values()) {
            NotificationEvent event = createNotificationEvent(type);
            boolean expected = excludedType != type;
            boolean actual = matcher.matches(event);
            assertEquals(expected, actual);
        }
    }

    @Test
    void subscribeToProject_BeforeStartingService_IsNotSubscribedToProject() {
        // Arrange - Data
        final String project = "xyz";
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        service.subscribeToProject(project);

        // Assert
        assertFalse(service.isSubscribedToProject(project));
    }

    @Test
    void subscribeToPlayer_BeforeStartingService_IsNotSubscribedToPlayer() {
        // Arrange - Data
        final String project = "xyz";
        final String player = "xyz";
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        service.subscribeToPlayer(project, player);

        // Assert
        assertFalse(service.isSubscribedToPlayer(project, player));
    }

    @Test
    void subscribeToAsset_BeforeStartingService_IsNotSubscribedToAsset() {
        // Arrange - Data
        final String asset = "xyz";
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        service.subscribeToAsset(asset);

        // Assert
        assertFalse(service.isSubscribedToAsset(asset));
    }

    @Test
    void subscribeToWallet_BeforeStartingService_IsNotSubscribedToWallet() {
        // Arrange - Data
        final String wallet = "xyz";
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        service.subscribeToWallet(wallet);

        // Assert
        assertFalse(service.isSubscribedToWallet(wallet));
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void subscribeToProject_AfterStartingService_IsSubscribedToChannel() {
        // Arrange - Data
        final String project = "xyz";
        final String channelName = new ProjectChannel(DEFAULT_PLATFORM, project).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();

            // Act
            service.subscribeToProject(project);

            await().atLeast(500, TimeUnit.MILLISECONDS);

            // Assert
            assertTrue(service.isSubscribedToProject(project));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void subscribeToPlayer_AfterStartingService_IsSubscribedToChannel() {
        // Arrange - Data
        final String project = "xyz";
        final String player = "xyz";
        final String channelName = new PlayerChannel(DEFAULT_PLATFORM, project, player).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();

            // Act
            service.subscribeToPlayer(project, player);

            await().atLeast(500, TimeUnit.MILLISECONDS);

            // Assert
            assertTrue(service.isSubscribedToPlayer(project, player));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void subscribeToAsset_AfterStartingService_IsSubscribedToChannel() {
        // Arrange - Data
        final String asset = "xyz";
        final String channelName = new AssetChannel(DEFAULT_PLATFORM, asset).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();

            // Act
            service.subscribeToAsset(asset);

            await().atLeast(500, TimeUnit.MILLISECONDS);

            // Assert
            assertTrue(service.isSubscribedToAsset(asset));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void subscribeToWallet_AfterStartingService_IsSubscribedToChannel() {
        // Arrange - Data
        final String wallet = "xyz";
        final String channelName = new WalletChannel(DEFAULT_PLATFORM, wallet).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();

            // Act
            service.subscribeToWallet(wallet);

            await().atLeast(500, TimeUnit.MILLISECONDS);

            // Assert
            assertTrue(service.isSubscribedToWallet(wallet));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void unsubscribeToProject_AfterStartingService_IsNoLongerSubscribedToChannel() {
        // Arrange - Data
        final String project = "xyz";
        final String channelName = new ProjectChannel(DEFAULT_PLATFORM, project).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
            stubPusherUnsubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();
            service.subscribeToProject(project);
            await().atLeast(500, TimeUnit.MILLISECONDS);

            assumeTrue(service.isSubscribedToProject(project));

            // Act
            service.unsubscribeToProject(project);

            // Assert
            assertFalse(service.isSubscribedToProject(project));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).unsubscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void unsubscribeToPlayer_AfterStartingService_IsNoLongerSubscribedToChannel() {
        // Arrange - Data
        final String project = "xyz";
        final String player = "xyz";
        final String channelName = new PlayerChannel(DEFAULT_PLATFORM, project, player).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
            stubPusherUnsubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();
            service.subscribeToPlayer(project, player);
            await().atLeast(500, TimeUnit.MILLISECONDS);

            assumeTrue(service.isSubscribedToPlayer(project, player));

            // Act
            service.unsubscribeToPlayer(project, player);

            // Assert
            assertFalse(service.isSubscribedToPlayer(project, player));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).unsubscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void unsubscribeToAsset_AfterStartingService_IsNoLongerSubscribedToChannel() {
        // Arrange - Data
        final String asset = "xyz";
        final String channelName = new AssetChannel(DEFAULT_PLATFORM, asset).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
            stubPusherUnsubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();
            service.subscribeToAsset(asset);
            await().atLeast(500, TimeUnit.MILLISECONDS);

            assumeTrue(service.isSubscribedToAsset(asset));

            // Act
            service.unsubscribeToAsset(asset);

            // Assert
            assertFalse(service.isSubscribedToAsset(asset));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).unsubscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void unsubscribeToWallet_AfterStartingService_IsNoLongerSubscribedToChannel() {
        // Arrange - Data
        final String wallet = "xyz";
        final String channelName = new WalletChannel(DEFAULT_PLATFORM, wallet).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
            stubPusherUnsubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();
            service.subscribeToWallet(wallet);
            await().atLeast(500, TimeUnit.MILLISECONDS);

            assumeTrue(service.isSubscribedToWallet(wallet));

            // Act
            service.unsubscribeToWallet(wallet);

            // Assert
            assertFalse(service.isSubscribedToWallet(wallet));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).unsubscribe(eq(channelName));
            }
        }
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    @SneakyThrows
    void start_PreviouslyActiveService_ResubscribesToChannels() {
        // Arrange - Data
        final String project = "xyz";
        final String channelName = new ProjectChannel(DEFAULT_PLATFORM, project).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final ConnectionStateChange stubConnectedState = mock(ConnectionStateChange.class);
        final Channel stubChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> ConnectionState.CONNECTING).when(stubConnectedState).getPreviousState();
        doAnswer(invocation -> ConnectionState.CONNECTED).when(stubConnectedState).getCurrentState();
        doAnswer(invocation -> channelName).when(stubChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client stubbing
            stubPusherConnect(mock, stubConnectedState);
            stubPusherSubscribe(mock, stubChannel, channelName);
            stubPusherUnsubscribe(mock, stubChannel, channelName);
        })) {
            // Arrange - Data (continued)
            service.start().get();                       // Service is started for the first and subscribes to the
            service.subscribeToProject(project);         // channel
            await().atLeast(500, TimeUnit.MILLISECONDS); //
            service.shutdown(); // Shutdown the service to be restarted on 'Act' (do not wait for future)

            assumeTrue(service.isSubscribedToProject(project));

            // Act
            Future<Void> future = service.start();

            await().atLeast(500, TimeUnit.MILLISECONDS);

            // Assert
            assertDoesNotThrow((Executable) future::get);
            assertTrue(service.isSubscribedToProject(project));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    private static PusherNotificationService defaultPusherNotificationService() {
        return PusherNotificationService.builder().platform(DEFAULT_PLATFORM).build();
    }

    private static NotificationEvent createNotificationEvent(EventType type) {
        return new NotificationEvent(type, "", "");
    }

    private static void stubPusherConnect(Pusher mockPusher, ConnectionStateChange stateChange) {
        doAnswer(invocation -> {
            ConnectionEventListener listener = invocation.getArgument(0, ConnectionEventListener.class);
            listener.onConnectionStateChange(stateChange);
            return null;
        }).when(mockPusher)
          .connect(any(ConnectionEventListener.class), any(ConnectionState.class));
    }

    private static void stubPusherSubscribe(Pusher mockPusher, Channel pusherChannel, String channelName) {
        doAnswer(invocation -> {
            ChannelEventListener listener = invocation.getArgument(1, ChannelEventListener.class);
            if (listener != null)
                listener.onSubscriptionSucceeded(channelName);

            return pusherChannel;
        }).when(mockPusher)
          .subscribe(eq(channelName), any(ChannelEventListener.class));
        doAnswer(invocation -> pusherChannel).when(mockPusher).subscribe(eq(channelName));
    }

    private static void stubPusherUnsubscribe(Pusher mockPusher, Channel pusherChannel, String channelName) {
        doAnswer(invocation -> pusherChannel).when(mockPusher).unsubscribe(eq(channelName));
    }

}