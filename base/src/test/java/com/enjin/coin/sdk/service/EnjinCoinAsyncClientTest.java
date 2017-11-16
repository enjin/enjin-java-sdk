package com.enjin.coin.sdk.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.service.tokens.TokensService;

public class EnjinCoinAsyncClientTest {

    EnjinCoinAsyncClient enjinCoinAsyncClient;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
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

        //Second time around - the existin service should be returned
        EventsService eventsService2 = enjinCoinAsyncClient.getEventsService();
        assertThat(eventsService2).isNotNull().isSameAs(eventsService);
    }

    @Test
    public void testGetIdentitiesService() {
        IdentitiesService identitiesService = enjinCoinAsyncClient.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        //Second time around - the existin service should be returned
        IdentitiesService identitiesService2 = enjinCoinAsyncClient.getIdentitiesService();
        assertThat(identitiesService2).isNotNull().isSameAs(identitiesService);
    }

    @Test
    public void testGetTokensService() {
        TokensService tokensService = enjinCoinAsyncClient.getTokensService();
        assertThat(tokensService).isNotNull();

        //Second time around - the existin service should be returned
        TokensService tokensService2 = enjinCoinAsyncClient.getTokensService();
        assertThat(tokensService2).isNotNull().isSameAs(tokensService);
    }

    @Test
    public void testGetTransactionRequestsService() {
        TransactionRequestsService transactionRequestsService = enjinCoinAsyncClient.getTransactionRequestsService();
        assertThat(transactionRequestsService).isNotNull();

        //Second time around - the existin service should be returned
        TransactionRequestsService transactionRequestsService2 = enjinCoinAsyncClient.getTransactionRequestsService();
        assertThat(transactionRequestsService2).isNotNull().isSameAs(transactionRequestsService);
    }
}
