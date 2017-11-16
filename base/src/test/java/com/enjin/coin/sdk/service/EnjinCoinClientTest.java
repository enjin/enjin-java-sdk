package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.impl.EventsServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnjinCoinClientTest {

    EnjinCoinClient enjinCoinClient;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
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
        EventsServiceImpl eventsService = enjinCoinClient.getEventsService();
        assertThat(eventsService).isNotNull();

        //Second time around - the existin service should be returned
        EventsServiceImpl eventsService2 = enjinCoinClient.getEventsService();
        assertThat(eventsService2).isNotNull().isSameAs(eventsService);
    }

    @Test
    public void testGetIdentitiesService() {
        IdentitiesService identitiesService = enjinCoinClient.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        //Second time around - the existin service should be returned
        IdentitiesService identitiesService2 = enjinCoinClient.getIdentitiesService();
        assertThat(identitiesService2).isNotNull().isSameAs(identitiesService);
    }

    @Test
    public void testGetTokensService() {
        TokensService tokensService = enjinCoinClient.getTokensService();
        assertThat(tokensService).isNotNull();

        //Second time around - the existin service should be returned
        TokensService tokensService2 = enjinCoinClient.getTokensService();
        assertThat(tokensService2).isNotNull().isSameAs(tokensService);
    }

    @Test
    public void testGetTransactionRequestsService() {
        TransactionRequestsService transactionRequestsService = enjinCoinClient.getTransactionRequestsService();
        assertThat(transactionRequestsService).isNotNull();

        //Second time around - the existin service should be returned
        TransactionRequestsService transactionRequestsService2 = enjinCoinClient.getTransactionRequestsService();
        assertThat(transactionRequestsService2).isNotNull().isSameAs(transactionRequestsService);
    }
}
