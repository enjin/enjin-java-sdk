package com.enjin.coin.sdk.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.EnjinConfig;

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
        assertNotNull(enjinService);
    }
    @Test
    public void testContructor() {
    	enjinService = new EnjinService(enjinConfig);
        assertNotNull(enjinService);
    }
    
    @Test
    public void testGetEventsService() {
    	EventsService eventsService = enjinService.getEventsService();
        assertNotNull(eventsService);
        
        //Second time around - the existin service should be returned
        eventsService = enjinService.getEventsService();
        assertNotNull(eventsService);
    }
    
    @Test
    public void testGetIdentitiesService() {
    	IdentitiesService identitiesService = enjinService.getIdentitiesService();
        assertNotNull(identitiesService);
        
        //Second time around - the existin service should be returned
        identitiesService = enjinService.getIdentitiesService();
        assertNotNull(identitiesService);
    }
    
    @Test
    public void testGetTokensService() {
    	TokensService tokensService = enjinService.getTokensService();
        assertNotNull(tokensService);
        
        //Second time around - the existin service should be returned
        tokensService = enjinService.getTokensService();
        assertNotNull(tokensService);
    }
    
    @Test
    public void testGetTransactionRequestsService() {
    	TransactionRequestsService transactionRequestsService = enjinService.getTransactionRequestsService();
        assertNotNull(transactionRequestsService);
        
        //Second time around - the existin service should be returned
        transactionRequestsService = enjinService.getTransactionRequestsService();
        assertNotNull(transactionRequestsService);
    }
}
