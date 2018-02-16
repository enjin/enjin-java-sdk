package io.enjincoin.sdk.client.config;

import io.enjincoin.sdk.client.util.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationTest {

    private Notification notification;

    @Before
    public void setUp() {
        this.notification = ImmutableNotification.builder().build();
    }

    @Test
    public void testGetAppKey() {
        assertThat(this.notification.getAppKey()).isEqualToIgnoringCase("");
    }

    @Test
    public void testGetCluster() {
        assertThat(this.notification.getCluster()).isEqualToIgnoringCase("");
    }

    @Test
    public void testGetAppChannel() {
        assertThat(this.notification.getAppChannel()).isEqualToIgnoringCase("");
    }

    @Test
    public void testGetActivityTimeout() {
        assertThat(this.notification.getActivityTimeout()).isEqualTo(Constants.FOUR_THOUSAND);
    }


}
