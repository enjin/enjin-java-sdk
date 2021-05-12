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
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.MockedConstruction;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class PusherNotificationServiceTest {

    private static final Platform DEFAULT_PLATFORM = PlatformUtils.FAKE_PLATFORM;

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
            boolean actual   = matcher.matches(event);
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
            boolean actual   = matcher.matches(event);
            assertEquals(expected, actual);
        }
    }

    @Test
    void subscribeToProject_IsSubscribeToChannel() {
        // Arrange - Data
        final int project = 1234;
        final String channelName = new ProjectChannel(DEFAULT_PLATFORM, project).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();

            // Act
            service.subscribeToProject(project);

            // Assert
            assertTrue(service.isSubscribedToProject(project));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    void subscribeToPlayer_IsSubscribeToChannel() {
        // Arrange - Data
        final int project = 1234;
        final String player = "xyz";
        final String channelName = new PlayerChannel(DEFAULT_PLATFORM, project, player).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();

            // Act
            service.subscribeToPlayer(project, player);

            // Assert
            assertTrue(service.isSubscribedToPlayer(project, player));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    void subscribeToAsset_IsSubscribeToChannel() {
        // Arrange - Data
        final String asset = "xyz";
        final String channelName = new AssetChannel(DEFAULT_PLATFORM, asset).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();

            // Act
            service.subscribeToAsset(asset);

            // Assert
            assertTrue(service.isSubscribedToAsset(asset));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    void subscribeToWallet_IsSubscribeToChannel() {
        // Arrange - Data
        final String wallet = "xyz";
        final String channelName = new WalletChannel(DEFAULT_PLATFORM, wallet).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();

            // Act
            service.subscribeToWallet(wallet);

            // Assert
            assertTrue(service.isSubscribedToWallet(wallet));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    @Test
    void unsubscribeToProject_IsNotSubscribeToChannel() {
        // Arrange - Data
        final int project = 1234;
        final String channelName = new ProjectChannel(DEFAULT_PLATFORM, project).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
            doAnswer(invocation -> mockChannel).when(mock).unsubscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();
            service.subscribeToProject(project);

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
    void unsubscribeToPlayer_IsNotSubscribeToChannel() {
        // Arrange - Data
        final int project = 1234;
        final String player = "xyz";
        final String channelName = new PlayerChannel(DEFAULT_PLATFORM, project, player).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
            doAnswer(invocation -> mockChannel).when(mock).unsubscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();
            service.subscribeToPlayer(project, player);

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
    void unsubscribeToAsset_IsNotSubscribeToChannel() {
        // Arrange - Data
        final String asset = "xyz";
        final String channelName = new AssetChannel(DEFAULT_PLATFORM, asset).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
            doAnswer(invocation -> mockChannel).when(mock).unsubscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();
            service.subscribeToAsset(asset);

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
    void unsubscribeToWallet_IsNotSubscribeToChannel() {
        // Arrange - Data
        final String wallet = "xyz";
        final String channelName = new WalletChannel(DEFAULT_PLATFORM, wallet).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
            doAnswer(invocation -> mockChannel).when(mock).unsubscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();
            service.subscribeToWallet(wallet);

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
    void start_PreviouslyActiveServiceResubscribesToChannels() {
        // Arrange - Data
        final int project = 1234;
        final String channelName = new ProjectChannel(DEFAULT_PLATFORM, project).channel();
        final PusherNotificationService service = defaultPusherNotificationService();
        final Channel mockChannel = mock(Channel.class);

        // Arrange - Stubbing
        doAnswer(invocation -> channelName).when(mockChannel).getName();

        try (MockedConstruction<Pusher> mocked = mockConstruction(Pusher.class, (mock, context) -> {
            // Pusher client Stubbing
            doAnswer(invocation -> mockChannel).when(mock).subscribe(eq(channelName));
            doAnswer(invocation -> mockChannel).when(mock).unsubscribe(eq(channelName));
        })) {
            // Arrange - Data (continued)
            service.start();                     // Service is started for the first and subscribes to the channel
            service.subscribeToProject(project); //
            service.shutdown(); // Shutdown the service to be restarted on 'Act'

            assumeTrue(service.isSubscribedToProject(project));

            // Act
            service.start();

            // Assert
            assertTrue(service.isSubscribedToProject(project));

            // Verify
            for (Pusher mock : mocked.constructed()) {
                verify(mock, times(1)).subscribe(eq(channelName));
            }
        }
    }

    private static PusherNotificationService defaultPusherNotificationService() {
        return new PusherNotificationService(DEFAULT_PLATFORM);
    }

    private static NotificationEvent createNotificationEvent(EventType type) {
        return new NotificationEvent(type, "", "");
    }

}