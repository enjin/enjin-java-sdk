package com.enjin.coin.sdk.service.notifications;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;
import com.enjin.coin.sdk.service.notifications.impl.NotificationsAsyncServiceImpl;
import com.enjin.coin.sdk.service.notifications.impl.PusherNotificationServiceImpl;
import com.enjin.coin.sdk.service.platform.impl.PlatformServiceImpl;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthDetailsResponseVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthRequestVO;
import com.enjin.coin.sdk.vo.platform.GetPlatformAuthResponseVO;
import com.enjin.coin.sdk.vo.platform.ImmutableGetPlatformAuthDetailsResponseVO;
import com.enjin.coin.sdk.vo.platform.ImmutableGetPlatformAuthResponseVO;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.net.ssl.*")
@PrepareForTest({ NotificationsAsyncServiceImpl.class })
public class NotificationsAsyncServiceTest {

    private NotificationsAsyncService notificationsAsyncService;
    private Config enjinConfig;

    @Mock
    private NotificationListener mockNotificationListener;
    public GetPlatformAuthResponseVO getPlatformAuthResponseVO;

    @SuppressWarnings("serial")
    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();

        GetPlatformAuthDetailsResponseVO platformAuthNotificationDetails = ImmutableGetPlatformAuthDetailsResponseVO.builder().setMethod("pusher")
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
        getPlatformAuthResponseVO = ImmutableGetPlatformAuthResponseVO.builder().setPlatformAuthNotificationDetails(platformAuthNotificationDetails).build();

