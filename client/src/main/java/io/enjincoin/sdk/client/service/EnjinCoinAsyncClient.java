package io.enjincoin.sdk.client.service;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.EventsAsyncService;
import io.enjincoin.sdk.client.service.events.impl.EventsAsyncServiceImpl;
import io.enjincoin.sdk.client.service.identities.IdentitiesAsyncService;
import io.enjincoin.sdk.client.service.identities.impl.IdentitiesAsyncServiceImpl;
import io.enjincoin.sdk.client.service.notifications.NotificationsAsyncService;
import io.enjincoin.sdk.client.service.notifications.impl.NotificationsAsyncServiceImpl;
import io.enjincoin.sdk.client.service.platform.PlatformAsyncService;
import io.enjincoin.sdk.client.service.platform.impl.PlatformAsyncServiceImpl;
import io.enjincoin.sdk.client.service.tokens.TokensAsyncService;
import io.enjincoin.sdk.client.service.tokens.impl.TokensAsyncServiceImpl;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsAsyncService;
import io.enjincoin.sdk.client.service.transactionrequests.impl.TransactionRequestsAsyncServiceImpl;
import io.enjincoin.sdk.client.util.ObjectUtils;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin Client - Asynchronous.</p>
 * <p>All services will be instantiated from this class that will be called in an asynchronous fashion.</p>
 */
public final class EnjinCoinAsyncClient implements EnjinCoinAsync {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(EnjinCoinAsyncClient.class.getName());

    /**
     * SDK configuration for this client.
     */
    private Config config;
    /**
     * Events async service.
     */
    private EventsAsyncService eventsAsyncService;
    /**
     * Identities async service.
     */
    private IdentitiesAsyncService identitiesAsyncService;
    /**
     * Tokens async service.
     */
    private TokensAsyncService tokensAsyncService;
    /**
     * TransactionRequests async service.
     */
    private TransactionRequestsAsyncService transactionRequestsAsyncService;

    /**
     * Notifications async service.
     */
    private NotificationsAsyncService notificationsAsyncService;

    /**
     * Platform async service.
     */
    private PlatformAsyncService platformAsyncService;

    /**
     * Class constructor.
     *
     * @param config - config to use
     */
    public EnjinCoinAsyncClient(final Config config) {
        if (ObjectUtils.isNull(config)) {
            LOGGER.warning("The supplied config is null.");
            return;
        }

        this.config = config;
    }

    @Override
    public EventsAsyncService getEventsService() {
        if (eventsAsyncService == null) {
            eventsAsyncService = new EventsAsyncServiceImpl(config);
        }
        return eventsAsyncService;
    }

    @Override
    public IdentitiesAsyncService getIdentitiesService() {
        if (identitiesAsyncService == null) {
            identitiesAsyncService = new IdentitiesAsyncServiceImpl(config);
        }
        return identitiesAsyncService;
    }

    @Override
    public TokensAsyncService getTokensService() {
        if (tokensAsyncService == null) {
            tokensAsyncService = new TokensAsyncServiceImpl(config);
        }
        return tokensAsyncService;
    }

    @Override
    public TransactionRequestsAsyncService getTransactionRequestsService() {
        if (transactionRequestsAsyncService == null) {
            transactionRequestsAsyncService = new TransactionRequestsAsyncServiceImpl(config);
        }
        return transactionRequestsAsyncService;
    }

    /**
     * Method to get the notificationsService.
     * @return NotificationsAsyncService
     */
    @Override
    public NotificationsAsyncService getNotificationsService() {
        if (notificationsAsyncService == null) {
            notificationsAsyncService = new NotificationsAsyncServiceImpl(config);
        }
        return notificationsAsyncService;
    }

    /**
     * Method to get the platformService.
     * @return PlatformAsyncService
     */
    @Override
    public PlatformAsyncService getPlatformService() {
        if (platformAsyncService == null) {
            platformAsyncService = new PlatformAsyncServiceImpl(config);
        }
        return platformAsyncService;
    }
}
