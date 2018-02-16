package io.enjincoin.sdk.client.enums;

import io.enjincoin.sdk.client.annotations.notifications.EventFilter;
import io.enjincoin.sdk.client.service.notifications.NotificationListener;
import io.enjincoin.sdk.client.vo.notifications.NotificationEvent;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationTypeTest {

    @Test
    public void testIn_True() {
        EventFilter filter = NotificationTypeTestHelper.class.getAnnotation(EventFilter.class);
        assertThat(filter).isNotNull();
        assertThat(NotificationType.IDENTITY_CREATED.in(filter)).isTrue();
    }

    @Test
    public void testIn_False() {
        EventFilter filter = NotificationTypeTestHelper.class.getAnnotation(EventFilter.class);
        assertThat(filter).isNotNull();
        assertThat(NotificationType.IDENTITY_LINKED.in(filter)).isFalse();
    }

    @Test
    public void testIn_Null_False() {
        EventFilter filter = null;
        assertThat(NotificationType.IDENTITY_LINKED.in(filter)).isFalse();
    }

    @Test
    public void testIn_VarArgs_True() {
        EventFilter filter = NotificationTypeTestHelper.class.getAnnotation(EventFilter.class);
        assertThat(filter).isNotNull();
        assertThat(NotificationType.IDENTITY_CREATED.in(NotificationType.IDENTITY_CREATED)).isTrue();
    }

    @Test
    public void testIn_VarArgs_False() {
        EventFilter filter = NotificationTypeTestHelper.class.getAnnotation(EventFilter.class);
        assertThat(filter).isNotNull();
        assertThat(NotificationType.IDENTITY_CREATED.in(NotificationType.IDENTITY_LINKED)).isFalse();
    }

    @Test
    public void testValueOfEnum_Matched() {
        assertThat(NotificationType.valueOfEnum("IDENTITY_CREATED")).isEqualTo(NotificationType.IDENTITY_CREATED);
    }

    @Test
    public void testValueOfEnum_UnknownEvent() {
        assertThat(NotificationType.valueOfEnum("")).isEqualTo(NotificationType.UNKNOWN_EVENT);
    }

    @EventFilter(value = NotificationType.IDENTITY_CREATED)
    public static class NotificationTypeTestHelper implements NotificationListener {

        @Override
        public void notificationReceived(NotificationEvent event) {
            // Do Nothing
        }

    }
}
