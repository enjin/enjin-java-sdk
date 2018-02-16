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
        notificationConfig = ImmutableNotification
                .builder()
                .setActivityTimeout(5000L)
                .build();
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "XXXX");
                        put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "channel_name");
                    }
                }).setRole("game_server").build();

        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
    }
    @Test
    public void testContructor() throws Exception {
        pusherNotificationService = new PusherNotificationServiceImpl(notificationConfig);
        assertThat(pusherNotificationService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testInitializeNotificationService_ObjectPassedInIsNull() throws Exception {
        getPlatformAuthDetailsResponseVO = null;

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }

    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ClientInfoMapIsEmpty() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() { }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings({ "serial", "unchecked", "rawtypes" })
    @Test
    public void testInitializeNotificationService_ClientInfoMapIsNull() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap((Map) null)
                .setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ChannelsMapIsEmpty() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "");
                        put("cluster", "us");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {}).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings({ "serial", "unchecked", "rawtypes" })
    @Test
    public void testInitializeNotificationService_ChannelsMapIsNull() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "");
                        put("cluster", "us");
                    }
                }).setChannelsMap((Map)null).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }


    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppKeyIsEmpty() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "");
                        put("cluster", "us");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppKeyIsNull() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", null);
                        put("cluster", "us");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ClusterlIsEmpty() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "XXXX");
                        put("cluster", "");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_ClusterlIsNull() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "XXXX");
                        put("cluster", null);
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "server");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppChannelIsEmpty() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "XXXX");
                        put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", "");
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isFalse();
    }
    @SuppressWarnings("serial")
    @Test
    public void testInitializeNotificationService_AppChannelIsNull() throws Exception {
        getPlatformAuthDetailsResponseVO = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
                .setClientInfoMap(new HashMap<String, Object>() {
                    {
                        put("app_key", "XXXX");
                        put("cluster", "us2");
                    }
                }).setChannelsMap(new HashMap<String, Object>() {
                    {
                        put("server", null);
                    }
                }).setRole("game_server").build();

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
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

        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
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
        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        List<NotificationListenerRegistration> notificationListenersList = null;
        pusherNotificationService.setNotificationListeners(notificationListenersList );
    }
    @Test
    public void testSetNotificationListeners_NotificationListenerListIsEmpty() {
        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        List<NotificationListenerRegistration> notificationListenersList = new LinkedList<>();
        pusherNotificationService.setNotificationListeners(notificationListenersList );
    }
    @Test
    public void testSetNotificationListeners_NotificationListenerListHas1Element() {
        boolean result = pusherNotificationService.initializeNotificationService(getPlatformAuthDetailsResponseVO);
        assertThat(result).isTrue();

        List<NotificationListenerRegistration> notificationListenersList = new LinkedList<>();
        notificationListenersList.add(new NotificationListenerRegistration(mockNotificationListener, NotificationListenerRegistration.ALLOW_ALL_MATCHER));
        pusherNotificationService.setNotificationListeners(notificationListenersList );
    }
}
