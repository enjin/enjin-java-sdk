package com.enjin.coin.sdk.service;

import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.service.events.impl.EventsAsyncServiceImpl;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
import com.enjin.coin.sdk.service.identities.impl.IdentitiesAsyncServiceImpl;
import com.enjin.coin.sdk.service.notifications.NotificationsAsyncService;
import com.enjin.coin.sdk.service.notifications.impl.NotificationsAsyncServiceImpl;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.service.tokens.impl.TokensAsyncServiceImpl;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsAsyncService;
import com.enjin.coin.sdk.service.transactionrequests.impl.TransactionRequestsAsyncServiceImpl;
import com.enjin.coin.sdk.util.ObjectUtils;

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
     * @return NotificationsService
     */
    @Override
    public NotificationsAsyncService getNotificationsService() {
        if (notificationsAsyncService == null) {
            notificationsAsyncService = new NotificationsAsyncServiceImpl(config);
        }
        return notificationsAsyncService;
    }
}
