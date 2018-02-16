package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.events.EventsService;
import io.enjincoin.sdk.client.service.events.SynchronousEventsService;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.SynchronousIdentitiesService;
import io.enjincoin.sdk.client.service.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.service.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.service.tokens.SynchronousTokensService;
import io.enjincoin.sdk.client.service.tokens.TokensService;
import io.enjincoin.sdk.client.service.transactionrequests.SynchronousTransactionRequestsService;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsService;

/**
 * <p>Interface for the SyncClient create client.</p>
 */
public interface Client {

    /**
     * Method to get the eventsService.
     *
     * @return - SynchronousEventsService
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

    /**
     * Method to get the platformService.
     *
     * @return - PlatformService
     */
    PlatformService getPlatformService();
}
