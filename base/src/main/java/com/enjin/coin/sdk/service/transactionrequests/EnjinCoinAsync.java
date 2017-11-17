package com.enjin.coin.sdk.service.transactionrequests;

import com.enjin.coin.sdk.service.EnjinCoin;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;

/**
 * <p>Interface for the EnjinCoin async client.</p>
 */
public interface EnjinCoinAsync extends EnjinCoin {

    /**
     * Method to get the eventsService.
     *
     * @return - EventsAsyncService
     */
    @Override
    EventsAsyncService getEventsService();

    /**
     * Method to get the identitiesService.
     *
     * @return - IdentitiesAsyncService
     */
    @Override
    IdentitiesAsyncService getIdentitiesService();

    /**
     * Method to get the tokensService.
     *
     * @return - TokensAsyncService
     */
    @Override
    TokensAsyncService getTokensService();

    /**
     * Method to get the transactionRequestsService.
     *
     * @return - TransactionRequestsAsyncService
     */
    @Override
    TransactionRequestsAsyncService getTransactionRequestsService();

}
