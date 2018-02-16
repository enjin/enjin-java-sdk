package io.enjincoin.sdk.client.service;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.EventsService;
import io.enjincoin.sdk.client.service.events.impl.EventsServiceImpl;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
import io.enjincoin.sdk.client.service.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.notifications.impl.NotificationsServiceImpl;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import io.enjincoin.sdk.client.service.tokens.TokensService;
import io.enjincoin.sdk.client.service.tokens.impl.TokensServiceImpl;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsService;
import io.enjincoin.sdk.client.service.transactionrequests.impl.TransactionRequestsServiceImpl;
import io.enjincoin.sdk.client.util.ObjectUtils;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin Client - Synchronous.</p>
 * <p>All services will be instantiated from this class that will be called in a synchronous fashion.</p>
 */
public class EnjinCoinClient implements EnjinCoin {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(EnjinCoinClient.class.getName());

    /**
     * SDK configuration for this client.
     */
    private Config config;
    /**
     * Events sync service.
     */
    private EventsService eventsService;
    /**
     * Identities sync service.
     */
    private IdentitiesService identitiesService;
    /**
     * Tokens sync service.
     */
    private TokensService tokensService;
    /**
     * TransactionRequests sync service.
     */
    private TransactionRequestsService transactionRequestsService;

    /**
     * Notifications sync service.
     */
    private NotificationsService notificationsService;

    /**
     * Platform sync service.
     */
    private PlatformService platformService;

    /**
     * Class constructor.
     *
     * @param config - config to use
     */
    public EnjinCoinClient(final Config config) {
        if (ObjectUtils.isNull(config)) {
            LOGGER.warning("The supplied config is null.");
            return;
        }

        this.config = config;
    }

    /**
     * Method to get the EventService.
     *
     * @return - EventsService
     */
    @Override
    public EventsService getEventsService() {
        if (eventsService == null) {
            eventsService = new EventsServiceImpl(config);
        }
        return eventsService;
    }

    /**
     * Method to get the IdentitiesService.
     *
     * @return - IdentitiesService
     */
    @Override
    public IdentitiesService getIdentitiesService() {
        if (identitiesService == null) {
            identitiesService = new IdentitiesServiceImpl(config);
        }
        return identitiesService;
    }

    /**
     * Method to get the TokensService.
     *
     * @return - TokensService
     */
    @Override
    public TokensService getTokensService() {
        if (tokensService == null) {
            tokensService = new TokensServiceImpl(config);
        }
        return tokensService;
    }

    /**
     * Method to get the TransactionRequestsService.
     *
     * @return - TransactionRequestsService
     */
    @Override
    public TransactionRequestsService getTransactionRequestsService() {
        if (transactionRequestsService == null) {
            transactionRequestsService = new TransactionRequestsServiceImpl(config);
        }
        return transactionRequestsService;
    }

    /**
     * Method to get the notificationsService.
     * @return NotificationsService
     */
    @Override
    public NotificationsService getNotificationsService() {
        if (notificationsService == null) {
            notificationsService = new NotificationsServiceImpl(config);
        }
        return notificationsService;
    }

    /**
     * Method to get the platformService.
     * @return PlatformService
     */
    @Override
    public PlatformService getPlatformService() {
        if (platformService == null) {
            platformService = new PlatformServiceImpl(config);
        }
        return platformService;
    }
}
