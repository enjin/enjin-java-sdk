package io.enjincoin.sdk.client.service.notifications;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import io.enjincoin.sdk.client.config.ImmutableNotification;
import io.enjincoin.sdk.client.config.Notification;
import io.enjincoin.sdk.client.service.notifications.impl.PusherNotificationServiceImpl;
import io.enjincoin.sdk.client.vo.platform.GetPlatformAuthDetailsResponseVO;
import io.enjincoin.sdk.client.vo.platform.ImmutableGetPlatformAuthDetailsResponseVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.net.ssl.*")
@PrepareForTest({PusherNotificationServiceImpl.class})
public class PusherNotificationServiceTest {

    private ThirdPartyNotificationService pusherNotificationService;

    @Mock
    private NotificationListener mockNotificationListener;
    private Notification notificationConfig;
    private GetPlatformAuthDetailsResponseVO getPlatformAuthDetailsResponseVO;

    @SuppressWarnings("serial")
    @Before
    public void setUp() {
        this.notificationConfig = ImmutableNotification
                .builder()
                .setActivityTimeout(5000L)
                .build();
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "XXXX");
                        this.put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "channel_name");
                    }
                }).setRole("game_server").build();

        this.pusherNotificationService = new PusherNotificationServiceImpl(this.notificationConfig);
    }

    @Test
    public void testContructor() throws Exception {
        this.pusherNotificationService = new PusherNotificationServiceImpl(this.notificationConfig);
        assertThat(this.pusherNotificationService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testInitializeNotificationService_ObjectPassedInIsNull() throws Exception {
        this.getPlatformAuthDetailsResponseVO = null;

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ClientInfoMapIsEmpty() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings({"serial", "unchecked", "rawtypes"})
    @Test
    public void testInitializeNotificationService_ClientInfoMapIsNull() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap((Map) null)
                .setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ChannelsMapIsEmpty() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "");
                        this.put("cluster", "us");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings({"serial", "unchecked", "rawtypes"})
    @Test
    public void testInitializeNotificationService_ChannelsMapIsNull() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "");
                        this.put("cluster", "us");
                    }
                }).setChannelsMap((Map) null).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }


    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppKeyIsEmpty() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "");
                        this.put("cluster", "us");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppKeyIsNull() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", null);
                        this.put("cluster", "us");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ClusterlIsEmpty() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "XXXX");
                        this.put("cluster", "");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ClusterlIsNull() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "XXXX");
                        this.put("cluster", null);
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppChannelIsEmpty() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "XXXX");
                        this.put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", "");
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppChannelIsNull() throws Exception {
        this.getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        this.put("app_key", "XXXX");
                        this.put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        this.put("server", null);
                    }
                }).setRole("game_server").build();

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @Test
    public void testInitializeNotificationService_Success() throws Exception {
        PusherOptions mockPusherOptions = PowerMockito.mock(PusherOptions.class);
        Pusher mockPusher = PowerMockito.mock(Pusher.class);
        Channel mockChannel = Mockito.mock(Channel.class);

        PowerMockito.whenNew(PusherOptions.class).withNoArguments().thenReturn(mockPusherOptions);
        Mockito.when(mockPusherOptions.setCluster(Mockito.anyString())).thenReturn(mockPusherOptions);
        Mockito.when(mockPusherOptions.setActivityTimeout(Mockito.anyLong())).thenReturn(mockPusherOptions);
        PowerMockito.whenNew(Pusher.class).withArguments(Mockito.anyString(), Mockito.isA(PusherOptions.class)).thenReturn(mockPusher);
        Mockito.doNothing().when(mockPusher).connect(Mockito.isA(ConnectionEventListener.class), Mockito.isA(ConnectionState.class));
        Mockito.when(mockPusher.subscribe(Mockito.anyString())).thenReturn(mockChannel);
        Mockito.doNothing().when(mockChannel).bind(Mockito.anyString(), Mockito.isA(SubscriptionEventListener.class));

        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        PowerMockito.verifyNew(PusherOptions.class).withNoArguments();
        Mockito.verify(mockPusherOptions, Mockito.times(1)).setCluster(Mockito.anyString());
        Mockito.verify(mockPusherOptions, Mockito.times(1)).setActivityTimeout(Mockito.anyLong());
        PowerMockito.verifyNew(Pusher.class).withArguments(Mockito.anyString(), Mockito.isA(PusherOptions.class));
        Mockito.verify(mockPusher).connect(Mockito.isA(ConnectionEventListener.class), Mockito.isA(ConnectionState.class));
        Mockito.verify(mockPusher, Mockito.times(1)).subscribe(Mockito.anyString());
        Mockito.verify(mockChannel, Mockito.atLeastOnce()).bind(Mockito.anyString(), Mockito.isA(SubscriptionEventListener.class));
    }

    @Test
    public void testSetNotificationListeners_NotificationListenerListIsNull() {
        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        List<NotificationListenerRegistration> notificationListenersList = null;
        this.pusherNotificationService.setNotificationListeners(notificationListenersList);
    }

    @Test
    public void testSetNotificationListeners_NotificationListenerListIsEmpty() {
        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        List<NotificationListenerRegistration> notificationListenersList = new LinkedList<>();
        this.pusherNotificationService.setNotificationListeners(notificationListenersList);
    }

    @Test
    public void testSetNotificationListeners_NotificationListenerListHas1Element() {
        boolean result = this.pusherNotificationService.initializeNotificationService(this.getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        List<NotificationListenerRegistration> notificationListenersList = new LinkedList<>();
        notificationListenersList.add(new NotificationListenerRegistration(this.mockNotificationListener, NotificationListenerRegistration.ALLOW_ALL_MATCHER));
        this.pusherNotificationService.setNotificationListeners(notificationListenersList);
    }
}
