package com.enjin.coin.sdk.service.notifications;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.BaseTestHelper;
import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableNotification;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.service.notifications.impl.PusherNotificationServiceImpl;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.net.ssl.*")
@PrepareForTest({PusherNotificationServiceImpl.class})
public class PusherNotificationServiceTest {

    private ThirdPartyNotificationService pusherNotificationService;
    private Config enjinConfig;

    @Mock
    private NotificationListener mockNotificationListener;
    private Notification notificationConfig;
    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
        notificationConfig = enjinConfig.getNotification();
    }
    @Test
    public void testContructor() throws Exception {
        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        assertThat(pusherNotificationService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testInitializeNotificationService_AppIdIsEmpty() throws Exception {
        notificationConfig = ImmutableNotification.copyOf(notificationConfig).withAppId("");

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        boolean result = pusherNotificationService.initializeNotificationService();
        assertThat(result).isFalse();
    }

    @Test
    public void testInitializeNotificationService_AppKeyIsEmpty() throws Exception {
        notificationConfig = ImmutableNotification.copyOf(notificationConfig).withAppKey("");

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        boolean result = pusherNotificationService.initializeNotificationService();
        assertThat(result).isFalse();
    }

    @Test
    public void testInitializeNotificationService_AppSecretIsEmpty() throws Exception {
        notificationConfig = ImmutableNotification.copyOf(notificationConfig).withAppSecret("");

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        boolean result = pusherNotificationService.initializeNotificationService();
        assertThat(result).isFalse();
    }
    @Test
    public void testInitializeNotificationService_ClusterIsEmpty() throws Exception {
        notificationConfig = ImmutableNotification.copyOf(notificationConfig).withCluster("");

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        boolean result = pusherNotificationService.initializeNotificationService();
        assertThat(result).isFalse();
    }

    @Test
    public void testInitializeNotificationService_AppChannelIsEmpty() throws Exception {
        notificationConfig = ImmutableNotification.copyOf(notificationConfig).withAppChannel("");

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        boolean result = pusherNotificationService.initializeNotificationService();
        assertThat(result).isFalse();
    }


    @Test
    public void testInitializeNotificationService_Success() throws Exception {
        PusherOptions mockPusherOptions = PowerMockito.mock(PusherOptions.class);
        Pusher mockPusher               = PowerMockito.mock(Pusher.class);
        Channel mockChannel             = Mockito.mock(Channel.class);

        PowerMockito.whenNew(PusherOptions.class).withNoArguments().thenReturn(mockPusherOptions);
        Mockito.when(mockPusherOptions.setCluster(Mockito.anyString())).thenReturn(mockPusherOptions);
        Mockito.when(mockPusherOptions.setActivityTimeout(Mockito.anyLong())).thenReturn(mockPusherOptions);
        PowerMockito.whenNew(Pusher.class).withArguments(Mockito.anyString(), Mockito.isA(PusherOptions.class)).thenReturn(mockPusher);
        Mockito.doNothing().when(mockPusher).connect(Mockito.isA(ConnectionEventListener.class), Mockito.isA(ConnectionState.class));
        Mockito.when(mockPusher.subscribe(Mockito.anyString())).thenReturn(mockChannel);
        Mockito.doNothing().when(mockChannel).bind(Mockito.anyString(), Mockito.isA(SubscriptionEventListener.class));

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        boolean result = pusherNotificationService.initializeNotificationService();
        assertThat(result).isTrue();

        PowerMockito.verifyNew(PusherOptions.class).withNoArguments();
        Mockito.verify(mockPusherOptions, Mockito.times(1)).setCluster(Mockito.anyString());
        Mockito.verify(mockPusherOptions, Mockito.times(1)).setActivityTimeout(Mockito.anyLong());
        PowerMockito.verifyNew(Pusher.class).withArguments(Mockito.anyString(), Mockito.isA(PusherOptions.class));
        Mockito.verify(mockPusher).connect(Mockito.isA(ConnectionEventListener.class), Mockito.isA(ConnectionState.class));
        Mockito.verify(mockPusher, Mockito.times(1)).subscribe(Mockito.anyString());
        Mockito.verify(mockChannel, Mockito.atLeastOnce()).bind(Mockito.anyString(), Mockito.isA(SubscriptionEventListener.class));
    }
}
