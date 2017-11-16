package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsAsyncService;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin Client - Syncs</p>
 * <p>All services will be instantiated from this class that will be called in a synchronous fashion</p>
 *
 * @author damien
 */
public class EnjinCoinAsyncClient implements EnjinCoin {

    private static final Logger LOGGER = Logger.getLogger(EnjinCoinAsyncClient.class.getName());

    private Config enjinConfig;
    private EventsAsyncService eventsServiceAsync;
    private IdentitiesService identitiesService;
    private TokensService tokensService;
    private TransactionRequestsService transactionRequestsService;

    /**
     * Class constructor
     *
     * @param enjinConfig - enjinConfig to use
     */
    public EnjinCoinAsyncClient(Config enjinConfig) {
        if (enjinConfig == null) {
            LOGGER.warning("The enjinConfig passed in is null");
            return;
        }

        this.enjinConfig = enjinConfig;
    }

    /**
     * Method to get the eventsServiceASync
     *
     * @return - EventsServiceAsync
     */
    public EventsAsyncService getEventsService() {
        if (eventsServiceAsync == null) {
            eventsServiceAsync = new EventsAsyncService(enjinConfig);
        }
        return eventsServiceAsync;
    }

    /**
     * Method to get the identitiesService
     *
     * @return - IdentitiesService
     */
    public IdentitiesService getIdentitiesService() {
        if (identitiesService == null) {
            identitiesService = new IdentitiesService(enjinConfig);
        }
        return identitiesService;
    }

    /**
     * Method to get the tokensService
     *
     * @return - TokensService
     */
    public TokensService getTokensService() {
        if (tokensService == null) {
            tokensService = new TokensService(enjinConfig);
        }
        return tokensService;
    }

    /**
     * Method to get the transactionRequestsService
     *
     * @return - TransactionRequestsService
     */
    public TransactionRequestsService getTransactionRequestsService() {
        if (transactionRequestsService == null) {
            transactionRequestsService = new TransactionRequestsService(enjinConfig);
        }
        return transactionRequestsService;
    }
}
