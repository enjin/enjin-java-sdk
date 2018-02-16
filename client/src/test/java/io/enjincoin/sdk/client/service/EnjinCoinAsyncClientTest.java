package io.enjincoin.sdk.client.service;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.EventsService;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.service.tokens.TokensService;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnjinCoinAsyncClientTest {

    EnjinCoinAsyncClient enjinCoinAsyncClient;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
        enjinCoinAsyncClient = new EnjinCoinAsyncClient(enjinConfig);
    }

    @Test
    public void testContructor_EnjinConfigIsNull() {
        enjinConfig = null;
        enjinCoinAsyncClient = new EnjinCoinAsyncClient(enjinConfig);
        assertThat(enjinCoinAsyncClient).isNotNull();
    }

    @Test
    public void testContructor() {
        enjinCoinAsyncClient = new EnjinCoinAsyncClient(enjinConfig);
        assertThat(enjinCoinAsyncClient).isNotNull();
    }

    @Test
    public void testGetEventsService() {
        EventsService eventsService = enjinCoinAsyncClient.getEventsService();
        assertThat(eventsService).isNotNull();

        //Second time around - the existing service should be returned
        EventsService eventsService2 = enjinCoinAsyncClient.getEventsService();
        assertThat(eventsService2).isNotNull().isSameAs(eventsService);
    }

    @Test
    public void testGetIdentitiesService() {
        IdentitiesService identitiesService = enjinCoinAsyncClient.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        //Second time around - the existing service should be returned
        IdentitiesService identitiesService2 = enjinCoinAsyncClient.getIdentitiesService();
        assertThat(identitiesService2).isNotNull().isSameAs(identitiesService);
    }

    @Test
    public void testGetTokensService() {
        TokensService tokensService = enjinCoinAsyncClient.getTokensService();
        assertThat(tokensService).isNotNull();

        //Second time around - the existing service should be returned
        TokensService tokensService2 = enjinCoinAsyncClient.getTokensService();
        assertThat(tokensService2).isNotNull().isSameAs(tokensService);
    }

    @Test
    public void testGetTransactionRequestsService() {
        TransactionRequestsService transactionRequestsService = enjinCoinAsyncClient.getTransactionRequestsService();
        assertThat(transactionRequestsService).isNotNull();

        //Second time around - the existing service should be returned
        TransactionRequestsService transactionRequestsService2 = enjinCoinAsyncClient.getTransactionRequestsService();
        assertThat(transactionRequestsService2).isNotNull().isSameAs(transactionRequestsService);
    }

    @Test
    public void testGetNotificationsService() {
        NotificationsService notificationsService = enjinCoinAsyncClient.getNotificationsService();
        assertThat(notificationsService).isNotNull();

        //Second time around - the existing service should be returned
        NotificationsService notificationsService2 = enjinCoinAsyncClient.getNotificationsService();
        assertThat(notificationsService2).isNotNull().isSameAs(notificationsService);
    }

    @Test
    public void testGetPlatformService() {
        PlatformService platformService = enjinCoinAsyncClient.getPlatformService();
        assertThat(platformService).isNotNull();

        //Second time around - the existing service should be returned
        PlatformService platformService2 = enjinCoinAsyncClient.getPlatformService();
        assertThat(platformService2).isNotNull().isSameAs(platformService2);
    }
}
