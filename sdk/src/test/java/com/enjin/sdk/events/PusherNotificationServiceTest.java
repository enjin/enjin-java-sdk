package com.enjin.sdk.events;

import com.enjin.sdk.PlatformUtils;
import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.NotificationEvent;
import static org.junit.Assume.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PusherNotificationServiceTest {

    @Test
    void registerListener_ReturnRegistrationWithListener() {
        // Arrange
        final NotificationListener expected = new Listener();
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
        final NotificationListener listener = new Listener();
        final PusherNotificationService service = defaultPusherNotificationService();

        // Act
        NotificationListenerRegistration registration = service.registerListener(listener);

        // Assert
        assertTrue(service.listeners.contains(registration));
    }

    @Test
    void unregisterListener_ListenerIsUnregistered() {
        // Arrange
        final NotificationListener listener = new Listener();
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
        final NotificationListener listener = new Listener();
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
        final NotificationListener listener = new Listener();
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
        final NotificationListener listener = new Listener();
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
        // Arrange
        final int PROJECT = 1234;
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();

        // Act
        service.subscribeToProject(PROJECT);

        // Assert
        assertTrue(service.isSubscribedToProject(PROJECT));
    }

    @Test
    void subscribeToPlayer_IsSubscribeToChannel() {
        // Arrange
        final int PROJECT = 1234;
        final String PLAYER = "player 1";
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();

        // Act
        service.subscribeToPlayer(PROJECT, PLAYER);

        // Assert
        assertTrue(service.isSubscribedToPlayer(PROJECT, PLAYER));
    }

    @Test
    void subscribeToAsset_IsSubscribeToChannel() {
        // Arrange
        final String ASSET = "0000000000000000";
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();

        // Act
        service.subscribeToAsset(ASSET);

        // Assert
        assertTrue(service.isSubscribedToAsset(ASSET));
    }

    @Test
    void subscribeToWallet_IsSubscribeToChannel() {
        // Arrange
        final String WALLET = "0x0";
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();

        // Act
        service.subscribeToWallet(WALLET);

        // Assert
        assertTrue(service.isSubscribedToWallet(WALLET));
    }

    @Test
    void unsubscribeToProject_IsNotSubscribeToChannel() {
        // Arrange
        final int PROJECT = 1234;
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();
        service.subscribeToProject(PROJECT);

        // Act
        service.unsubscribeToProject(PROJECT);

        // Assert
        assertFalse(service.isSubscribedToProject(PROJECT));
    }

    @Test
    void unsubscribeToPlayer_IsNotSubscribeToChannel() {
        // Arrange
        final int PROJECT = 1234;
        final String PLAYER = "player 1";
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();
        service.subscribeToPlayer(PROJECT, PLAYER);

        // Act
        service.unsubscribeToPlayer(PROJECT, PLAYER);

        // Assert
        assertFalse(service.isSubscribedToPlayer(PROJECT, PLAYER));
    }

    @Test
    void unsubscribeToAsset_IsNotSubscribeToChannel() {
        // Arrange
        final String ASSET = "0000000000000000";
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();
        service.subscribeToAsset(ASSET);

        // Act
        service.unsubscribeToAsset(ASSET);

        // Assert
        assertFalse(service.isSubscribedToAsset(ASSET));
    }

    @Test
    void unsubscribeToWallet_IsNotSubscribeToChannel() {
        // Arrange
        final String WALLET = "0x0";
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();
        service.subscribeToWallet(WALLET);

        // Act
        service.unsubscribeToWallet(WALLET);

        // Assert
        assertFalse(service.isSubscribedToWallet(WALLET));
    }

    @Test
    void start_PreviouslyActiveServiceResubscribesToChannels() {
        // Arrange
        final int PROJECT = 1234;
        final PusherNotificationService service = defaultPusherNotificationService();
        service.start();                     // Service is started for the first time and subscribes to the channel
        service.subscribeToProject(PROJECT); //
        service.shutdown(); // Shutdown the service to be restarted on 'Act'

        assumeTrue(service.isSubscribedToProject(PROJECT));

        // Act
        service.start();

        // Assert
        assertTrue(service.isSubscribedToProject(PROJECT));
    }

    private static PusherNotificationService defaultPusherNotificationService() {
        return new PusherNotificationService(PlatformUtils.FAKE_PLATFORM);
    }

    private static NotificationEvent createNotificationEvent(EventType type) {
        return new NotificationEvent(type, "", "");
    }

    private static class Listener implements NotificationListener {

        @Override
        public void notificationReceived(NotificationEvent event) {}

    }

}