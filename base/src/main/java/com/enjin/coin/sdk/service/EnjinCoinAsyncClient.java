package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.service.events.impl.EventsAsyncServiceImpl;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
import com.enjin.coin.sdk.service.identities.impl.IdentitiesAsyncServiceImpl;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.service.tokens.impl.TokensAsyncServiceImpl;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin Client - Asynchronous</p>
 * <p>All services will be instantiated from this class that will be called in an asynchronous fashion</p>
 */
public class EnjinCoinAsyncClient implements EnjinCoin {

    private static final Logger LOGGER = Logger.getLogger(EnjinCoinAsyncClient.class.getName());

    private Config enjinConfig;
	private EventsAsyncService eventsServiceAsync;
    private IdentitiesAsyncService identitiesService;
    private TokensAsyncService tokensService;
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
            eventsServiceAsync = new EventsAsyncServiceImpl(enjinConfig);
        }
        return eventsServiceAsync;
    }

    /**
     * Method to get the identitiesService
     *
     * @return - IdentitiesService
     */
    public IdentitiesAsyncService getIdentitiesService() {
        if (identitiesService == null) {
            identitiesService = new IdentitiesAsyncServiceImpl(enjinConfig);
        }
        return identitiesService;
    }

    /**
     * Method to get the tokensService
     *
     * @return - TokensService
     */
    public TokensAsyncService getTokensService() {
        if (tokensService == null) {
            tokensService = new TokensAsyncServiceImpl(enjinConfig);
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
