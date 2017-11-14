package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class EnjinServiceTest {

    EnjinService enjinService;
    EnjinConfig enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new EnjinConfig();
        enjinService = new EnjinService(enjinConfig);
    }

    @Test
    public void testContructor_EnjinConfigIsNull() {
        enjinConfig = null;
        enjinService = new EnjinService(enjinConfig);
        assertThat(enjinService).isNotNull();
    }

    @Test
    public void testContructor() {
        enjinService = new EnjinService(enjinConfig);
        assertThat(enjinService).isNotNull();
    }

    @Test
    public void testGetEventsService() {
        EventsService eventsService = enjinService.getEventsService();
        assertThat(eventsService).isNotNull();

        //Second time around - the existin service should be returned
        EventsService eventsService2 = enjinService.getEventsService();
        assertThat(eventsService2).isNotNull().isSameAs(eventsService);
    }

    @Test
    public void testGetIdentitiesService() {
        IdentitiesService identitiesService = enjinService.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        //Second time around - the existin service should be returned
        IdentitiesService identitiesService2 = enjinService.getIdentitiesService();
        assertThat(identitiesService2).isNotNull().isSameAs(identitiesService);
    }

    @Test
    public void testGetTokensService() {
        TokensService tokensService = enjinService.getTokensService();
        assertThat(tokensService).isNotNull();

        //Second time around - the existin service should be returned
        TokensService tokensService2 = enjinService.getTokensService();
        assertThat(tokensService2).isNotNull().isSameAs(tokensService);
    }

    @Test
    public void testGetTransactionRequestsService() {
        TransactionRequestsService transactionRequestsService = enjinService.getTransactionRequestsService();
        assertThat(transactionRequestsService).isNotNull();

        //Second time around - the existin service should be returned
        TransactionRequestsService transactionRequestsService2 = enjinService.getTransactionRequestsService();
        assertThat(transactionRequestsService2).isNotNull().isSameAs(transactionRequestsService);
    }
}
