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
import com.enjin.coin.sdk.util.ObjectUtils;

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
     * Events service.
     */
    private EventsService eventsService;
    /**
     * Identities service.
     */
    private IdentitiesService identitiesService;
    /**
     * Tokens service.
     */
    private TokensService tokensService;
    /**
     * TransactionRequests service.
     */
    private TransactionRequestsService transactionRequestsService;

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
    public TransactionRequestsService getTransactionRequestsService() {
        if (transactionRequestsService == null) {
            transactionRequestsService = new TransactionRequestsServiceImpl(config);
        }
        return transactionRequestsService;
    }

}