        notificationsAsyncService = new NotificationsAsyncServiceImpl(enjinConfig);
    }

    @Test
    public void testContructor() throws Exception {
        notificationsAsyncService = new NotificationsAsyncServiceImpl(enjinConfig);
        assertThat(notificationsAsyncService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testInitNotificationsService_AuthIsNull() throws Exception {
        String auth = null;

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isFalse();
    }
    @Test
    public void testInitNotificationsService_AuthIsEmpty() throws Exception {
        String auth = "";

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isFalse();
    }
    @Test
    public void testInitNotificationsService_GetPlatformAuthResponseVOIsNull() throws Exception {
        GetPlatformAuthResponseVO tempGetPlatformAuthResponseVO = null;
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(tempGetPlatformAuthResponseVO);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isFalse();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
    }
    @Test
    public void testInitNotificationsService_GetPlatformAuthDetailsResponseVOIsNotPresent() throws Exception {
        GetPlatformAuthResponseVO tempGetPlatformAuthResponseVO = ImmutableGetPlatformAuthResponseVO.builder()
                .setPlatformAuthNotificationDetails((GetPlatformAuthDetailsResponseVO)null)
                .build();
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(tempGetPlatformAuthResponseVO);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isFalse();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
    }
    @Test
    public void testInitNotificationsService_GetPlatformAuthDetailsResponseVOOptioanlIsNotPresent() throws Exception {
        Optional<GetPlatformAuthDetailsResponseVO> getPlatformAuthDetailsResponseVOOptional = Optional.empty();
        GetPlatformAuthResponseVO tempGetPlatformAuthResponseVO = ImmutableGetPlatformAuthResponseVO.builder()
                .setPlatformAuthNotificationDetails(getPlatformAuthDetailsResponseVOOptional)
                .build();
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(tempGetPlatformAuthResponseVO);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isFalse();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
    }

    @Test
    public void testInitNotificationsService_FailedToInitialize() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(false);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isFalse();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }

    @Test
    public void testInitNotificationsService_Success() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @Test
    public void testReInitNotificationsService_Success() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        boolean reInitResult = notificationsAsyncService.reInitNotificationsServiceAsync().get();
        assertThat(reInitResult).isTrue();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.atLeastOnce()).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @Test
    public void testInitNotificationsService_SuccessInitializedAlready() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(2)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testConfigureListener() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = notificationsAsyncService.configureListenerAsync(mockNotificationListener).get();
        assertThat(registrationListenerConfiguration).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }
    @Test
    public void testAddNotificationListener_ListenerIsNull() throws Exception {
        String auth = "xxxx";

        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerAsyncRegistration = notificationsAsyncService.addNotificationListenerAsync(null).get();
        assertThat(addNotificationListenerAsyncRegistration).isNull();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListener() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerAsyncRegistration = notificationsAsyncService.addNotificationListenerAsync(mockNotificationListener).get();
        assertThat(addNotificationListenerAsyncRegistration).isNotNull();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListener_ListenerAlreadyExists() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerAsyncRegistration1 = notificationsAsyncService.addNotificationListenerAsync(mockNotificationListener).get();
        assertThat(addNotificationListenerAsyncRegistration1).isNotNull();

        NotificationListenerRegistration addNotificationListenerAsyncRegistration2 = notificationsAsyncService.addNotificationListenerAsync(mockNotificationListener).get();
        assertThat(addNotificationListenerAsyncRegistration2).isNull();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListenerWithEventMatcher() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        EventMatcher eventMatcher = NotificationListenerRegistration.ALLOW_ALL_MATCHER;
        NotificationListenerRegistration addNotificationListenerAsyncRegistration = notificationsAsyncService.addNotificationListenerAsync(mockNotificationListener, eventMatcher).get();
        assertThat(addNotificationListenerAsyncRegistration).isNotNull();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddAllowedTypesNotificationListener() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        NotificationListenerRegistration addAllowedTypesNotificationListenerAsync = notificationsAsyncService.addAllowedTypesNotificationListenerAsync(mockNotificationListener, notificationType).get();
        assertThat(addAllowedTypesNotificationListenerAsync).isNotNull();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddIgnoredTypesNotificationListener() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        NotificationListenerRegistration addIgnoredTypesNotificationListener = notificationsAsyncService.addIgnoredTypesNotificationListenerAsync(mockNotificationListener, notificationType).get();
        assertThat(addIgnoredTypesNotificationListener).isNotNull();

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @Test
    public void testRemoveNotificationListener_ListenerIsNull() throws Exception {
        String auth = "xxxx";

        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        notificationsAsyncService.removeNotificationListenerAsync(null);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }

    @Test
    public void testRemoveNotificationListener_ListenerDoesntExist() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        notificationsAsyncService.removeNotificationListenerAsync(mockNotificationListener);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testRemoveNotificationListener_AlreadyExists() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerAsyncRegistration = notificationsAsyncService.addNotificationListenerAsync(mockNotificationListener).get();
        assertThat(addNotificationListenerAsyncRegistration).isNotNull();

        notificationsAsyncService.removeNotificationListenerAsync(mockNotificationListener);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService, Mockito.atLeastOnce()).setNotificationListeners(Mockito.isA(List.class));
    }

    @Test
    public void testAddNotificationListenerRegistration_NotificationListenerRegistrationIsNull() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = null;
        notificationsAsyncService.addNotificationListenerRegistrationAsync(notificationListenerRegistration);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListenerRegistration() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener);
        notificationsAsyncService.addNotificationListenerRegistrationAsync(notificationListenerRegistration);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.atLeastOnce()).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @Test
    public void testRemoveNotificationListenerRegistration_NotificationListenerRegistrationIsNull() throws Exception {
        String auth = "xxxx";

        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = null;
        notificationsAsyncService.removeNotificationListenerRegistrationAsync(notificationListenerRegistration);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testRemoveNotificationListenerRegistration() throws Exception {
        String auth = "xxxx";
        PlatformServiceImpl mockPlatformService = PowerMockito.mock(PlatformServiceImpl.class);
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PlatformServiceImpl.class).withParameterTypes(Config.class).withArguments(Mockito.isA(Config.class)).thenReturn(mockPlatformService);
        Mockito.when(mockPlatformService.getAuth(Mockito.isA(GetPlatformAuthRequestVO.class))).thenReturn(getPlatformAuthResponseVO);
        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class))
                .thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class))).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        boolean result = notificationsAsyncService.initNotificationsServiceAsync(auth).get();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener);
        notificationsAsyncService.removeNotificationListenerRegistrationAsync(notificationListenerRegistration);

        PowerMockito.verifyNew(PlatformServiceImpl.class).withArguments(Mockito.isA(Config.class));
        Mockito.verify(mockPlatformService, Mockito.times(1)).getAuth(Mockito.isA(GetPlatformAuthRequestVO.class));
        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService, Mockito.atLeastOnce()).initializeNotificationService(Mockito.isA(GetPlatformAuthDetailsResponseVO.class));
        Mockito.verify(mockPusherNotificationService, Mockito.atLeastOnce()).setNotificationListeners(Mockito.isA(List.class));
    }
}
