package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.service.tokens.TokensService;

/**
 * <p>Interface for the EnjinCoin sync client </p>
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
