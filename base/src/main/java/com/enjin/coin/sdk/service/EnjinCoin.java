package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.service.notifications.NotificationsService;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsService;

/**
 * <p>Interface for the EnjinCoin sync client.</p>
 */
public interface EnjinCoin {

    /**
     * Method to get the eventsService.
     *
     * @return - EventsService
     */
    EventsService getEventsService();

    /**
     * Method to get the identitiesService.
     *
     * @return - IdentitiesService
     */
    IdentitiesService getIdentitiesService();

    /**
     * Method to get the tokensService.
     *
     * @return - TokensService
     */
    TokensService getTokensService();

    /**
     * Method to get the transactionRequestsService.
     *
     * @return - TransactionRequestsService
     */
    TransactionRequestsService getTransactionRequestsService();

    /**
     * Method to get the notificationsService.
     *
     * @return - NotificationsService
     */
    NotificationsService getNotificationsService();

}
