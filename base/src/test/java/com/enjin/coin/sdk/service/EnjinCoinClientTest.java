package com.enjin.coin.sdk.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutableNotification;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Notification;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.service.notifications.NotificationsService;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsService;

public class EnjinCoinClientTest {

    EnjinCoinClient enjinCoinClient;
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
    }

    @Test
    public void testContructor_EnjinConfigIsNull() {
        enjinConfig = null;
        enjinCoinClient = new EnjinCoinClient(enjinConfig);
        assertThat(enjinCoinClient).isNotNull();
    }

    @Test
    public void testContructor() {
        enjinCoinClient = new EnjinCoinClient(enjinConfig);
        assertThat(enjinCoinClient).isNotNull();
    }

    @Test
    public void testGetEventsService() {
        EventsService eventsService = enjinCoinClient.getEventsService();
        assertThat(eventsService).isNotNull();

        //Second time around - the existing service should be returned
        EventsService eventsService2 = enjinCoinClient.getEventsService();
        assertThat(eventsService2).isNotNull().isSameAs(eventsService);
    }

    @Test
    public void testGetIdentitiesService() {
        IdentitiesService identitiesService = enjinCoinClient.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        //Second time around - the existing service should be returned
        IdentitiesService identitiesService2 = enjinCoinClient.getIdentitiesService();
        assertThat(identitiesService2).isNotNull().isSameAs(identitiesService);
    }

    @Test
    public void testGetTokensService() {
        TokensService tokensService = enjinCoinClient.getTokensService();
        assertThat(tokensService).isNotNull();

        //Second time around - the existing service should be returned
        TokensService tokensService2 = enjinCoinClient.getTokensService();
        assertThat(tokensService2).isNotNull().isSameAs(tokensService);
    }

    @Test
    public void testGetTransactionRequestsService() {
        TransactionRequestsService transactionRequestsService = enjinCoinClient.getTransactionRequestsService();
        assertThat(transactionRequestsService).isNotNull();

        //Second time around - the existing service should be returned
        TransactionRequestsService transactionRequestsService2 = enjinCoinClient.getTransactionRequestsService();
        assertThat(transactionRequestsService2).isNotNull().isSameAs(transactionRequestsService);
    }


    @Test
    public void testGetNotificationsService() {
        NotificationsService notificationsService = enjinCoinClient.getNotificationsService();
        assertThat(notificationsService).isNotNull();

        //Second time around - the existing service should be returned
        NotificationsService notificationsService2 = enjinCoinClient.getNotificationsService();
        assertThat(notificationsService2).isNotNull().isSameAs(notificationsService);
    }
}
