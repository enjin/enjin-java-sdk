package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.impl.EventServiceImpl;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin Client - Syncs</p>
 * <p>All services will be instantiated from this class that will be called in a synchronous fashion</p>
 *
 * @author damien
 */
public class EnjinCoinClient implements EnjinCoin {

    private static final Logger LOGGER = Logger.getLogger(EnjinCoinClient.class.getName());

    private Config enjinConfig;
    private EventServiceImpl eventsService;
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
    public EventServiceImpl getEventsService() {
        if (eventsService == null) {
            eventsService = new EventServiceImpl(enjinConfig);
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
