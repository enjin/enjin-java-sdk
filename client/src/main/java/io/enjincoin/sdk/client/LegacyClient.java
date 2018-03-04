package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.legacy.events.EventsService;
import io.enjincoin.sdk.client.service.legacy.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.legacy.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.legacy.platform.PlatformService;
import io.enjincoin.sdk.client.service.legacy.tokens.TokensService;
import io.enjincoin.sdk.client.service.legacy.transactionrequests.TransactionRequestsService;

/**
 * <p>Interface for the SyncClient create client.</p>
 */
public interface LegacyClient {

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

    /**
     * Closes all active resources.
     */
    void close();
}
