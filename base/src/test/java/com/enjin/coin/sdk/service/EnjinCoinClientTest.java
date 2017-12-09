package com.enjin.coin.sdk.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.config.ImmutablePlatform;
import com.enjin.coin.sdk.config.Platform;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.service.notifications.NotificationsService;
import com.enjin.coin.sdk.service.platform.PlatformService;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsService;

public class EnjinCoinClientTest {

    EnjinCoinClient enjinCoinClient;
    Config enjinConfig;

    @Before
    public void setUp() {
        Platform trustedPlatform = ImmutablePlatform.builder()
                .setHost("localhost")
                .setPort(80)
                .setProtocol("http")
                .build();

        enjinConfig = ImmutableConfig.builder()
                .setInTestMode(false)
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

    @Test
    public void testGetPlatformService() {
        PlatformService platformService = enjinCoinClient.getPlatformService();
        assertThat(platformService).isNotNull();

        //Second time around - the existing service should be returned
        PlatformService platformService2 = enjinCoinClient.getPlatformService();
        assertThat(platformService2).isNotNull().isSameAs(platformService2);
    }
}
