package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.Config;

import java.util.logging.Logger;

/**
 * <p>Main Service class</p>
 * <p>All services will be instantiated from this class</p>
 * @author damien
 *
 */
public class EnjinService {

    private static final Logger LOGGER = Logger.getLogger(EnjinService.class.getName());

    private Config enjinConfig;
    private EventsService eventsService;
    private IdentitiesService identitiesService;
    private TokensService tokensService;
    private TransactionRequestsService transactionRequestsService;

    /**
     * Class constructor
     * @param enjinConfig - enjinConfig to use
     */
    public EnjinService(Config enjinConfig) {
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
            eventsService = new EventsService(enjinConfig);
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
