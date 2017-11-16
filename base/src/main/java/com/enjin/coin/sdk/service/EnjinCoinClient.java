package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.service.events.impl.EventsServiceImpl;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.service.identities.impl.IdentitiesServiceImpl;
import com.enjin.coin.sdk.service.tokens.TokensService;
import com.enjin.coin.sdk.service.tokens.impl.TokensServiceImpl;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsService;
import com.enjin.coin.sdk.service.transactionrequests.impl.TransactionRequestsServiceImpl;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin Client - Synchronous</p>
 * <p>All services will be instantiated from this class that will be called in a synchronous fashion</p>
 */
public class EnjinCoinClient implements EnjinCoin {

    private static final Logger LOGGER = Logger.getLogger(EnjinCoinClient.class.getName());

    private Config enjinConfig;
    private EventsService eventsService;
    private IdentitiesService identitiesService;
    private TokensService tokensService;
    private TransactionRequestsService transactionRequestsService;

    /**
     * Class constructor
     *
     * @param enjinConfig - enjinConfig to use
     */
    public EnjinCoinClient(Config enjinConfig) {
        if (enjinConfig == null) {
            LOGGER.warning("The enjinConfig passed in is null");
            return;
        }

        this.enjinConfig = enjinConfig;
    }

    /**
     * Method to get the eventsService
     *
     * @return - EventsService
     */
    public EventsService getEventsService() {
        if (eventsService == null) {
            eventsService = new EventsServiceImpl(enjinConfig);
        }
        return eventsService;
    }

    /**
     * Method to get the identitiesService
     *
     * @return - IdentitiesService
     */
    public IdentitiesService getIdentitiesService() {
        if (identitiesService == null) {
            identitiesService = new IdentitiesServiceImpl(enjinConfig);
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
            tokensService = new TokensServiceImpl(enjinConfig);
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
            transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        }
        return transactionRequestsService;
    }
}
