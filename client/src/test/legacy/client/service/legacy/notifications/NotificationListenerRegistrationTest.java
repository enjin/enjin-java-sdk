package io.enjincoin.sdk.client.service.legacy.notifications;

import io.enjincoin.sdk.client.enums.NotificationType;
import io.enjincoin.sdk.client.service.legacy.notifications.NotificationListenerRegistration.RegistrationListenerConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class NotificationListenerRegistrationTest {

    private NotificationListenerRegistration notificationListenerRegistration;

    @Mock
    private NotificationListener mockNotificationListener;
    @Mock
    private NotificationsService mockNotificationsService;

    @Before
    public void setUp() {
        this.notificationListenerRegistration = new NotificationListenerRegistration(this.mockNotificationListener, NotificationListenerRegistration.ALLOW_ALL_MATCHER);
    }

    @Test
    public void testContructor() throws Exception {
        this.notificationListenerRegistration = new NotificationListenerRegistration(this.mockNotificationListener);
        assertThat(this.notificationListenerRegistration).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
        assertThat(this.notificationListenerRegistration.getListener()).isNotNull();
        assertThat(this.notificationListenerRegistration.getEventMatcher()).isNotNull();
    }

    @Test
    public void testContructorWithMatcher() throws Exception {
        this.notificationListenerRegistration = new NotificationListenerRegistration(this.mockNotificationListener, NotificationListenerRegistration.ALLOW_ALL_MATCHER);
        assertThat(this.notificationListenerRegistration).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
        assertThat(this.notificationListenerRegistration.getListener()).isNotNull();
        assertThat(this.notificationListenerRegistration.getEventMatcher()).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testConfigure() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testWithMatcher_EventMatcherIsNull() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        EventMatcher eventMatcher = null;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withMatcher(eventMatcher);
        assertThat(regConfig).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testWithMatcher() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        EventMatcher eventMatcher = NotificationListenerRegistration.ALLOW_ALL_MATCHER;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withMatcher(eventMatcher);
        assertThat(regConfig).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testWithAllowedTypes_NotificationTypeIsNull() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType[] notificationTypes = null;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withAllowedEvents(notificationTypes);
        assertThat(regConfig).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testWithAllowedTypes() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withAllowedEvents(notificationType);
        assertThat(regConfig).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testWithIgnoredEvents_NotificationTypeIsNull() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType[] notificationTypes = null;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withIgnoredEvents(notificationTypes);
        assertThat(regConfig).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testWithIgnoredEvents() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationType notificationType = NotificationType.BALANCE_MELTED;
        RegistrationListenerConfiguration regConfig = registrationListenerConfiguration.withIgnoredEvents(notificationType);
        assertThat(regConfig).isNotNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testRegister_ServiceIsNull() throws Exception {
        this.mockNotificationsService = null;
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationListenerRegistration notificationListenerRegistration = registrationListenerConfiguration.register();
        assertThat(notificationListenerRegistration).isNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testRegister_NotificationListenerIsNull() throws Exception {
        this.mockNotificationListener = null;
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationListenerRegistration notificationListenerRegistration = registrationListenerConfiguration.register();
        assertThat(notificationListenerRegistration).isNull();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testRegister() throws Exception {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();

        NotificationListenerRegistration notificationListenerRegistration = registrationListenerConfiguration.register();
        assertThat(notificationListenerRegistration).isNotNull();
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_ListenerIsNull() {
        this.mockNotificationListener = null;
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_ListenerIsNotNull() {
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, this.mockNotificationListener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_EventFilterAnnotationIsPresentAllowed() {
        NotificationListener listener = new DummyListener1();
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, listener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_EventFilterAnnotationIsPresentNotAllowed() {
        NotificationListener listener = new DummyListener2();
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, listener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testDetectAndApplyListenerAnnotations_EventFilterAnnotationIsNotPresent() {
        NotificationListener listener = new DummyListener3();
        RegistrationListenerConfiguration registrationListenerConfiguration = NotificationListenerRegistration.configure(this.mockNotificationsService, listener);
        assertThat(registrationListenerConfiguration).isNotNull();
    }
}

