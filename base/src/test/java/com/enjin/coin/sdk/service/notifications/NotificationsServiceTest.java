package com.enjin.coin.sdk.service.notifications;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
import com.enjin.coin.sdk.service.notifications.impl.NotificationsServiceImpl;
import com.enjin.coin.sdk.service.notifications.impl.PusherNotificationServiceImpl;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.net.ssl.*")
@PrepareForTest({NotificationsServiceImpl.class})
public class NotificationsServiceTest {

    private NotificationsService notificationsService;
    private Config enjinConfig;

    @Mock
    private NotificationListener mockNotificationListener;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
    }
    @Test
    public void testContructor() throws Exception {
        notificationsService = new NotificationsServiceImpl(enjinConfig);
        assertThat(notificationsService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testInitNotificationsService_FailedToInitialize() throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(false);

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isFalse();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @Test
    public void testInitNotificationsService_Success() throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testConfigureListener() throws Exception {
        notificationsService = new NotificationsServiceImpl(enjinConfig);
        RegistrationListenerConfiguration registrationListenerConfiguration = notificationsService.configureListener(mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testAddNotificationListener_ListenerIsNull( ) throws Exception {
        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerRegistration = notificationsService.addNotificationListener(null);
        assertThat(addNotificationListenerRegistration).isNull();
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListener( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerRegistration = notificationsService.addNotificationListener(mockNotificationListener);
        assertThat(addNotificationListenerRegistration).isNotNull();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListener_ListenerAlreadyExists( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerRegistration1 = notificationsService.addNotificationListener(mockNotificationListener);
        assertThat(addNotificationListenerRegistration1).isNotNull();

        NotificationListenerRegistration addNotificationListenerRegistration2 = notificationsService.addNotificationListener(mockNotificationListener);
        assertThat(addNotificationListenerRegistration2).isNull();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListenerWithEventMatcher( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        EventMatcher eventMatcher = NotificationListenerRegistration.ALLOW_ALL_MATCHER;
        NotificationListenerRegistration addNotificationListenerRegistration = notificationsService.addNotificationListener(mockNotificationListener, eventMatcher);
        assertThat(addNotificationListenerRegistration).isNotNull();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testAddAllowedTypesNotificationListener( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        NotificationListenerRegistration addAllowedTypesNotificationListener = notificationsService.addAllowedTypesNotificationListener(mockNotificationListener, notificationType);
        assertThat(addAllowedTypesNotificationListener).isNotNull();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testAddIgnoredTypesNotificationListener( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        NotificationListenerRegistration addIgnoredTypesNotificationListener = notificationsService.addIgnoredTypesNotificationListener(mockNotificationListener, notificationType);
        assertThat(addIgnoredTypesNotificationListener).isNotNull();

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }
    @Test
    public void testRemoveNotificationListener_ListenerIsNull( ) throws Exception {
        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        notificationsService.removeNotificationListener(null);
    }

    @Test
    public void testRemoveNotificationListener_ListenerDoesntExist( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        notificationsService.removeNotificationListener(mockNotificationListener);

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testRemoveNotificationListener_AlreadyExists( ) throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration addNotificationListenerRegistration = notificationsService.addNotificationListener(mockNotificationListener);
        assertThat(addNotificationListenerRegistration).isNotNull();

        notificationsService.removeNotificationListener(mockNotificationListener);

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService, Mockito.times(2)).setNotificationListeners(Mockito.isA(List.class));
    }
    @Test
    public void testAddNotificationListenerRegistration_NotificationListenerRegistrationIsNull () throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = null;
        notificationsService.addNotificationListenerRegistration(notificationListenerRegistration);

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testAddNotificationListenerRegistration () throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener);
        notificationsService.addNotificationListenerRegistration(notificationListenerRegistration);

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }

    @Test
    public void testRemoveNotificationListenerRegistration_NotificationListenerRegistrationIsNull () throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = null;
        notificationsService.removeNotificationListenerRegistration(notificationListenerRegistration);

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testRemoteNotificationListenerRegistration () throws Exception {
        PusherNotificationServiceImpl mockPusherNotificationService = PowerMockito.mock(PusherNotificationServiceImpl.class);

        PowerMockito.whenNew(PusherNotificationServiceImpl.class).withParameterTypes(Notification.class).withArguments(Mockito.isA(Notification.class)).thenReturn(mockPusherNotificationService);
        Mockito.when(mockPusherNotificationService.initializeNotificationService()).thenReturn(true);
        Mockito.doNothing().when(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));

        notificationsService = new NotificationsServiceImpl(enjinConfig);
        boolean result = notificationsService.initNotificationsService();
        assertThat(result).isTrue();

        NotificationListenerRegistration notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener);
        notificationsService.removeNotificationListenerRegistration(notificationListenerRegistration);

        PowerMockito.verifyNew(PusherNotificationServiceImpl.class).withArguments(Mockito.isA(Notification.class));
        Mockito.verify(mockPusherNotificationService).setNotificationListeners(Mockito.isA(List.class));
    }
}
