package com.enjin.coin.sdk.service.notifications;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.enjin.coin.sdk.enums.NotificationType;
import com.enjin.coin.sdk.service.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;

@RunWith(MockitoJUnitRunner.class)
public class NotificationListenerRegistrationTest {

    private NotificationListenerRegistration notificationListenerRegistration;

    @Mock
    private NotificationListener mockNotificationListener;
    @Mock
    private NotificationsService mockNotificationsService;

    @Before
    public void setUp() {
        notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener, NotificationListenerRegistration.ALLOW_ALL_MATCHER);
    }
    @Test
    public void testContructor() throws Exception {
        notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener);
        assertThat(notificationListenerRegistration).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
        assertThat(notificationListenerRegistration.getListener()).isNotNull();
        assertThat(notificationListenerRegistration.getEventMatcher()).isNotNull();
    }
    @Test
    public void testContructorWithMatcher() throws Exception {
        notificationListenerRegistration = new NotificationListenerRegistration(mockNotificationListener, NotificationListenerRegistration.ALLOW_ALL_MATCHER);
        assertThat(notificationListenerRegistration).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
        assertThat(notificationListenerRegistration.getListener()).isNotNull();
        assertThat(notificationListenerRegistration.getEventMatcher()).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testConfigure() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testWithMatcher_EventMatcherIsNull() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        EventMatcher eventMatcher = null;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withMatcher(eventMatcher);
        assertThat(regConfig).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testWithMatcher() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        EventMatcher eventMatcher = NotificationListenerRegistration.ALLOW_ALL_MATCHER;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withMatcher(eventMatcher);
        assertThat(regConfig).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testWithAllowedTypes_NotificationTypeIsNull() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType[] notificationTypes = null;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withAllowedEvents(notificationTypes);
        assertThat(regConfig).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testWithAllowedTypes() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withAllowedEvents(notificationType);
        assertThat(regConfig).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testWithIgnoredEvents_NotificationTypeIsNull() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType[] notificationTypes = null;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withIgnoredEvents(notificationTypes);
        assertThat(regConfig).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testWithIgnoredEvents() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withIgnoredEvents(notificationType);
        assertThat(regConfig).isNotNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testRegister_ServiceIsNull() throws Exception {
        mockNotificationsService = null;
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationListenerRegistration notificationListenerRegistration = registrationListenerConfiguration.register();
        assertThat(notificationListenerRegistration).isNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testRegister_NotificationListenerIsNull() throws Exception {
        mockNotificationListener = null;
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationListenerRegistration notificationListenerRegistration = registrationListenerConfiguration.register();
        assertThat(notificationListenerRegistration).isNull();
    }
    @SuppressWarnings({ "rawtypes"})
    @Test
    public void testRegister() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationListenerRegistration notificationListenerRegistration = registrationListenerConfiguration.register();
        assertThat(notificationListenerRegistration).isNotNull();
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_ListenerIsNull() {
        mockNotificationListener = null;
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_ListenerIsNotNull() {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_EventFilterAnnotationIsPresentAllowed() {
        NotificationListener listener = new DummyListener1();
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, listener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_EventFilterAnnotationIsPresentNotAllowed() {
        NotificationListener listener = new DummyListener2();
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, listener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_EventFilterAnnotationIsNotPresent() {
        NotificationListener listener = new DummyListener3();
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(mockNotificationsService, listener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
}

