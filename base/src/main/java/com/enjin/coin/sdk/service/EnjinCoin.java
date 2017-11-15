package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.service.events.EventsService;

/**
 * <p>Interface for the EnjinCoin sync client </p>
 * @author damien
 *
 */
public interface EnjinCoin {

    /**
     * Method to get the eventsService
     *
     * @return - EventsService
     */
    public EventsService getEventsService();

    /**
     * Method to get the identitiesService
     *
     * @return - IdentitiesService
     */
    public IdentitiesService getIdentitiesService();

    /**
     * Method to get the tokensService
     *
     * @return - TokensService
     */
    public TokensService getTokensService();

    /**
     * Method to get the transactionRequestsService
     *
     * @return - TransactionRequestsService
     */
    public TransactionRequestsService getTransactionRequestsService();
	
}
