package com.damien.test.TOBEREMOVED;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutableNotification;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.service.EnjinCoinAsyncClient;
import com.enjin.coin.sdk.service.EnjinCoinClient;
import com.enjin.coin.sdk.service.notifications.NotificationListener;
import com.enjin.coin.sdk.service.notifications.NotificationsService;

public class ListenerTest {

    EnjinCoinClient enjinCoinClient;
    EnjinCoinAsyncClient enjinCoinAsyncClient;
    Config enjinConfig;

    @Before
    public void setUp() {
        Notification notification = ImmutableNotification.builder()
                .setActivityTimeout(4000l)
                .setAppChannel("testChannel")
                .setAppId("437770")
                .setAppKey("505648a2c40940a286e2")
                .setAppSecret("f4fbf11d052fe6a64988")
                .setCluster("eu")
                .build();
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .build();

        enjinConfig = ImmutableConfig.builder()
                .setInTestMode(false)
                .setNotification(notification)
                .setTotalExecutors(1)
                .setTrustedPlatform(trustedPlatform)
                .build();

        enjinCoinClient = new EnjinCoinClient(enjinConfig);
        enjinCoinAsyncClient = new EnjinCoinAsyncClient(enjinConfig);
    }

    @Test
    public void testGetNotificationsAsyncService() {
        NotificationsService notificationsService = enjinCoinAsyncClient.getNotificationsService();
        assertThat(notificationsService).isNotNull();

        NotificationListener notificationListener1 = new NotificationListenerImpl();

        notificationsService.addNotificationListener(notificationListener1);

        int a =1;
        int b=0;
        while (a > b) {

        }
    }

    @Ignore
    @Test
    public void testGetNotificationsService() {
        NotificationsService notificationsService = enjinCoinClient.getNotificationsService();
        assertThat(notificationsService).isNotNull();

        NotificationListener notificationListener1 = new NotificationListenerImpl();

        notificationsService.addNotificationListener(notificationListener1);

        int a =1;
        int b=0;
        while (a > b) {

        }
    }

}
